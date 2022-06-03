<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- http://localhost:9091/exam/comment2/write.do -->

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title>write.jsp</title>
</head>
<body>
	<h1>코멘트 입력</h1>
	<form method="post"
		action="<c:url value='/comment2/write.do'/> ">
		아이디 : <input type="text" name="userId"><br>
		내용 : <input type="text" name="commentContent"><br><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	<br>
	<a href="<c:url value='/comment2/list.do'/> ">코멘트 목록</a>
</body>
</html>