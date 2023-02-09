<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>member/main.jsp</title>
</head>
<body>
<h1>member/main.jsp</h1>
<%
// session.setAttribute("id", 모든 참조형값); => 업캐스팅(자동형변환)
// 자식 = 업캐스팅된 부모(다운캐스팅 명시적으로 형변환)
String id=(String)session.getAttribute("id");
// 세션값이 없으면(세션값이 null 이면) => loginForm.jsp 
if(id==null){
	response.sendRedirect("MemberLoginForm.me");
}
%>
<%=id %>님 로그인 하셨습니다.
<a href="MemberLogout.me">로그아웃</a><br>
<a href="MemberInfo.me">회원정보조회</a><br>
<a href="MemberUpdateForm.me">회원정보수정</a><br>
<a href="MemberDeleteForm.me">회원정보삭제</a><br>
<%
//로그인 한 회원
if(id!=null){
	// admin 인 경우 
	if(id.equals("admin")){
		%>
		<a href="MemberList.me">회원목록</a><br>
		<%
	}
}
%>
<a href="../board/writeForm.jsp">글쓰기</a><br>
<a href="../board/list.jsp">글목록</a><br>
</body>
</html>




