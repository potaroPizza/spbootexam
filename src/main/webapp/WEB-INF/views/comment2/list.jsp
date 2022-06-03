<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<!-- http://localhost:9091/exam/comment2/list.do -->

<!DOCTYPE html>
<html>
<head>
<meta charset="">
<title></title>
<script type="text/javascript" src="<c:url value='/js/jquery-3.6.0.min.js'/>"></script>
<script type="text/javascript">	
	//페에지 번호 클릭시 실행할 함수
	function pageProc(curPage){
		$('input[name=currentPage]').val(curPage);
		$('form[name=frmPage]').submit();
	}
</script>
</head>
<body>
	<h1>코멘트 목록</h1>
	
	<!-- 페이징 처리를 위한 form -->
	<form action="<c:url value='/comment2/list.do'/>"
		method="post" name="frmPage">
		<input type="test" name="searchKeyword" value="${param.searchKeyword }">
		<input type="text" name="searchCondition" value="${param.searchCondition }">
		<input type="text" name="currentPage">	
	</form>
	
	<table border="1" style="width:500px; border-collapse:collapse;">
		<tr>
			<th>번호</th>
			<th>아이디</th>
			<th>등록일</th>
		</tr>
		<c:if test="${empty list}">
		  	<tr>
		  		<td colspan="3" class="align_center">해당 코멘트가 존재하지 않습니다.</td>
		  	</tr>
		</c:if>
		<!-- 반복구간 시작 -->
		<c:if test="${!empty list}">
			
			<c:forEach var="vo" items="${list}">
		  
					<tr>
						<td><a href="<c:url value='/comment2/detail.do?commentNo=${vo.commentNo}'/> ">
							${vo.commentNo}</a></td>
						<td>${vo.userId}</td>
						<td>
							<fmt:formatDate value="${vo.regDate}" pattern="yyyy-MM-dd"/>
						</td>
					</tr>

			</c:forEach>
		<!-- 반복구간 끝 -->
		</c:if>
	</table>
	<br>
	
    <div>
    	<!-- 페이지 -->
    	<c:if test="${pagingInfo.firstPage > 1}">
		<a href="<c:url value='/comment2/list.do?currentPage=${pagingInfo.firstPage-1}&searchCondition=${param.searchCondition}&searchKeyword=${param.searchKeyword}' />">
			<img src="<c:url value='/images/first.JPG'/> ">
		</a>				
		</c:if>
		<!-- [1][2][3][4][5][6][7][8][9][10] -->
		<c:forEach var="i" begin="${pagingInfo.firstPage}" end="${pagingInfo.lastPage}">
			<c:if test="${i<pagingInfo.totalPage}">
				<c:if test="${i==pagingInfo.currentPage}">
					<span style="color:blue; font-weight:bold;">${i}</span>
				</c:if>
				<c:if test="${i!=pagingInfo.currentPage}">
					<a href="#" onclick="pageProc(${i})">
 						[${i}]
 					</a>
				</c:if>
			</c:if>
				<!-- if를 여기다 쓰고 조건을 같을때==로 해도 무방하다. -->
		</c:forEach>
		
		<!-- 블록을 다음으로 전환하는 아이콘 '>' -->	
		<c:if test="${pagingInfo.lastPage < pagingInfo.totalPage }">
			<a href="#" onclick="pageProc(${pagingInfo.lastPage+1})"> 
				<img src='<c:url value="/images/last.JPG"/>'>
			</a>				
		</c:if>
    </div>
	
	<br>
	   	<form name="frm" method="post"
	   		action="<c:url value='/comment2/list.do'/> ">
        <select name="searchCondition">
            <option value="commentContent" 
            	<c:if test="${param.searchCondition == 'commentContent' }">
            		selected = "selected"
            	</c:if>
            >내용</option>
            <option value="userId" 
            	<c:if test="${param.searchCondition == 'userId' }">
            		selected = "selected"
            	</c:if>
            >아이디</option>
        </select>   
        <input type="text" name="searchKeyword" title="검색어 입력"
        	value="${param.searchKeyword}">   
		<input type="submit" value="검색">
    </form>
	
	<a href="<c:url value='/comment2/write.do'/> ">코멘트 등록</a>
</body>
</html>