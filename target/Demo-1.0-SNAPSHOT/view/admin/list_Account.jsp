<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="Model.BEAN.UserForAdmin" %>
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
        var select = document.getElementById("phan_quyen");
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<table>';
            html += '<tr><th>ID</th><th>Tên</th><th>Ngày sinh</th><th>Giới tính</th><th>Đánh giá</th><th>Phân quyền</th><th>Action</th> </tr>';
            for (const x of myObj) {
                html += "<tr><td>" + x.ID + "</td>" +
                    "<td>" + x.Name + "</td>" +
                    "<td>" + x.Age + "</td>" +
                    "<td>" + x.Sex + "</td> " +
                    "<td>" + x.Rate + "</td>";
                    if(x.Roles==1){
                        html+= "<td>Admin</td>" ;
                    }else{
                        html+="<td>Người dùng</td>";
                    }
                html+="<td> <a href=''> <i class='fas fa-eye'></i> " +
                    "</a> <a href=''> <i class='fas fa-edit'></i> </a>" +
                    " <a href=''> <i class='fas fa-trash-alt'></i> </a> </td> </tr>";
            }
            html += '</table>';
            table.innerHTML = html;
        }
        xhttp.open("GET", "FindUserForAdmin?searchBox=" + key.value+ "&phan_quyen=" +select.value);
        xhttp.send();
    }
</script>

<body>
<input type="search" name="searchBox" id="searchBox" onfocus="function Rs() {
document.getElementById('phan_quyen').selectedIndex = 0;
}
Rs()">
<button for="searchBox" onclick="loadDataUser()">OK</button>
<br>
<label for="phan_quyen">Chọn phân quyền người dùng:</label>
<select id="phan_quyen" onchange="loadDataUser()" onfocus="function Rs1() {
document.getElementById('searchBox').value = '';
}
Rs1()">
    <option value="3">Chọn đi nào</option>
    <option value="1">Admin</option>
    <option value="0">Người dùng</option>
</select>
<div id="tableUser">
    <table>
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Ngày sinh</th>
            <th>Giới tính</th>
            <th>Đánh giá</th>
            <th>Phân quyền</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.getID()}</td>
                <td>${user.getName()}</td>
                <td>${user.getAge()}</td>
                <td>${user.getSex()}</td>
                <td>${user.getRate()}</td>
                <c:if test="${user.getRoles()==0}">
                    <td>Người dùng</td>
                </c:if>
                <c:if test="${user.getRoles()==1}">
                    <td>Admin</td>
                </c:if>
                <td>
                    <a href=""> <i class="fas fa-eye"></i> </a>
                    <a href=""> <i class="fas fa-edit"></i> </a>
                    <a href=""> <i class="fas fa-trash-alt"></i> </a>
                </td>
            </tr>
        </c:forEach>

    </table>
</div>

</body>

</html>
