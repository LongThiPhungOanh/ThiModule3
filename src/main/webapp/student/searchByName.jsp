<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/28/2023
  Time: 1:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="container">
  <table style="border-collapse: collapse; border: 1px" class="table table-hover">
    <tr style="margin-top: 500px">
      <th>#</th>
      <th>Name</th>
      <th>Email</th>
      <th>Date Of Birth</th>
      <th>Address</th>
      <th>Phone Number</th>
      <th>Class Room</th>
    </tr>
    <c:forEach items="${students}" var="s">
      <tr>
        <td><c:out value="${s.getId()}"/></td>
        <td><c:out value="${s.getName()}"/></td>
        <td><c:out value="${s.getEmail()}"/></td>
        <td><c:out value="${s.getDateOfBirth()}"/></td>
        <td><c:out value="${s.getAddress()}"/></td>
        <td><c:out value="${s.getPhoneNumber()}"/></td>
        <td><c:out value="${s.getClassRom().getId()}"/></td>
      </tr>
    </c:forEach>
  </table>
  </table>
  <a class="btn btn-info" href="/students">Back to list</a>
</div>
</body>
</html>
