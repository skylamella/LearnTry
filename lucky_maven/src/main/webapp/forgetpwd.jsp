<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/pintuer.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/admin.css">
<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/pintuer.js"></script>
<title>忘记密码</title>
</head>
<body>
<div class="panel admin-panel">
<div class="body-content">
<!-- detail_forgetpass.xhtml -->
	<form action="index.jsp" id="form" class="form-x" method="post">
		<div class="form-group">
        <div class="label">
          <label for="sitename">邮箱：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="receiveEmail" name="email" size="50" placeholder="请输入邮箱" data-validate="required:请输入邮箱,email:请输入标准格式的邮箱" onchange="emailCheck()"/>
        </div>
      </div>
      <div class="form-group" id="sendEmail" style="display:none">
        <div class="label">
          <label for="sitename"></label>
        </div>
        <div class="field">
        	<input type="button" id="sendButton" class="button bg-main icon-check-square-o" value="发送验证码" onclick="sendCheckEmail()">
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">验证码：</label>
        </div>
        <div class="field">
          <input type="text" class="input w50" id="chkCode" name="chkCode" size="50" placeholder="请输入验证码" data-validate="required:请输入验证码,length#==8:验证码为8位" />         
        </div>
      </div>
		<div class="form-group">
        <div class="label">
          <label for="sitename">新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="newpass" name="newpass" size="50" placeholder="请输入新密码" data-validate="required:请输入新密码,length#>=5:新密码不能小于5位" />         
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label for="sitename">确认新密码：</label>
        </div>
        <div class="field">
          <input type="password" class="input w50" id="user_pwd" name="user.user_pwd" size="50" placeholder="请再次输入新密码" data-validate="required:请再次输入新密码,repeat#newpass:两次输入的密码不一致" />          
        </div>
      </div>
      <div class="form-group">
        <div class="label">
          <label></label>
        </div>
        <div class="field">
          <button type="submit" class="button bg-main icon-check-square-o" onclick="return submitCHK()">提交</button>
        </div>
      </div> 
	</form>
	</div>
	<script type="text/javascript">
		var chkCode = null;
		function submitCHK(){
			var code = $('#chkCode').val();
			if(code == chkCode){
				//添加验证码验证成功后处理的业务
				if(!forgetpwdfun()){
					return false;
				}
			}else{
				//验证验证码失败后初始化验证码
				alert("验证码输入错误，请重新输入");
				return false;
			}
		}
		function forgetpwdfun(){
			var url = "<%=request.getContextPath()%>/aj/ajax_forget_pwd.xhtml";
			$.ajax({
				type : "post",
				url : url,
				data : $('#form').serialize(),
				dataType : "json",
				async: false,
				success : function(data) {
					var area = jQuery.parseJSON(data);
					if(area.code == "success"){
						alert("密码修改成功");
						chkCode = null;
						return true;
					}else{
						alert("密码修改失败，请重试");
						return false;
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){
					alert("密码修改失败，请重试");
					return false;
				}
			})
		}
		function emailCheck(){
			var receiveEmail = $('#receiveEmail').val();
		    var url = "<%=request.getContextPath()%>/aj/ajax_email_Check.xhtml";
			$.ajax({
				type : "post",
				url : url,
				data : {'email':receiveEmail},
				dataType : "json",
				success : function(data) {
					var area = jQuery.parseJSON(data);
					if(area.code == "success"){
						$('#sendEmail').css('display','');
					}else{
						$('#sendEmail').css('display','none');
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){
					$('#sendEmail').css('display','none');
				}
			})
		}
		var intDiff = parseInt(90);//倒计时总秒数量
		var lostTime = parseInt(600);//倒计时总秒数量
		function sendCheckEmail(){
			var receiveEmail = $('#receiveEmail').val(); 
			var url = "<%=request.getContextPath()%>/aj/ajax_email_Create.xhtml";
			$('#receiveEmail').attr("readonly","readonly")
			timer(intDiff);
			timer2(lostTime);
			$.ajax({
				type : "post",
				url : url,
				data : {'email':receiveEmail},
				dataType : "json",
				success : function(data) {
					var area = jQuery.parseJSON(data);
					chkCode = area.CheckCode;
				}
			})
		}
		function timer(intDiff){
		    setInterval(function(){
		    var second=0;//时间默认值        
		    if(intDiff > 0){
		        second = Math.floor(intDiff);
		    }
		    $('#sendButton').attr("disabled", true);
		    $('#sendButton').css('color','black');
		    $('#sendButton').val(second+'秒后重新获取');
		    intDiff--;
		    if(second == 0){
		    	$('#sendButton').removeAttr("disabled");
		    	$('#sendButton').css('color','color: #fff');
		    	$('#sendButton').val('请重新获取');
		    	$('#receiveEmail').removeAttr("readonly");
		    }
		    }, 1000);
		    
		}
		function timer2(lostTime){
		    setInterval(function(){
		    var second=0;//时间默认值        
		    if(intDiff > 0){
		        second = Math.floor(intDiff);
		    }
		    intDiff--;
		    if(second == 0){
		    	chkCode = null;
		    }
		    }, 1000);
		    
		}
	</script>
</div>
</body>
</html>