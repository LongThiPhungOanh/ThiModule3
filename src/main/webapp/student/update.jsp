<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 8/23/2023
  Time: 2:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<html>
<head>
  <title>Title</title>
</head>
<body>
<div class="container">
  <h1 style="text-align: center">Create Student</h1>
  <form style="width: 500px; margin: auto"
        action="students?action=create" method="post">
    <div class="mb-3">
      <label for="name" class="form-label">Name</label>
      <input type="text" class="form-control" id="name"
             name="name" value="${student.getName()}" required>
    </div>
    <div class="mb-3">
      <label for="email" class="form-label">Email</label>
      <input type="email" class="form-control" id="email"
             name="email" value="${student.getEmail()}" required>
    </div>
    <div class="mb-3">
      <label for="date" class="form-label">Date Of Birth</label>
      <input type="date" class="form-control" id="date"
             name="date" value="${student.getDateOfBirth()}" required>
    </div>
    <div class="mb-3">
      <label for="address" class="form-label">Address</label>
      <input type="text" class="form-control" id="address"
             name="address" value="${student.getAddress()}" required>
    </div>
    <div class="mb-3">
      <label for="phone" class="form-label">Phone Number</label>
      <input type="text" class="form-control" id="phone"
             name="phone" value="${student.getPhoneNumber()}" required>
    </div>
    <div class="mb-3" >
      <label for="classRoom" class="form-label">Class Room</label>
      <select class="form-control" name="classRoom" id="classRoom" style="width: 150px;height: 34px;border-radius: 5px">
        <c:forEach items="${classRoms}" var="c">
          <option value="${c.getId()}" ><c:out value="${c.getName()}"/></option>
        </c:forEach>
      </select>
    </div>
    <button class="btn btn-primary" type="submit">Create</button>
    <button class="btn btn-secondary" type="reset">Reset</button>
  </form>

  <a class="btn btn-info" href="/students">Back to list</a>


</div>
</body>
</html>
