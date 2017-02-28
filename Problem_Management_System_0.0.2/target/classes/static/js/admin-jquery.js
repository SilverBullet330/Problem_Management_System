
$(function() {
	//var AdminName = $('#loginp').text().toString();	//获取管理员name,全局
	//const AdminName
	var SumUserAmount = '';
	CurUserList(-1,-1);
	DelUserList();
});


// res的数据结构
// {
// 	code:0/1,
// 	data:{
// 		currentSum:n,
// 		sum:n,
// 		page:{
// 			currentPage:n,
// 			allPages:n
// 		},
// 		userInfoList:[
// 			{
// 				id:id,
// 				joinTime:time,
// 				name:name
// 			},
// 			{
// 				id:id,
// 				joinTime:time,
// 				name:name
// 			}
// 		]
// 	}
// }

//当前用户列表
function CurUserList(CurPage, SumPage) {
	$.ajax({				
		type:'POST',
		url:'/allUserInfo',
		data:{
			currentPage:CurPage,
			allPages:SumPage
		},
		success:function(res){
			SumUserAmount = res.data.sum;		//获取总用户数量并赋值给全局变量
			var UserAmount = res.data.currentSum;
			var CurPage = res.data.page.currentPage;
			var SumPage = res.data.page.allPages;
			var content1 = '<table class="table table-striped">' +
							'<tr>' +
								'<td><h4>ID</h4></td>' +
								'<td><h4>用户名</h4></td>' +
								'<td><h4>注册时间</h4></td>' +
								'<td><h4>操作</h4></td>' +
							'</tr>';
			var content2 = '';
			var content3 = '</table>'
			for(var i = 0; i < UserAmount; i++) {
				var id = res.data.userInfoList[i].id;
				var name = res.data.userInfoList[i].name;
				var time = res.data.userInfoList[i].joinTime;
				content2 += '<tr>' +
								'<td>' + id + '</td>' +
								'<td>' + name + '</td>' +
								'<td>' + time + '</td>' +
								'<td><button type="button" class="DeleteUser btn btn-danger btn-sm">删除用户</button></td>' +
							'</tr>';
			}
			var content = content1 + content2 + content3;
			$('#CurUserList').empty().html(content);

			
			PageInit(CurPage, SumPage);

			PageConversion();

			DeleteUser();
		},
		error:function(res){
			alert('error:' + res.responseText);
		}
	});
}

// {
// 	code:0/1,
// 	data:{
// 		currentSum:,
//		userInfoList:{
//			id:,
//			time:,
//			name:
//		}
// 	}
	
// }

//已删除用户列表
function DelUserList() {
	$.ajax({
		type:'POST',
		url:'/allDeletedUserInfo',
		success:function(res){
			var DelUserAmount;
			if (res.code === '1')
				DelUserAmount = 0;
			else
				DelUserAmount = res.data.sum;
			var content1 = '<table class="table table-striped">' +
								'<tr>' +
									'<td><h4>ID</h4></td>' +
									'<td><h4>用户名</h4></td>' +
									'<td><h4>删除时间</h4></td>' +
									'<td><h4>操作</h4></td>' +
								'</tr>';
			var content2 = '';
			var content3 = '</table>';
			for(var i = 0; i < DelUserAmount; i++) {
				var id = res.data.userDeletedList[i].id;
				var name = res.data.userDeletedList[i].name;
				var time = res.data.userDeletedList[i].deleteTime;
				content2 += '<tr>' +
								'<td>' + id + '</td>' +
								'<td>' + name + '</td>' +
								'<td>' + time + '</td>' +
								'<td><button type="button" class="RecoverUser btn btn-success btn-sm">恢复用户</button></td>' +
							'</tr>';
			}
			var content = content1 + content2 + content3;
			$('#DelUserList').empty().html(content);
			RecoverUser();

		},
		error:function(res){
			alert('error:' + res.responseText);
		}
	});
}

//删除用户
function DeleteUser() {
	$('.DeleteUser').click(function() {
		var id = $(this).parent().parent().find('td').first().text();	//获取ID值
		var AdminName = $('#loginp').text().toString();
		$.ajax({
			type:'POST',
			url:'/userDelete',
			data:{
				handleId:AdminName,
				id:id
			},
			success:function(res) {
				var SumPage = $('.pagination').children().length;
				var OldPage = $('.pagination').find('li[class=active]').index() + 1;//获取高亮页码数
				if (SumUserAmount % 9 === 1) {		//总题目数量余1则总页码数需-1			
					if (OldPage === SumPage) 		//若当前页码为最后一页则需-1
						OldPage -= 1;
					SumPage -= 1;
				}
				CurUserList(OldPage,SumPage);
				DelUserList();
			},
			error:function(res) {
				alert('error:' + res.responseText);
			}
		})
	});
}

//恢复用户
function RecoverUser() {
	$('.RecoverUser').click(function() {
		var id = $(this).parent().parent().find('td').first().text();
		$.ajax({
			type:'POST',
			url:'/userRecover',
			data:{
				id:id
			},
			success:function(res) {
				CurUserList(-1,-1);
				DelUserList();
			},
			error:function(res) {
				alert('error' + responseText);
			}
		})
	});
}

//每次进行删除用户时页码的初始化
function PageInit(CurPage, SumPage) {
	var pagination = '';
	for (var i = 0; i < SumPage; i++)
		pagination += '<li><a href="">' + (i + 1) + '</a></li>';
	$('.pagination').empty().html(pagination);
	//判断页码是否改变而改变高亮位置
	var index = CurPage-1;
	$('.pagination li:eq(' + index + ')').addClass('active');


}

//页码的切换
function PageConversion() {
	$('.pagination>li').click(function() {
		var index = $(this).index(); //获取当前点击的li元素在全部li元素中的索引
		var OldPage = $('.pagination').find('li[class=active]').index();
		if (index === OldPage)
			return false;
		else {
			$(this).addClass('active').siblings().removeClass('active');

			var CurPage = index + 1;
					
			var SumPage = $('.pagination').children().length;
			CurUserList(CurPage,SumPage);
		}
		return false;
	});
}