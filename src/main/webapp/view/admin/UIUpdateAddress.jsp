<%--
  Created by IntelliJ IDEA.
  User: MSI
  Date: 11/21/2021
  Time: 8:42 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <script src="${pageContext.request.contextPath}/Asset/js/Update.js"></script>
</head>
<body>

<input type="search" name="searchBox" id="searchBox">
<button for="searchBox" onclick="loadFind()">OK</button>
<input type="hidden" id="type" value="Province">
<input type="hidden" id="idDistrict" value="">
<input type="hidden" id="idCommune" value="">
<br>

<div id="Add">
    <a href="${pageContext.request.contextPath}/AddProvince">Add
        Province</a>
</div>


<div id="table">
    <form action="${pageContext.request.contextPath}/DeleteProvince" method="post">
        <table>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><input type="submit" value="Delete"></td>
            <td></td>
            <tr>
                <th>matp</th>
                <th>name</th>
                <th>type</th>
                <th>slug</th>
                <th>Click to update Province</th>
                <th>Click to delete Province</th>
                <th>Click to add/up/del District</th>
            </tr>
            <c:forEach items="${listProv}" var="prov">
                <tr>
                    <td>${prov.getMatp()}</td>
                    <td>${prov.getName()}</td>
                    <td>${prov.getType()}</td>
                    <td>${prov.getSlug()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/UpdateProvince?IDProvince=${prov.getMatp()}">Update</a>
                    </td>
                    <td><input type="checkbox" name="cb" value="${prov.getMatp()}"/></td>
                    <td>
                        <button id="IDProv" type="button" onclick="loadDistrict('${prov.getMatp()}')">Go</button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>
</body>
</html>
