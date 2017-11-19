<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html >
<head>
<meta charset="UTF-8">
<title>小鸡公司抽奖系统</title>

<script src="<%= request.getContextPath() %>/js/index/jrj6out.js"></script>
<script>try{Typekit.load({ async: false });}catch(e){}</script>

<style>
  body {
  position: relative;
  margin: 0;
  overflow: hidden;
}

.intro-container {
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  color: white;
  text-align: center;
  margin: 0 auto;
  right: 0;
  left: 0;
}

h1 {
  font-family: 'brandon-grotesque', sans-serif;
  font-weight: bold;
  margin-top: 0px;
  margin-bottom: 0;
  font-size: 20px;
}
@media screen and (min-width: 860px) {
  h1 {
    font-size: 40px;
    line-height: 52px;
  }
}

.fancy-text {
  font-family: "adobe-garamond-pro",sans-serif;
  font-style: italic;
  letter-spacing: 1px;
  margin-bottom: 17px;
}

.button {
  position: relative;
  cursor: pointer;
  display: inline-block;
  font-family: 'brandon-grotesque', sans-serif;
  text-transform: uppercase;
  min-width: 200px;
  margin-top: 30px;
}
.button:hover .border {
  box-shadow: 0px 0px 10px 0px white;
}
.button:hover .border .left-plane, .button:hover .border .right-plane {
  transform: translateX(0%);
}
.button:hover .text {
  color: #121212;
}
.button .border {
  border: 1px solid white;
  transform: skewX(-20deg);
  height: 32px;
  border-radius: 3px;
  overflow: hidden;
  position: relative;
  transition: .10s ease-out;
}
.button .border .left-plane, .button .border .right-plane {
  position: absolute;
  background: white;
  height: 32px;
  width: 100px;
  transition: .15s ease-out;
}
.button .border .left-plane {
  left: 0;
  transform: translateX(-100%);
}
.button .border .right-plane {
  right: 0;
  transform: translateX(100%);
}
.button .text {
  position: absolute;
  left: 0;
  right: 0;
  top: 50%;
  transform: translateY(-50%);
  transition: .15s ease-out;
}

.x-mark {
  right: 10px;
  top: 10px;
  position: absolute;
  cursor: pointer;
  opacity: 0;
}
.x-mark:hover .right {
  transform: rotate(-45deg) scaleY(1.2);
}
.x-mark:hover .left {
  transform: rotate(45deg) scaleY(1.2);
}
.x-mark .container {
  position: relative;
  width: 20px;
  height: 20px;
}
.x-mark .left, .x-mark .right {
  width: 2px;
  height: 20px;
  background: white;
  position: absolute;
  border-radius: 3px;
  transition: .15s ease-out;
  margin: 0 auto;
  left: 0;
  right: 0;
}
.x-mark .right {
  transform: rotate(-45deg);
}
.x-mark .left {
  transform: rotate(45deg);
}

.sky-container {
  position: absolute;
  color: white;
  text-transform: uppercase;
  margin: 0 auto;
  right: 0;
  left: 0;
  top: 2%;
  text-align: center;
  opacity: 0;
}
@media screen and (min-width: 860px) {
  .sky-container {
    top: 18%;
    right: 12%;
    left: auto;
  }
}
.sky-container__left, .sky-container__right {
  display: inline-block;
  vertical-align: top;
  font-weight: bold;
}
.sky-container__left h2, .sky-container__right h2 {
  font-family: 'brandon-grotesque', sans-serif;
  font-size: 26px;
  line-height: 26px;
  margin: 0;
}
@media screen and (min-width: 860px) {
  .sky-container__left h2, .sky-container__right h2 {
    font-size: 72px;
    line-height: 68px;
  }
}
.sky-container__left {
  margin-right: 5px;
}
.sky-container .thirty-one {
  letter-spacing: 4px;
}

.text-right {
  text-align: right;
}

.text-left {
  text-align: left;
}

.twitter:hover a {
  transform: rotate(-45deg) scale(1.05);
}
.twitter:hover i {
  color: #21c2ff;
}
.twitter a {
  bottom: -40px;
  right: -75px;
  transform: rotate(-45deg);
}
.twitter i {
  bottom: 7px;
  right: 7px;
  color: #00ACED;
}

.social-icon a {
  position: absolute;
  background: white;
  color: white;
  box-shadow: -1px -1px 20px 0px rgba(0, 0, 0, 0.3);
  display: inline-block;
  width: 150px;
  height: 80px;
  transform-origin: 50% 50%;
  transition: .15s ease-out;
}
.social-icon i {
  position: absolute;
  pointer-events: none;
  z-index: 1000;
  transition: .15s ease-out;
}

.youtube:hover a {
  transform: rotate(45deg) scale(1.05);
}
.youtube:hover i {
  color: #ec4c44;
}
.youtube a {
  bottom: -40px;
  left: -75px;
  transform: rotate(45deg);
}
.youtube i {
  bottom: 7px;
  left: 7px;
  color: #E62117;
}

</style>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/input/test.css" type="text/css" />
<script src="<%= request.getContextPath() %>/js/index/prefixfree.min.js"></script>

</head>

<body>
<div class="x-mark">
	<div class="container">
		<div class="left"></div>
		<div class="right"></div>
	</div>
</div>
<div class="intro-container">
	
	<h1>欢迎使用小鸡公司抽奖系统 <br> 小鸡项目组</h1>

	<div class="button shift-camera-button">
		<div class="border">
			<div class="left-plane"></div>
			<div class="right-plane"></div>
		</div>	
		<div class="text">点击进入</div>
	</div>
</div>
<div class="sky-container">
	<div class="text-right sky-container__left">
		<h2 class="portfolio">
			请输入抽奖活动开启密码
		</h2>
	</div>
	<div class="panel"> 
	  <div class="wrap">
		<input type="text" id="openCode" name="openCode" placeholder="请输入抽奖活动开启密码"/>
		<button onclick="submitCHK()">提交</button>
		<script type="text/javascript">
			function submitCHK(){
				var openCode = $('#openCode').val();
				var url = "<%=request.getContextPath()%>/aj/openCode.xhtml";
				$.ajax({
					type : "post",
					url : url,
					data : {'openCode':openCode},
					dataType : "json",
					async: false,
					success : function(data) {
						var area = jQuery.parseJSON(data);
						if(area.code == "success"){
							var nextURL = "<%=request.getContextPath()%>"+area.url;
							alert("开启密码验证成功");
							window.location.replace(nextURL);
						}else{
							alert("开启密码验证失败，请重试");
						}
					},
					error : function(XMLHttpRequest, textStatus, errorThrown){
						alert("开启密码验证失败，请重试");
					}
				})
			}
		</script>
	  </div>
	</div>
</div>
<script src='<%= request.getContextPath() %>/js/jquery.min.js'></script>
<script src='<%= request.getContextPath() %>/js/index/TweenMax.min.js'></script>
<script src='<%= request.getContextPath() %>/js/index/three.min.js'></script>
<script src="<%= request.getContextPath() %>/js/index/index.js"></script>
</body>
</html>