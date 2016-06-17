<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false" %>
<%@ include file="./include/header.jsp"%>
<html>
<head>
	<title>글읽기</title>
</head>
<body>
<h1>
	글 읽기
</h1>

<form id="frm2" name="frm2" action="/{board_no}" method="GET"/>
<table class="table">
		<tr>
		<td>제목</td>
		<td><input type="text" id="title" name="title" value="${vo.title}"/></td>
		</tr>
		
		<tr>
		<td>작성자</td>
		<td><input type="text" id="user_name" name="user_name" value="${vo.user_name}"/></td>
		</tr>
		
		<tr>
		<td>내용</td>
		<td><input type="text" id="content" name="content" value="${vo.content}"/></td>
		</tr>
</table>
	<input type="submit" id="sub" name="sub" value="등록"/>
	<%@ include file="./include/footer.jsp"%>
</body>
</html>
