$(function() {
	ajax_init();
	var userid = $('#loginp').text().toString();
	ajax_trolley_update(userid,-1,-1);

	//题目排序
    $('#sortable').sortable();
    $('#sortable').disableSelection();

	//回滚置顶置底
	$('#toTOP').click(function() {
		$('body').animate({'scrollTop':0},1000);
	});

	$('#toBottom').click(function(){
  		$('html,body').animate({scrollTop:$('.footer').offset().top},2000);
 	});

	//右侧菜单栏
	$('.pinned').pin({
		midWidth:100
	});
});


function ajax_init(){//初始化左边信息栏
	var name='';
	var authority='';
	var joinTime='';
	var info='';
	var userid= $('#loginp').text().toString();
	$.ajax({
		type:"POST",
		url:"/user",
		data:{
			id:userid
		},
		success:function(res){
			name=res.data.name;
			authority=res.data.authority;
			joinTime=res.data.joinTime;
			var online = res.data.online;
			info+='<table data-id="userinfo">'+
					'<tr><td><div><center><img src="/img/4.png" alt="用户头像" class="img-circle" height="170" ></center></div></td></tr>'+
					'<tr>'+
						'<td>'+
							'<h2>个人信息<br><small>用户名：'+name+'</small><br><small>等级：'+authority+'</small><br><small>注册时间：'+joinTime+'</small><br></h2>'+
							'<a href="#/userinfo"><button type="button" class="btn btn-info btn-xs btn-block">详细信息</button></a>'+
						'</td>'+
					'</tr>'+
					'<tr><td><br></td></tr>'+
					'<tr>'+
						'<td>'+
							'<a id="manageButton1" href="#/admin"><button type="button" class="btn btn-success btn-xs btn-block">管理员界面</button></a>'+
							'<a id="manageButton2" href="#/admin"><button type="button" class="btn btn-success btn-xs btn-block" data-toggle="tooltip" data-placement="right" title="已有管理员在操作！">管理员界面</button></a>'+
						'</td>'+
					'</tr>'+
					'<tr><td><hr></td></tr>'+
				  '</table>';
		    $('.personinfo').empty().html(info);
			if(authority !== 'A') {
				$('#manageButton1').hide();
				$('#manageButton2').hide();
			}
			if(online === 0) {
				$('#manageButton1').hide();
				$('#manageButton2').click(function () {
					return false;
				});
			}
			if(online === 1) {
				$('#manageButton2').hide();
			}


		}
	});
}
function ajax_trolley_update(userid,Curpage,Sumpage){
	$.ajax({
		type:"POST",
		url:"/trolley/personal",
		data:{
			id:userid,
			currentPage:Curpage,
		    allPages:Sumpage,
		},
		success:function(res){

			if (res.code === '0') {
				$('.problem').empty().html('<h3><small>您还没有添加任何题目</small></h3>');
				$('.pagination').empty();
			}
			else{
				var problemAmount = res.data.currentSum;
				var curpage = res.data.currentPage;
				var sumpage = res.data.allPages;
				if(curpage > sumpage){
					curpage = sumpage;
				}
				$('.problem').empty();
				var pid;
				var dif;
				var content = '';

				for (var i=0;i<problemAmount;i++){
					pid = res.data.problemInfoList[i].pid;
					dif = res.data.problemInfoList[i].difficulty;
					content += '<div class="row">' +
									'<div class="col-sm-12 col-md-12">' +
										'<div class="thumbnail">' +
											'<img src="/ProblemBank/Problem/' + pid + '.png" alt="...">' +
											'<div class="caption">' +
												'<p>这是第' + (i+1) + '道题</p>' +
												'<p>这道题的难度为' + dif + '</p>' +
												'<p>' +
													'<a href="#" id="' + pid + '" class="btn btn-danger deleteproblem" role="button">从我的Trolley中删除此题</a>' +
												'</p>' +
											'</div>' +
										'</div>' +
									'</div>' +
								'</div>';
				}
				$('.problem').html(content);
				PageConversion(curpage,sumpage);
				//NextPage();
			}
		}
	});
}
function PageConversion(Curpage,Sumpage){
	var pagination='<li class="active"><a href="">1</a></li>';
	for (var i = 0; i < Sumpage-1; i++){
		if( (i+2) == Curpage ){
			pagination += '<li class="currentpage"><a href="">' + (i+2) + '</a></li>';
		}
		else{
			pagination += '<li><a href="">' + (i+2) + '</a></li>';
		}
	}
	$('.pagination').empty().html(pagination);
	$('.currentpage').addClass('active').siblings().removeClass('active');
	DeleteProblem();
	NextPage();
}
function NextPage(){
	$('.pagination>li').click(function(){
		var index = $(this).index()
		var OldPage = $('.pagination').find('li[class=active]').index();
		if (index === OldPage){
			// var CurPage = index + 1;
			// var SumPage = $('.pagination').children().length;
			return false;
		}
		else {
			$(this).addClass('active').siblings().removeClass('active');
			var CurPage = index + 1;
			var SumPage = $('.pagination').children().length;
			var userid = $('#loginp').text().toString();
			ajax_trolley_update(userid,CurPage,SumPage);
		}

		return false;
	});
}
function DeleteProblem(){
	$('.deleteproblem').click(function(){
		var userid = $('#loginp').text().toString();
		var pid = $(this).attr("id");
		var Curpage = $('.pagination').find('li[class=active]').index() + 1 ;
		$.ajax({
			type:"POST",
			url:"/trolley/deleteProblem",
			data:{
				pid:pid,
				id:userid,
			},
			success:function(res){

			}
		});
		DeleteProblem_(userid,Curpage);
		return false;
	});
}

function DeleteProblem_(userid,Curpage){
	var Sumpage = '';
	$.ajax({
		type:"POST",
		url:"/trolley/personal",
		data:{
			id:userid,
			currentPage:-1,
			allPages:-1,
		},
		success:function(res){
			if(res.code>0){
				Sumpage = res.data.allPages;
				ajax_trolley_update(userid,Curpage,Sumpage);
			}
			else
			{
				ajax_trolley_update(userid,1,1);
			}
		}
	});
}


