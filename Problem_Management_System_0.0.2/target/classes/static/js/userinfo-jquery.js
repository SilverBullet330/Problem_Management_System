$(function(){
	ajax_init();
	ChangeInfo()

	//申请修改信息button
	ConfirmInfo()
	//确认修改信息button
	sure_change_info();

});
function ajax(){
	var id = $('#loginp').text().toString();
	var name=$('#NameChange').val();
	var password=$('#PwdChange_').val();
	var info='';
	$.ajax({
		type:"POST",
		url:"/userInfoUpdate",
		data:{
			id:id,
			name:name,
			password:password
		},
		success:function(){
			$('.change_info_success').show();//显示'成功'
			ajax_init();//刷新页面
			$('.change_info_data').hide();//保证没有输入框
		}
	});
}
//用来初始化页面
function ajax_init(){
	var id = $('#loginp').text().toString();
	var name = '';
	var password = '';
	var joinTime = '';
	var authority = '';
	$.ajax({
		type:"POST",
		url:"/user",
		data:{
			id:id
		},
		success:function(res){
			if (res.code === '1') {
				name = res.data.name;
				password = res.data.password;
				joinTime = res.data.joinTime;
				authority = res.data.authority;
				var info='';
				info = '<tr align="center">'+
					'<div class="page-header">'+
					'<h1>个人信息 &nbsp<small>你是谁 谁是你</small></h1>'+
					'</div>'+
					'</tr>'+
					'<tr align="center">'+
					'<img src="/img/4.png" alt="用户头像" class="img-circle" height="250"/>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<h2><small>ID：' + id + '</small></h2>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<h2><small>用户名：' + name+ '</small></h2>'+
					'<input id="NameChange" class="form-control change_info_data" type="text" placeholder="用户名"/>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<tr>'+
					'<td>'+
					'<h2><small>密码：' + password + '</small></h2>'+
					'<input id="PwdChange" type="password" class="form-control change_info_data" placeholder="输入新密码"/><br class="sure_change_info">'+
					'<input id="PwdChange_" type="password" class="form-control change_info_data" placeholder="第二次输入新密码"/>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<h2><small>用户等级：' + authority + '</small></h2>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<h2><small>注册时间：' + joinTime + '</small></h2>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<hr>'+
					'</td>'+
					'</tr>'+
					'<tr>'+
					'<td>'+
					'<button id="InfoChange" type="button" class="btn btn-info btn-lg btn-block change_info">&nbsp修&nbsp改&nbsp信&nbsp息&nbsp</button>'+
					'</td>'+
					'</tr>'+
					'<tr class="sure_change_info">'+
					'<td>'+
					'<button id="ConInfoChange" type="button" class="btn btn-primary btn-lg btn-block">&nbsp确&nbsp认&nbsp修&nbsp改&nbsp信&nbsp息&nbsp</button>'+
					'</td>'+
					'</tr>'+
					'<tr><td><div><br></div></td>'+
					'</tr>'+
					'<tr class="change_info_warning">'+
					'<td>'+
					'<div class="alert alert-warning alert-dismissible change_info_warning_message" role="alert">'+
					'<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+
					'<strong>Wrong:</strong>'+
				'</div>'+
				'</td>'+
				'</tr>'+
				'<tr class="change_info_success">'+
					'<td>'+
					'<div class="alert alert-success alert-dismissible" role="alert">'+
					'<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+
					'<strong>Success</strong> 信息修改成功'+
					'</div>'+
					'</td>'+
					'</tr>'+
					'<tr class="change_info_error">'+
					'<td>'+
					'<div class="alert alert-danger alert-dismissible" role="alert">'+
					'<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+
					'<strong>ERROR！</strong> 信息修改失败！请联系管理员'+
				'</div>'+
				'</td>'+
				'</tr>'+
				'</table>';
				$('.userinfo').empty().html(info);
				ChangeInfo();
				ConfirmInfo();
				sure_change_info();
			}

		}
	});


 }
 function ChangeInfo() {
	$('.sure_change_info').hide();
	$('.change_info_data').hide();
	$('.change_info_success').hide();
	$('.change_info_error').hide();
	$('.change_info_warning').hide();
}
function ConfirmInfo() {
	$('.change_info').click(function(){
		$(this).hide();
		$('.change_info_success').hide();
		$('.change_info_error').hide();
		$('.change_info_warning').hide();
		$('.change_info_data').val("");
		$('.change_info_data').show();
		$('.sure_change_info').show();
	});
}
function sure_change_info() {
	$('.sure_change_info').click(function(){
		var message='';
		if($('#NameChange').val()===''){//如果用户名为空
			message+='<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>'+'<strong>Wrong:用户名不能为空</strong>'
			$('.change_info_warning_message').html(message);
			$('.change_info_warning').show();

		}
		else {
			if ($('#PwdChange').val() === '') {//如果密码为空
				message += '<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' + '<strong>Wrong:密码不能为空</strong>'
				$('.change_info_warning_message').html(message);
				$('.change_info_warning').show();
			}
			else {
				if ($('#PwdChange').val() !== $('#PwdChange_').val()) {//如果两次输入的密码不相等
					message += '<button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' + '<strong>Wrong:两次输入的密码不相同</strong>'
					$('.change_info_warning_message').html(message);
					$('.change_info_warning').show();
				}
				else{
					ajax();
				}

			}
		}
		$('.sure_change_info').hide();
		$('.change_info_data').hide();
		$('.change_info').show();
	});
}