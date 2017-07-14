<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
</head>
<link rel="stylesheet" type="text/css" href="css/index.css" />
<body>
	<form action="send.do" method="post">
		<div id="box">
			<ul>
				<li class="center">SpringMVC4.0 + MyBatis3.2 + 验证码  + 邮箱   + Log4j</li>
			</ul>
			<ul>
				<li class="left">输入您的邮箱：<input type="text" name="sendto" value="${sendto}"/></li>
			</ul>
			<ul>
				<li class="left">输入消息内容：<input type="text" name="content" value="${content}"/></li>
			</ul>
			<ul>
				<li class="left">输入验证码吧：<input type="text" name="code" /><img id="imgObj" onclick="javascript:changeImg()" src="code.html" /></li>
			</ul>
			<ul>
				<li class="left">后台返回数据：<input type="text" value="${info}" readonly="readonly"/></li>
			</ul>
			<input type="submit" id="send" value="发送邮件" />
		</div>
	</form>
    
    <script type="text/javascript"> 
	    function changeImg() { 
	        var imgSrc = $("#imgObj");
	        imgSrc.attr("src", chgUrl("code.html")); 
	    } 
	    function chgUrl(url) { 
	        var timestamp = (new Date()).valueOf(); 
	        if ((url.indexOf("&") >= 0)) { 
	            url = url + "×tamp=" + timestamp; 
	        } else { 
	            url = url + "?timestamp=" + timestamp; 
	        } 
	        return url; 
	    } 
	</script>
</body>
</html>