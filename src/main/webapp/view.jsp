<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page import="com.example.project4.DAO.MemberDAO, com.example.project4.VO.MemberVO" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>회원 정보</title>
</head>
<body>
<%
    MemberDAO memberDAO = new MemberDAO();
    String id = request.getParameter("id");
    MemberVO u = memberDAO.getMember(Integer.parseInt(id));
    request.setAttribute("vo", u);
%>
<h1>회원 정보 보기</h1>
<table id="edit">
    <tr>
        <td>User ID</td><td>${vo.getUserid()}</td>
    </tr>
    <tr>
        <td>Name</td><td>${vo.getUsername()}</td>
    </tr>
    <tr>
        <td>Email</td><td>${vo.getEmail()}</td>
    </tr>
    <tr>
        <td>Detail</td><td>${vo.getDetail()}</td>
    </tr>
    <tr>
        <td>Regist Date</td><td>${vo.getRegdate()}</td>
    </tr>
</table>
<button type="button" onclick="history.back()">뒤로 가기</button>
<button type="button" onclick="location.href='editform.jsp?id=${vo.getSid()}'">수정하기</button>
</body>
</html>
