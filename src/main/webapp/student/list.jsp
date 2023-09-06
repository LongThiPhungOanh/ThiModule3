<%--
Created by IntelliJ IDEA.
User: Admin
Date: 8/24/2023
Time: 10:30 AM
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
<div style="display:flex ;justify-content: space-between">
    <div style="text-align: center; width: 300px" class="mb-3">
        <form action="students?action=searchByName" method="post">
            <label for="name" class="form-label">Search By Name</label>
            <input style="text-align: center" type="text" class="form-control" id="name"
                   name="name" required>
            <button style="margin-top: 6px" class="btn btn-primary" type="submit">Search</button>
        </form>
        <a style="margin-left: 1px" class="btn btn-primary" href="students?action=create">Create</a>
    </div>
</div>
<h1 style="text-align: center">List Students</h1>
    <table style="border-collapse: collapse; border: 1px" class="table table-hover">
        <tr style="margin-top: 500px">
            <th>#</th>
            <th>Name</th>
            <th>Email</th>
            <th>Date Of Birth</th>
            <th>Address</th>
            <th>Phone Number</th>
            <th>Class Room</th>
            <th colspan="2"></th>
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
                <td><a class="btn btn-warning"  href="students?action=update&&id=${s.getId()}">Update</a></td>
                <td><a class="btn btn-danger" onclick="deleteA(${s.getId()})">Delete</a></td>
            </tr>
        </c:forEach>
    </table>

</body>
<script>
    function deleteA(id) {
        if (confirm("Are you sure?")) {
            window.location.href = "students?action=delete&&id=" + id
        }
    }
</script>
</html>