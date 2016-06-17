<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>

<%@ include file="./include/header.jsp"%>
<html>
<head>

	<title>게시판</title>
</head>
<body>
<h1>
	게시판
</h1>
<table class="table">
	
	<thead>
		<th>번호</th>
		<th>타이틀</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</thead>
	
	<tbody>
	<c:forEach items="${list}" var="vo">
		<tr>
		<td>${vo.board_no}</td>							
		<td><a href="/rest/${vo.board_no}">${vo.title}(${vo.reply_cnt})</a></td>						
		<td>${vo.user_name}</td>		
		<td>${vo.regdate}</td>
		<td>${vo.regdate}</td>							
		<td></td>						
		</tr>
	</c:forEach>
	</tbody>
	
	<form action="/rest/new" method="GET">
	<input type="hidden" id="write" name="write" value="insert"/>
	<input type="submit" id="btn"  value="글쓰기"/>		
	</form>
	
</table>
	<%@ include file="./include/footer.jsp"%>
	
</body>
</html>
