<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.example.project4.DAO.MemberDAO, com.example.project4.VO.MemberVO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Form</title>
</head>
<body>

<%
	MemberDAO memberDAO = new MemberDAO();
	String id=request.getParameter("id");
	MemberVO u=memberDAO.getMember(Integer.parseInt(id));
%>

<h1>Edit Member</h1>
<form action="editpost.jsp" method="post">
<input type="hidden" name="sid" value="<%=u.getSid() %>"/>
<table id="edit">
	<tr><td>User ID:</td><td><input type="text" name="userid" value="<%= u.getUserid()%>" /></td></tr>
	<tr><td>Name:</td><td><input type="text" name="username" value="<%= u.getUsername()%>" /></td></tr>
	<tr><td>Email:</td><td><input type="text" name="email" value="<%= u.getEmail()%>" /></td></tr>
	<tr><td>Detail:</td><td><textarea cols="50" rows="5" name="detail"><%= u.getDetail()%></textarea></td></tr>
</table>
<button type="button" onclick="history.back()">back</button>
<button type="submit">edit</button>
</form>
</body>
</html>