//
// $(function() {
// 	$('.carousel').carousel({
// 		interval:2000
// 	});
// })

$(function() {
	//模态框
	$('#loginp').click(function() {
		$('#myModal').modal();
	});

	$('#loginb').click(function() {
		var name = $('#inputName1').val();
		var pwd = $('#inputPassword1').val();
		if (!name || !pwd) {
			alert('用户名或密码不能为空');
		}
		else {
			$.ajax({
				type: 'POST',
				url: '/login',
				data: {
					id: name,
					password: pwd
				},
				success: function(data) {
					if(data.code == "0") {
						$('#myModal').hide();
						$('#loginp').empty().html(name);
						location.reload();
					} else {
						alert('error:' + data.responseText);
					}
				},
				error: function(data) {
					alert('error:' + data.responseText);
				}
			});
		}
		return false;
	});

	$('#registerb').click(function() {
		var id = $('#inputID').val();
		var name = $('#inputName2').val();
		var pwd = $('#inputPassword2').val();
		if (!name || !pwd) {
			alert('用户名或密码不能为空');
		}
		else {
			$.ajax({
				type: 'POST',
				url: '/register',
				data: {
					id: id,
					name: name,
					password: pwd
				},
				success: function(data) {
					if(data.code == "1") {
						$('#myModal').hide();
						alert("注册成功！");
						location.reload();
					} else {
						alert("用户名已存在！");
					}
				},
				error: function(data) {
					alert('error:' + data.responseText);
				}
			});
		}
	});

	$('#logout').click(function() {
		var id = $('#loginp').text().toString();
		if(id === 'null')
			return false;
		else {
			userLogout(id);
			logout();
			alert('用户注销成功！');
			location.reload();
		}
		return false;
	});
});
function logout() {
	$.ajax({
		type:'POST',
		url:'/logout',
	});
}
function userLogout(id) {
	$.ajax({
		type:'POST',
		url:'/userLogout',
		data:{
			id:id
		}
	});
}
