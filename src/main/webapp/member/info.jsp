<%@page import="db.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/info.jsp</title>
</head>
<body>
<h1>프로필 보기</h1>
<%
MemberDTO dto = (MemberDTO)request.getAttribute("dto");
%>
<table border='1'>
<tr><td>아이디 : <%=dto.getId() %></td>
	<td>비밀번호 : <%=dto.getPass() %></td>
	<td>이름 : <%=dto.getName() %></td>
	<td>가입날짜 : <%=dto.getDate() %></td></tr>
</table>
<input type="file" id="fileup" name="fileup">
<a href="MemberMain.me">메인으로 이동</a>
</body>
</html>