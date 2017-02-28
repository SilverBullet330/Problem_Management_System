$(function() {

	$('a[data-id=AL1]').parent().addClass('active');
	$('a[data-id=AL2]').parent().addClass('active');
	$('a[data-id=AL3]').parent().addClass('active');
	$('a[data-id=\\*]').parent().addClass('active');

	var $ENG = $('#ul2>li>a[data-id^=ENG]');//选择开头为ENG的专业
	var $NAS = $('#ul2>li>a[data-id^=NAS]');//选择开头为NAS的专业
	var $LAW = $('#ul2>li>a[data-id^=LAW]');//选择开头为LAW的专业
	var $LIT = $('#ul2>li>a[data-id^=LIT]');//选择开头为LIT的专业
	var $ENGCS_ = $('#ul3>li>a[data-id^=ENGCS_]');//选择开头为ENGCS_的课程
	var $ENGEST = $('#ul3>li>a[data-id^=ENGEST]');//选择开头为ENGEST的课程
	var $NASMAM = $('#ul3>li>a[data-id^=NASMAM]');//选择开头为NASMAM的课程
	var $LAWLAW = $('#ul3>li>a[data-id^=LAWLAW]');//选择开头为LAWLAW的课程
	var $LITENG = $('#ul3>li>a[data-id^=LITENG]');//选择开头为LITENG的课程

	$('#ul1>li').click(function() {
		$(this).siblings('li').removeClass('active');
		$(this).addClass('active');

		$('#ul2>li').removeClass('active');
		$('#ul3>li').removeClass('active');

		var cla = $(this).children().data('id');
		var typ = $('#ul4').find('li[class=active]').children().data('id');

		if (cla==='ENG') {
			$('a[data-id=AL2]').parent().addClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			$('a[data-id=AL4]').parent().addClass('active');
			$ENG.show();
			$NAS.hide();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.show();
			$ENGEST.show();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.hide();			
		} 
		else if(cla==='NAS') {
			$('a[data-id=AL2]').parent().addClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			$('a[data-id=AL4]').parent().addClass('active');
			$ENG.hide();
			$NAS.show();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.show();
			$LAWLAW.hide();
			$LITENG.hide();			
		}
		else if(cla==='LAW') {
			$('a[data-id=AL2]').parent().addClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			$('a[data-id=AL4]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.show();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.show();
			$LITENG.hide();
		}
		else if(cla==='LIT') {
			$('a[data-id=AL2]').parent().addClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			$('a[data-id=AL4]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.hide();
			$LIT.show();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.show();
		}
		else {
			$('a[data-id=AL2]').parent().addClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			$('a[data-id=AL4]').parent().addClass('active');
			$ENG.show();
			$NAS.show();
			$LAW.show();
			$LIT.show();
			$ENGCS_.show();
			$ENGEST.show();			
			$NASMAM.show();
			$LAWLAW.show();
			$LITENG.show();
		}
		cla=cla+'AL2AL******'

		ajax(cla,typ);
		
		return false;
	}); 	

	$('#ul2>li').click(function() {
		$(this).siblings('li').removeClass('active');
		$(this).addClass('active');

		//$('a[data-id=AL1]').parent().removeClass('active');
			

		var cla = $(this).children().data('id');
		var typ = $('#ul4').find('li[class=active]').children().data('id');
		var active = $('#ul1').find('li[class=active]').children().data('id');

		if (cla==='ENGCS_') {
			$('#ul1>li').removeClass('active');					
			$('a[data-id=ENG]').parent().addClass('active');
			$ENG.show();
			$NAS.hide();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.show();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.hide();
		} 
		else if(cla==='ENGEST') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=ENG]').parent().addClass('active');
			$ENG.show();
			$NAS.hide();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.show();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.hide();			
		}
		else if(cla==='NASMAM') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=NAS]').parent().addClass('active');
			$ENG.hide();
			$NAS.show();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.show();
			$LAWLAW.hide();
			$LITENG.hide();
		}
		else if(cla==='LAWLAW') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=LAW]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.show();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.show();
			$LITENG.hide();
		}
		else if(cla==='LITENG') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=LIT]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.hide();
			$LIT.show();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.show();
		}
		else if(cla === 'AL2'){
			$('#ul3>li').removeClass('active');
			$('a[data-id=AL3]').parent().addClass('active');
			//获取ul1中属性为active的li标签，若为ALL2，则不变，若为其他，则下一步处理
			if (active === 'ENG') {
				$ENG.show();
				$NAS.hide();
				$LAW.hide();
				$LIT.hide();
				$ENGCS_.show();
				$ENGEST.show();			
				$NASMAM.hide();
				$LAWLAW.hide();
				$LITENG.hide();
				cla=active+cla;
			}
			else if (active === 'NAS') {
				$ENG.hide();
				$NAS.show();
				$LAW.hide();
				$LIT.hide();
				$ENGCS_.hide();
				$ENGEST.hide();			
				$NASMAM.show();
				$LAWLAW.hide();
				$LITENG.hide();
				cla=active+cla;
			}
			else if (active === 'LAW') {
				$ENG.hide();
				$NAS.hide();
				$LAW.show();
				$LIT.hide();
				$ENGCS_.hide();
				$ENGEST.hide();			
				$NASMAM.hide();
				$LAWLAW.show();
				$LITENG.hide();
				cla=active+cla;
			}
			else if (active === 'LIT') {
				$ENG.hide();
				$NAS.hide();
				$LAW.hide();
				$LIT.show();
				$ENGCS_.hide();
				$ENGEST.hide();			
				$NASMAM.hide();
				$LAWLAW.hide();
				$LITENG.show();
				cla=active+cla;
			}	
			else {
				$('a[data-id=AL1]').parent().addClass('active');
				cla=active+cla;
			}			
		}
		cla=cla+'AL******'

		ajax(cla,typ);

		return false;
	});

	$('#ul3>li').click(function() {
		$(this).siblings('li').removeClass('active');
		$(this).addClass('active');

		var cla = $(this).children().data('id');
		var typ = $('#ul4').find('li[class=active]').children().data('id');

		cla_ = cla.substr(0,6)

		if (cla_==='ENGCS_') {
			$('#ul1>li').removeClass('active');					
			$('a[data-id=ENG]').parent().addClass('active');
			$('#ul2>li').removeClass('active');	
			$('a[data-id=ENGCS_]').parent().addClass('active');
			$ENG.show();
			$NAS.hide();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.show();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.hide();
		} 
		else if(cla_==='ENGEST') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=ENG]').parent().addClass('active');
			$('#ul2>li').removeClass('active');
			$('a[data-id=ENGEST]').parent().addClass('active');
			$ENG.show();
			$NAS.hide();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.show();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.hide();			
		}
		else if(cla_==='NASMAM') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=NAS]').parent().addClass('active');
			$('#ul2>li').removeClass('active');
			$('a[data-id=NASMAM]').parent().addClass('active');
			$ENG.hide();
			$NAS.show();
			$LAW.hide();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.show();
			$LAWLAW.hide();
			$LITENG.hide();
		}
		else if(cla_==='LAWLAW') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=LAW]').parent().addClass('active');
			$('#ul2>li').removeClass('active');
			$('a[data-id=LAWLAW]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.show();
			$LIT.hide();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.show();
			$LITENG.hide();
		}
		else if(cla_==='LITENG') {
			$('#ul1>li').removeClass('active');
			$('a[data-id=LIT]').parent().addClass('active');
			$('#ul2>li').removeClass('active');
			$('a[data-id=LITENG]').parent().addClass('active');
			$ENG.hide();
			$NAS.hide();
			$LAW.hide();
			$LIT.show();
			$ENGCS_.hide();
			$ENGEST.hide();			
			$NASMAM.hide();
			$LAWLAW.hide();
			$LITENG.show();
		}

		ajax(cla,typ);

		return false;
	});	

	$('#ul4>li').click(function() {
		$(this).addClass('active').siblings().removeClass('active');

		var cla = $('#ul3').find('li[class=active]').children().data('id');
		var typ = $(this).children().data('id');

		ajax(cla,typ);

		return false;
	});

	//底部页码
	$('.pagination>li').click(function() {

		var index = $(this).index(); //获取当前点击的li元素在全部li元素中的索引
		var oldpage = $('.pagination').find('li[class=active]').index();
		if (index === oldpage)
			return false;
		else {
			$(this).addClass('active').siblings().removeClass('active');
		   
			var curpage = index + 1;
			var cla = $('#ul3').find('li[class=active]').children().data('id');
			var typ = $('#ul4').find('li[class=active]').children().data('id');
			var sumpage = $('.pagination').children().length;
			page(cla,typ,curpage,sumpage);		
		}
		return false;
	});

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

function ajax(cla, typ) {
	if (cla === 'AL3') {
		var s1 = $('#ul1').find('li[class=active]').children().data('id');
		var s2 = $('#ul2').find('li[class=active]').children().data('id');
		cla = s1 + s2 + 'AL******';
	}

	$.ajax({
		type: 'POST',
		url: '/problem/get',
		data: {
			list: cla,
			type: typ,
			page: '-1/-1'
		},
		success: function(res) {
			var code = res.code.replace(/[^0-9]+/g,'');
			var problemAmount = code[0];
			var curpage = code[1];
			var sumpage = code[2];

			if (problemAmount === 0) {
				$('.problem').empty().html('<p>未找到题目！</p>');
				$('.pagination').empty();
			}
			else {
				$('.problem').empty();
				var pid;
				var dif;
				var content = '';
				var pagination = '';

				for (var i = 0; i < problemAmount; i++) {
					pid = res.data[i].pid;
					dif = res.data[i].difficulty;
					content += '<div class="row">' +
									'<div class="col-sm-12 col-md-12">' +
										'<div class="thumbnail">' +
											'<img src="/ProblemBank/Problem/' + pid + '.png" alt="...">' +
											'<div class="caption">' +
												'<p>这是第' + (i+1) + '道题</p>' +
												'<p>这道题的难度为' + dif + '</p>' +
												'<p>' +
													'<a href="#" id="' + pid + '" class="addToTrolley btn btn-primary" role="button">放入我的Trolley</a>' +
												'</p>' +
											'</div>' +
										'</div>' +
									'</div>' +
								'</div>';
				}

				$('.problem').html(content);
				$(".addToTrolley").click(function () {
					var currentpid = $(this).attr("id");
					var AdminName = $('#loginp').text().toString();
					$.ajax({
						type: 'POST',
						url: '/trolley/addProblem',
						data: {
							pid:currentpid,
							id:AdminName
						},
						success: function(res) {
							if (res.code === '1')
								alert("添加成功！");
							else
								alert("该题目已被添加或题目不存在！");
						},
						error: function(res) {
							alert('error:' + res.responseText);
						}
					});
					return false
				});

				pagination = '<li class="active"><a href="">1</a></li>';
				for (var i = 0; i < sumpage-1; i++)
					 pagination += '<li><a href="">' + (i+2) + '</a></li>';

				$('.pagination').empty().html(pagination);
				$('.pagination>li').click(function() {
					var index = $(this).index(); //获取当前点击的li元素在全部li元素中的索引
					var oldpage = $('.pagination').find('li[class=active]').index();
					if (index === oldpage)
						return false;
					else {
						$(this).addClass('active').siblings().removeClass('active');

						var curpage = index + 1;
						var cla = $('#ul3').find('li[class=active]').children().data('id');
						var typ = $('#ul4').find('li[class=active]').children().data('id');
						var sumpage = $('.pagination').children().length;
						page(cla,typ,curpage,sumpage);
					}
					return false;
				});
			}					
		},
		error: function(res) {
			alert('error:' + res.responseText);
		}
	});
}

function page(cla, typ, curpage, sumpage) {
	if (cla === 'AL3') {
		var s1 = $('#ul1').find('li[class=active]').children().data('id');
		var s2 = $('#ul2').find('li[class=active]').children().data('id');
		cla = s1 + s2 + 'AL******';
	}
	$.ajax({
		type: 'POST',
		url: '/problem/get',
		data: {
			list: cla,
			type: typ,
			page: curpage + '/' + sumpage
		},
		success: function(res) {
			var code = res.code.replace(/[^0-9]+/g,'');
			var problemAmount = code[0];
			var curpage = code[1];
			var sumpage = code[2];
			
			var pid;
			var dif;
			var content = '';
			var pagination = '';

			for (var i = 0; i < problemAmount; i++) {
				pid = res.data[i].pid;
				dif = res.data[i].difficulty;
				content += '<div class="row">' +
								'<div class="col-sm-12 col-md-12">' +
									'<div class="thumbnail">' +
										'<img src="/ProblemBank/Problem/' + pid + '.png" alt="...">' +
										'<div class="caption">' +
											'<p>这是第' + (i+1) + '道题</p>' +
											'<p>这道题的难度为' + dif + '</p>' +												'<p>' +
												'<a href="#" id="' + pid + '" class="addToTrolley btn btn-primary" role="button">放入我的Trolley</a>' +
												'<a href="#" class="btn btn-default" role="button">Button</a>' +
											'</p>' +
										'</div>' +
									'</div>' +
								'</div>' +
							'</div>';
			}

			$('.problem').empty().html(content);
			$(".addToTrolley").click(function () {
				var currentpid = $(this).attr("id");
				var id = $('#loginp').text().toString();
				$.ajax({
					type: 'POST',
					url: '/trolley/addProblem',
					data: {
						pid:currentpid,
						id:id
					},
					success: function(res) {
						if (res.code === '1')
							alert("添加成功！");
						else
							alert("该题目已被添加或题目不存在！");
					},
					error: function(res) {
						alert('error:' + res.responseText);
					}
				});
				return false
			});
		},
		error: function(res) {
			alert('error:' + res.responseText);
		}
	});
}