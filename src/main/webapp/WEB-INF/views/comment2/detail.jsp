<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title></title>
<script type="text/javascript" src="<c:url value='/js/jquery-3.6.0.min.js'/> "></script>
<script type="text/javascript">
	$(function(){
		$('#del').click(function(){
			if(confirm("삭제하시겠습니까?")){
				location.href 
					= "<c:url value='/comment2/delete.do?commentNo=${param.commentNo}'/> ";
			} else {
				return;
			}
		});
	});
</script>
</head>
<body>
	<h1>책 상세보기</h1>
	<p>번호 : ${param.commentNo}</p>
	<p>아이디 : ${vo.userId}</p>
	<p>코멘트 : ${vo.commentContent}</p>
	<p>등록일 : ${vo.regDate}</p>
	<br>
	<a href="<c:url value='/comment2/list.do'/> ">목록</a> |
	<a href="<c:url value='/edit.do?commentNo=${param.commentNo}'/> ">수정</a> |
	<a href="#" id="del">삭제</a>
</body>
</html>