<%--
  Created by IntelliJ IDEA.
  User: eziwon
  Date: 11/19/23
  Time: 3:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.io.File" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<html>
<head>
    <title>File Upload</title>
</head>
<body>
<%
    String filename = "";   // store file name
    int sizeLimit = 15 * 1024 * 1024;   //file size(15MB)

    String realPath = request.getServletContext().getRealPath("upload");

    File dir = new File(realPath);
    if (!dir.exists()) dir.mkdirs();

    MultipartRequest multipartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());

    filename = multipartRequest.getFilesystemName("photo");
%>
</body>
</html>
