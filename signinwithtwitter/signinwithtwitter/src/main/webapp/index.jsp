<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ request.getContextPath();
%>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link href="<%=basePath%>/assets/css/bootstrap.min.css" rel="stylesheet">
		<link href="<%=basePath%>/assets/css/bootstrap-responsive.min.css" rel="stylesheet">
		<link href="<%=basePath%>/assets/css/docs.css" rel="stylesheet">
		<script type="text/javascript" src="<%=basePath%>/assets/js/jquery-1.9.1.min.js"></script>
		<script type="text/javascript" src="<%=basePath%>/assets/js/bootstrap.min.js"></script>
	</head>
	
	<body>
		<jsp:include page="header.jsp"></jsp:include>
	 	<br> <br> 
	 	<center><h3> <a href="<%=basePath%>/member/loginWithTwitter.do">TwitterLogin</a> </h3></center>
	    
	    <hr>
	  
	</body>
</html>