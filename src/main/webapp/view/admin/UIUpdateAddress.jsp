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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
</head>
<body>

<input class="search" type="search" name="searchBox" id="searchBox" onkeyup="loadFind()"
       placeholder="Tìm kiếm"
       onfocus="this.placeholder = 'Nhập vào tên...';"
       onblur="this.placeholder = 'Tìm kiếm';">
<i class="fas fa-search"></i>
<input type="hidden" id="type" value="Province">
<input type="hidden" id="idDistrict" value="">
<input type="hidden" id="idCommune" value="">
<br>

<div id="Add" class="Add">
    <a href="${pageContext.request.contextPath}/AddProvince"><i class="fas fa-plus-square"></i>  Thêm Tỉnh/Thành Phố</a>
</div>


<div id="table">
    <form action="${pageContext.request.contextPath}/DeleteProvince" method="post">
        <table>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><input style="opacity: 0;" id="deleteBtn" type="submit" value="Xóa" ></td>
            <td></td>
            <tr>
                <th>ID</th>
                <th>Tên Tỉnh/Thành Phố</th>
                <th>Kiểu</th>
                <th>Cập nhật thông tin</th>
                <th>Chọn</th>
                <th>Danh sách Quận/Huyện</th>
            </tr>
            <c:forEach items="${listProv}" var="prov">
                <tr class="tag${listProv.indexOf(prov)%2}">
                    <td>${prov.getMatp()}</td>
                    <td>${prov.getName()}</td>
                    <td>${prov.getType()}</td>
                    <td>
                        <a href="${pageContext.request.contextPath}/UpdateProvince?IDProvince=${prov.getMatp()}"><i
                                style="color: #1877F2"
                                class="fas fa-edit"></i></a>
                    </td>
                    <td><input onchange="Chosse(this)" id="cb" type="checkbox" name="cb" value="${prov.getMatp()}"/></td>
                    <td>
                        <button id="IDProv" type="button" onclick="loadDistrict('${prov.getMatp()}')"><i
                                class="fas fa-eye"></i> Chi tiết
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>
</body>
</html>
<script>
    function removeElement(array, elem) {
        var index = array.indexOf(elem);
        if (index > -1) {
            array.splice(index, 1);
        }
    }
    var listChoose = [];
    function Chosse(cb) {
        if(listChoose.indexOf(cb) == -1){
            listChoose.push(cb);
        }else{
            removeElement(listChoose, cb);
        }
        if(listChoose.length == 0){
            document.getElementById("deleteBtn").style.opacity = '0';
        }else{
            document.getElementById("deleteBtn").style.opacity = '1';
        }
    }
</script>
