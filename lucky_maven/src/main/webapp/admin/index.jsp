<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" class="no-js">
<head>
<script type="text/javascript">
    window.onload=function(){
		if(window.parent != window){
			window.parent.location.href = "<%= request.getContextPath() %>/admin/login.xhtml";
		}
	};
</script>
<meta charset="utf-8">
<title>用户登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<!-- CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/reset.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/supersized.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/assets/css/style.css">
</head>
<body>
	<div class="page-container">
		<h1>员工登录</h1>
		<form id="form" action="<%=request.getContextPath()%>/frame/index.xhtml" method="post">
			<input type="text" name="user.user_email" class="username" placeholder="请输入邮箱"> 
			<input type="password" name="user.user_pwd" class="password" placeholder="请输入密码">
			<button type="submit" onclick="return submitCHK()">登录</button>
			<span id="errorCode" style="color:red"></span>
		</form>
		<div class="connect">
			<a href="forgetpwd.xhtml">忘记密码？</a>
		</div>
	</div>
	<script type="text/javascript">
		var chk = 0;
		function submitCHK(){
			loginAjax();
			if(chk == 1){
				return true;
			}else{
				return false;
			}
		}
		function loginAjax(){
			var url = "<%=request.getContextPath()%>/aj/uselogin.xhtml";
			$.ajax({
				type : "post",
				url : url,
				data : $('#form').serialize(),
				dataType : "json",
				async: false,
				success : function(data) {
					var area = jQuery.parseJSON(data);
					if(area.code == "success"){
						$("#errorCode").html("");
						chk = 1;
					}else{
						$("#errorCode").html(area.text);
						chk = 0;
					}
				}
			})
		}
	</script>
	<!-- Javascript -->
	<script src="<%=request.getContextPath()%>/assets/js/jquery-1.8.2.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/supersized.3.2.7.min.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/supersized-init.js"></script>
	<script src="<%=request.getContextPath()%>/assets/js/scripts.js"></script>
</body>
</html>