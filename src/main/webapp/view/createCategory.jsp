<%--
  Created by IntelliJ IDEA.
  User: BUI VIET THANG
  Date: 04/01/2022
  Time: 1:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form action="/?action=create" method="post">
    <table border="1">
        <tr>
            <th>nameCategory</th>
            <th>codeCategory</th>
            <th>descriptionCategory</th>
        </tr>
        <tr>
            <td><input type="text" name="nameCategory" placeholder="Enter Name"></td>
            <td><input type="text" name="codeCategory" placeholder="Enter Code"></td>
            <td><input type="text" name="descriptionCategory" placeholder="Enter Description"></td>
        </tr>
        <button type="submit">Create</button>
    </table>
</form>
</body>
</html>
