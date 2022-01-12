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
            <th>idSupplier</th>
            <th>nameSupplier</th>
            <th>descriptionSupplier</th>
        </tr>
        <tr>
            <td><input type="text" name="idSupplier" value="${listSupplierEdit.idSupplier}" readonly></td>
            <td><input type="text" name="nameSupplier" value="${listSupplierEdit.nameSupplier}"></td>
            <td><input type="text" name="descriptionSupplier" value="${listSupplierEdit.descriptionSupplier}"></td>
        </tr>
        <button type="submit">Update Supplier</button>
    </table>
</form>
</body>
</html>
