<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>小鸡公司抽奖系统</title>
<head>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery.js"></script>
<script type="text/javascript">
	$(function(){
		var alldata = new Array(
				<s:iterator value="#session.userList" status="st">
					"<%=request.getContextPath()%>/images/icon/<s:property value="user_icon"/>"<s:if test="!#st.last">,</s:if>
				</s:iterator>
		);
		var imageName = new Array("#img1","#img2","#img3","#img4","#img5","#img6");
		var nameNum = imageName.length - 1;
		var num = alldata.length - 1;
		var show = $("#image");
		var btn = $("#btn");
		var open = false;
			
		function change(){
			var randomVal = Math.round(Math.random() * num);
			var prizeName = alldata[randomVal];
			show.attr("src",prizeName);
		}
		
		Array.prototype.indexOf = function(val) {
			for (var i = 0; i < this.length; i++) {
				if (this[i] == val) return i;
				}
					return -1;
			};

		Array.prototype.remove = function(val) {
			var index = this.indexOf(val);
				if (index > -1) {
					this.splice(index, 1);
				}
			};
		var times = 0;
		function run(){
			if(!open){
				timer=setInterval(change,20);
				open = true;
			}else{
				var height = $(imageName[nameNum]).css("height");
				var width = $(imageName[nameNum]).css("width");
				
				var name = $("#image").attr("src");
				times++;
				ajaxresult(name)
				var imgClone = $("#image").clone(true).css("opacity",'0.7');
				alldata.remove(name);
				imgClone.css({ "position": "absolute", "top": "50px", "left": "50px"});
				$("#imgDiv").parent().append(imgClone);
				imgClone.animate({height:"150px",width:"150px"},400);
				imgClone.animate({left:$(imageName[nameNum]).offset().left,top:$(imageName[nameNum]).offset().top},600);
				imgClone.animate({height:height,width:width},350,function(){
						$(imageName[nameNum]).attr("src",name);
						nameNum = nameNum - 1;
					});
				clearInterval(timer);
				open = false;
			}
		}
		function ajaxresult(name){
			var arr = name.split('/');
			var url = "<%=request.getContextPath()%>/aj/luckyResult.xhtml";
			$.ajax({
				type : "post",
				url : url,
				data : {
					'icon':arr[3],
					'times':times
					},
				dataType : "json",
				async: false,
				success : function(data) {
					var area = jQuery.parseJSON(data);
					if(area.code == "success"){
						if(times <= 3){
							//三等奖
							alert("恭喜"+area.user_name+"获得三等奖");
						}else if(times <= 5){
							//二等奖
							alert("恭喜"+area.user_name+"获得二等奖");
						}else{
							//一等奖
							alert("恭喜"+area.user_name+"获得一等奖");
						}
					}else{
						alert("抽奖失败，请重试");
						location.reload();
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown){
					alert("抽奖失败，请重试");
					location.reload();
				}
			})
		}
		$(document).keydown(function(e){
			if(!e) var e = window.event; 
			if(e.keyCode==32){
					run();
				}
			});
	})
	</script>
<style>
body {
	background-image: url(<%=request.getContextPath()%>/images/background/bg1.jpg)
}

.wrap {
	width: 600px;
	margin: 100px auto;
	font-family: "微软雅黑";
}

.show {
	width: 650px;
	height: 650px;
	background-color: #ff3300;
	line-height: 100px;
	text-align: center;
	color: #fff;
	font-size: 28px;
	-moz-border-radius: 100px;
	-webkit-border-radius: 100px;
	border-radius: 100px;
	background-image: -webkit-gradient(linear, 0% 0%, 0% 100%, from(#FF9600), to(#F84000), color-stop(0.5, #fb6c00));
	-moz-box-shadow: 2px 2px 10px #BBBBBB;
	-webkit-box-shadow: 2px 2px 10px #BBBBBB;
	box-shadow: 2px 2px 10px #BBBBBB;
}

.btn a {
	display: block;
	width: 120px;
	height: 50px;
	margin: 30px auto;
	text-align: center;
	line-height: 50px;
	text-decoration: none;
	color: #fff;
	-moz-border-radius: 25px;
	-webkit-border-radius: 25px;
	border-radius: 25px;
}

.btn a.start {
	background: #80b600;
}

.btn a.start:hover {
	background: #75a700;
}

.btn a.stop {
	background: #00a2ff;
}

.btn a.stop:hover {
	background: #008bdb;
}

img {
	border: 0
}
</style>
</head>
<body>
	<div class="wrap">
		<div class="show" id="show">
			<s:property value="#session.lucky.lucky_title" />
			<div id="imgDiv">
				<img src="<%=request.getContextPath()%>/images/icon/<s:property value="#session.firstuser.user_icon"/>" id="image" height="450px" width="400px" />
			</div>
			点击空格键开始抽奖
		</div>
		<ul style="position: absolute; top: 100px; right: 180px; list-style-type: none">
			<h4 style="color: #06C">一等奖：<s:property value="#session.firstprize.prize_name" /></h4>
			<li><img src="" id="img1" height="100px" width="100px" /></li>
			<h4 style="color: #06C">二等奖：<s:property value="#session.secontprize.prize_name" /></h4>
			<li><img src="" id="img2" height="100px" width="100px" /></li>
			<li><img src="" id="img3" height="100px" width="100px" /></li>
		</ul>
		<ul style="position: absolute; top: 100px; right: 350px; list-style-type: none">
			<h4 style="color: #06C">三等奖：<s:property value="#session.thirdprize.prize_name" /></h4>
			<li><img src="" id="img4" height="100px" width="100px" /></li>
			<li><img src="" id="img5" height="100px" width="100px" /></li>
			<li><img src="" id="img6" height="100px" width="100px" /></li>
		</ul>
	</div>
</body>
</html>