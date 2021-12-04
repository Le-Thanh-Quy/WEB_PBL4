function loadFind() {
    var type = document.getElementById("type");
    const xhttp = new XMLHttpRequest();
    var table = document.getElementById("table");
    var key = document.getElementById("searchBox");
    if (type.value == 'Province') {
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<form action="DeleteProvince" method="post"><table><td></td><td></td><td></td> <td></td><td><input style="opacity: 0;" id="deleteBtn" type="submit" value="Xóa" ></td> <td></td>';
            html += '<tr><th>ID</th>' +
                '<th>Tên Tỉnh/Thành Phố</th>' +
                '<th>Kiểu</th>' +
                '<th>Chập nhật thông tin</th> ' +
                '<th>Chọn</th> ' +
                '<th>Danh sách Quận/Huyện</th> </tr>';
            for (const x of myObj) {
                html += ' <tr class="tag' + myObj.indexOf(x) % 2 + '"><td>' + x.matp + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td><a href="UpdateProvince?IDProvince=' + x.matp + '"><i style="color: #1877F2" class="fas fa-edit"></i></a></td> ' +
                    '<td><input onchange="Chosse(this)" id="cb" type="checkbox" name="cb" value="' + x.matp + '"/></td> ' +
                    '<td><button id="IDProv" type="button" onclick="loadDistrict(\'' + x.matp + '\')"><i\n' +
                    '                                class="fas fa-eye"></i> Chi tiết</button></td> </tr>';
            }
            html += '</table></form>';
            table.innerHTML = html;
        }
        xhttp.open("GET", "findProv?searchBox=" + key.value);
        xhttp.send();
    } else if (type.value == 'District') {
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<form action="DeleteDistrict" method="post"><table><td  class="back"><a href="getProv"><i class="fas fa-angle-double-left"></i></a></td><td></td> <td></td> <td><input type="hidden" name="IDProvince" value="' + IDDistrict + '"></td><td><input  id="deleteBtn" type="submit" value="Xóa" ></td> <td></td>';
            html += '<tr><th>ID</th>' +
                '<th>Tên Quận/Huyện</th>' +
                '<th>Kiểu</th>' +
                '<th>Cập nhật thông tin</th> ' +
                '<th>Chọn</th> ' +
                '<th>Danh sách Xã/Phường</th> </tr>';

            for (const x of myObj) {
                html += '<tr class="tag' + myObj.indexOf(x) % 2 + '"><td>' + x.maqh + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td><a href="UpdateDistrict?IDDistrict=' + x.maqh + '"><i style="color: #1877F2" class="fas fa-edit"></i></a></td> ' +
                    '<td><input type="checkbox" name="cb" value="' + x.maqh + '"/></td> ' +
                    '<td><button type="button" id="IDDistrict" onclick="loadCommune(\'' + x.maqh + '\')"><i\n' +
                    '                                class="fas fa-eye"></i> Chi tiết</button></td></tr>';
            }
            html += '</table></form>';
            table.innerHTML = html;
        }
        var IDDistrict = document.getElementById("idDistrict").value;
        xhttp.open("GET", "findDistrict?searchBox=" + key.value + "&IDDistrict=" + IDDistrict);
        xhttp.send();
    } else if (type.value == 'Commune') {
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);

            var html = '<form action="DeleteCommune" method="post"><table><td class="back"><a onclick="loadDistrict(`' + document.getElementById("idDistrict").value + '`)"><i class="fas fa-angle-double-left"></i></a></td><td></td><td></td> <td><input type="hidden" name="IDDistrict" value="' + IDCommune + '"></td><td><input   id="deleteBtn" type="submit" value="Xóa" ></td> <td></td>';
            html += '<tr><th>ID</th>' +
                '<th>Tên Xã/Phường</th>' +
                '<th>Kiểu</th>' +
                '<th>Cập nhật thông tin</th> ' +
                '<th>Chọn</th> ';
            for (const x of myObj) {
                html += '<tr class="tag' + myObj.indexOf(x) % 2 + '"><td>' + x.xaid + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td><a href=UpdateCommune?IDCommune=' + x.xaid + '><i style="color: #1877F2" class="fas fa-edit"></i></a></td>  ' +
                    '<td><input type="checkbox" name="cb" value="' + x.xaid + '"/></td> ';
            }
            html += '</table></form>';
            table.innerHTML = html;
        }
        var IDCommune = document.getElementById("idCommune").value;
        xhttp.open("GET", "findCommune?searchBox=" + key.value + "&IDCommune=" + IDCommune);
        xhttp.send();
    }

}

function loadDistrict(IDProv) {
    document.getElementById("type").value = "District";
    document.getElementById("idDistrict").value = IDProv;
    const xhttp = new XMLHttpRequest();
    var table = document.getElementById("table");
    xhttp.onload = function () {
        const myObj = JSON.parse(this.responseText);
        document.getElementById("Add").innerHTML = '<a href="AddDistrict?IDProvince=' + IDProv + '"><i class="fas fa-plus-square"></i>  Thêm Quận/Huyện</a>';
        var html = '<form action="DeleteDistrict" method="post"><table><td  class="back"><a href="getProv"><i class="fas fa-angle-double-left"></i></a></td><td></td><td></td> <td><input type="hidden" name="IDProvince" value="' + IDProv + '"></td><td><input   id="deleteBtn" type="submit" value="Xóa" ></td> <td></td>';
        html += '<tr><th>ID</th>' +
            '<th>Tên Quận/Huyện</th>' +
            '<th>Kiểu</th>' +
            '<th>Cập nhật thông tin</th> ' +
            '<th>Chọn</th> ' +
            '<th>Danh sách Xã/Phường</th> </tr>';

        for (const x of myObj) {
            html += '<tr class="tag' + myObj.indexOf(x) % 2 + '"><td>' + x.maqh + '</td>' +
                '<td>' + x.name + '</td>' +
                '<td>' + x.type + '</td>' +
                '<td><a href="UpdateDistrict?IDDistrict=' + x.maqh + '"><i style="color: #1877F2" class="fas fa-edit"></i></a></td> ' +
                '<td><input type="checkbox" name="cb" value="' + x.maqh + '"/></td> ' +
                '<td><button  type="button" id="IDDistrict" onclick="loadCommune(\'' + x.maqh + '\')"><i\n' +
                '                                class="fas fa-eye"></i> Chi tiết</button></td></tr>';
        }
        html += '</table></form>';
        table.innerHTML = html;
    }
    xhttp.open("GET", "GetDistrict?IDProv=" + IDProv);
    xhttp.send();
}

function loadCommune(IDDistrict) {
    document.getElementById("type").value = "Commune";
    document.getElementById("idCommune").value = IDDistrict;
    const xhttp = new XMLHttpRequest();
    var table = document.getElementById("table");
    xhttp.onload = function () {
        const myObj = JSON.parse(this.responseText);
        document.getElementById("Add").innerHTML = '<a href="AddCommune?IDDistrict=' + IDDistrict + '"><i class="fas fa-plus-square"></i>  Thêm Xã/Phường</a>';
        var html = '<form action="DeleteCommune" method="post"><table><td class="back"><a onclick="loadDistrict(`' + document.getElementById("idDistrict").value + '`)"><i class="fas fa-angle-double-left"></i></a></td><td></td><td></td> <td><input type="hidden" name="IDDistrict" value="' + IDDistrict + '"></td><td><input   id="deleteBtn" type="submit" value="Xóa" ></td> <td></td>';
        html += '<tr><th>ID</th>' +
            '<th>Tên Xã/Phường</th>' +
            '<th>Kiểu</th>' +
            '<th>Cập nhật thông tin</th> ' +
            '<th>Chọn</th> ';
        for (const x of myObj) {
            html += '<tr class="tag' + myObj.indexOf(x) % 2 + '"><td>' + x.xaid + '</td>' +
                '<td>' + x.name + '</td>' +
                '<td>' + x.type + '</td>' +
                '<td><a href=UpdateCommune?IDCommune=' + x.xaid + '><i style="color: #1877F2" class="fas fa-edit"></i></a></td> ' +
                '<td><input type="checkbox" name="cb" value="' + x.xaid + '"/></td> ';
        }
        html += '</table></form>';
        table.innerHTML = html;
    }
    xhttp.open("GET", "getCommune?IDDistrict=" + IDDistrict);
    xhttp.send();
}