$(function () {
	//carousel
	$('.carousel').carousel()

	//导航栏
	$('#1,#2,#3,#4,#5').hover(function() {
		$(this).children().show();
	},function() {
		$(".submenu").hide();
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
})