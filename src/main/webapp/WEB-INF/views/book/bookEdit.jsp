<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title>bookEdit.jsp</title>
</head>
<body>
	<h1>책 수정</h1>
	<form method="post" 
		action="<c:url value='/book/bookEdit.do'/> ">
		<input type="hidden" name="no" value="${param.no}">
		책 제목 : <input type="text" name="title" value="${dto.title}"><br>
		가격 : <input type="text" name="price" value="${dto.price}"><br>
		출판사 : <input type="text" name="publisher" value="${dto.publisher}"><br><br>
		<input type="submit" value="수정">
		<input type="reset" value="취소">
	</form>
	<br>
	<a href="<c:url value='/book/bookDetail.do?no=${param.no}'/> ">책 상세보기로 돌아가기</a>
</body>
</html>