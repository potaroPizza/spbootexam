<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

	<!-- http://localhost:9091/exam/bookUpload/bookWrite.do -->

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title>bookWrite.jsp</title>
</head>
<body>
	<h1>책 입력</h1>
	<form method="post" enctype="multipart/form-data" 
		action="<c:url value='/bookUpload/bookWrite.do'/> ">
		책 제목 : <input type="text" name="title"><br>
		가격 : <input type="text" name="price"><br>
		출판사 : <input type="text" name="publisher"><br>
		첨부파일 : <input type="file" id="upfile" 
					name="upfile"/>
            <span>(최대 2M)</span><br><br>
		<input type="submit" value="등록">
		<input type="reset" value="취소">
	</form>
	<br>
	<a href="<c:url value='/book/bookList.do'/> ">책 목록</a>
</body>
</html>