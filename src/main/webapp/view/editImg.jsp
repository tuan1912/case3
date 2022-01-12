<%--
  Created by IntelliJ IDEA.
  User: BUI VIET THANG
  Date: 04/01/2022
  Time: 1:08 AM
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
<form method="post">
    <table border="1">
        <tr>
            <th>idImg</th>
            <th>idProduct</th>
            <th>img</th>
        </tr>
        <tr>
            <td><input type="text" name="idImg" value="${listImgEdit.idImg}" readonly></td>
            <td><input type="text" name="idProduct" value="${listImgEdit.idProduct}"></td>
            <td><input type="text" name="img" value="${listImgEdit.img}"></td>
        </tr>
        <button type="submit">Update Img</button>
    </table>
</form>
</body>
</html>
