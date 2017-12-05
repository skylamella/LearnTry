<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/pure/pure-min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/pure/forms-min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/pure/buttons-min.css">
<script
	src="<%=request.getContextPath()%>/js/common/jquery-1.7.2.min.js"></script>
<title>忘记密码</title>
</head>
<body>
	<form class="pure-form pure-form-stacked">
		<fieldset>
			<div class="pure-g">
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="email">邮箱：</label> 
					<input type="email" id="email" class="pure-u-23-24" required/>
				</div>
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="sendEmail"></label> 
					<input type="button" id="sendEmail" class="pure-button pure-button-primary" value="发送验证码">
				</div>
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="emailCheckCode">邮箱验证码：</label> 
					<input type="text" id="emailCheckCode" class="pure-u-23-24" required/>
				</div>
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="password">新密码：</label> 
					<input type="password" id="password" class="pure-u-23-24" required/>
				</div>
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="repassword">确认新密码：</label> 
					<input type="password" id="repassword" class="pure-u-23-24" required/>
				</div>
				<div class="pure-u-1 pure-u-md-1-3">
					<label for="passCode">验证码：</label> 
					<input type="text" id="passCode" class="pure-u-23-24" />
				</div>
				<button type="submit" class="pure-button pure-button-primary">提交</button>
			</div>
		</fieldset>
	</form>
</body>
</html>