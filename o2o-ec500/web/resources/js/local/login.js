$(function() {
	var loginUrl = '/o2o_war_exploded/local/logincheck';
	// usertype=1 customer, 2 = shop owner
	var usertype = getQueryString('usertype');
	var loginCount = 0;

	$('#submit').click(function() {
		var userName = $('#username').val();
		var password = $('#psw').val();
	
		$.ajax({
			url : loginUrl,
			async : false,
			cache : false,
			type : "post",
			dataType : 'json',
			data : {
				userName : userName,
				password : password,
				
			},
			success : function(data) {
				if (data.success) {
					$.toast('Login Success！');
					if (usertype == 1) {
						window.location.href = '/o2o_war_exploded/frontend/index';
					} else {
						window.location.href = '/o2o_war_exploded/shopadmin/shoplist';
					}
				} else {
					$.toast('Login Fail！' + data.errMsg);
					loginCount++;
					if (loginCount >= 3) {
						$('#verifyPart').show();
					}
				}
			}
		});
	});
});