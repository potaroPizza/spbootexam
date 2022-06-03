<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title>bookDetail.jsp</title>
<script type="text/javascript" src="<c:url value='/js/jquery-3.6.0.min.js'/> "></script>
<script type="text/javascript">
	$(function(){
		$('#del').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href 
					= "<c:url value='/book/bookDelete.do?no=${param.no}'/> ";
			} else {
				return;
			}
		});
	});
</script>
</head>
<body>
	<h1>책 상세보기</h1>
	<p>번호 : ${param.no}</p>
	<p>제목 : ${dto.title}</p>
	<p>가격 : ${dto.price}</p>
	<p>출판사 : ${dto.publisher}</p>
	<p>등록일 : ${dto.joindate}</p>
	<br>
	<a href="<c:url value='/book/bookList.do'/> ">목록</a> |
	<a href="bookEdit.do?no=${param.no}">수정</a> |
	<a href="#" id="del">삭제</a>
</body>
</html>