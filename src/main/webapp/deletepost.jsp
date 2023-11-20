<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@page import="com.example.project4.DAO.MemberDAO, com.example.project4.VO.MemberVO"%>
<%@ page import="com.example.project4.VO.MemberVO" %>
<%
	String sid = request.getParameter("id");
	if (sid != ""){
		int id = Integer.parseInt(sid);
		MemberVO u = new MemberVO();
		u.setSid(id);
		MemberDAO memberDAO = new MemberDAO();
		memberDAO.deleteMember(u);
	}
	response.sendRedirect("posts.jsp");
%>