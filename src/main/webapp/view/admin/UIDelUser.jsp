<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/Asset/css/table.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>Danh sach nguoi dung</title>
</head>
<script>
    function loadDataUser() {
        const xhttp = new XMLHttpRequest();
        var table = document.getElementById("tableUser");
        var key = document.getElementById("searchBox");
        var select = document.getElementById("permission");
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<form action="DelUser?del=true" method="post"><table>';
            html += '<tr><td></td> <td></td> <td></td> <td></td> <td></td><td></td><td><input type="submit" value="Delete"/></td></tr>';
            html += '<tr><th>ID</th><th>Tên</th>' +
                '<th>Ngày sinh</th>' +
                '<th>Giới tính</th>' +
                '<th>Số điện thoại</th>' +
                '<th>Phân quyền</th><' +
                '<th>Chọn</th> </tr>';
            for (const x of myObj) {
                html += "<tr><td>" + x.ID + "</td>" +
                    "<td>" + x.Name + "</td>" +
                    "<td>" + x.Age + "</td>" +
                    "<td>" + x.Sex + "</td> " +
                    "<td>" + x.Phone_Number + "</td>";
                if (x.Permission == 1) {
                    html += "<td>Quản lý</td>";
                } else {
                    html += "<td>Người dùng</td>";
                }
                html += "<td><input type='checkbox' name='cb'' value='" + x.ID + "'/></td></tr>";
            }

            html += '</table></form>';
            table.innerHTML = html;
        }
        xhttp.open("GET", "FindUserForAdmin?searchBox=" + key.value + "&permission=" + select.value);
        xhttp.send();
    }
</script>

<body>
<input onkeyup="loadDataUser()" placeholder="Nhập vào id,tên,giới tính,số điện thoại..." type="search" name="searchBox"
       id="searchBox" onfocus="
document.getElementById('permission').selectedIndex = 0;
">
<br>
<label for="permission">Chọn phân quyền người dùng:</label>
<select id="permission" onchange="loadDataUser()" onfocus="function Rs1() {
document.getElementById('searchBox').value = '';
}
Rs1()">
    <option value="3">Tất cả</option>
    <option value="1">Quản lý</option>
    <option value="0">Người dùng</option>
</select>
<div id="tableUser">
    <form action="DelUser?del=true" method="post">
        <table>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
                <td><input type="submit" value="Delete"/></td>
            </tr>
            <tr>
                <th>ID</th>
                <th>Tên</th>
                <th>Ngày sinh</th>
                <th>Giới tính</th>
                <th>Số điện thoại</th>
                <th>Phân quyền</th>
                <th>Chọn</th>
            </tr>
            <c:forEach items="${listUser}" var="user">
                <tr>
                    <td>${user.getID()}</td>
                    <td>${user.getName()}</td>
                    <td>${user.getAge()}</td>
                    <td>${user.getSex()}</td>
                    <td>${user.getPhone_Number()}</td>
                    <c:if test="${user.getPermission()==0}">
                        <td>Người dùng</td>
                    </c:if>
                    <c:if test="${user.getPermission()==1}">
                        <td>Quản lý</td>
                    </c:if>
                    <td><input type="checkbox" name="cb" value="${user.getID()}"/></td>
                </tr>
            </c:forEach>
        </table>
    </form>

</div>

</body>

</html>

