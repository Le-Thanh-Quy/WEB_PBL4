function loadFind() {
    var type = document.getElementById("type");
    const xhttp = new XMLHttpRequest();
    var table = document.getElementById("table");
    var key = document.getElementById("searchBox");
    if (type.value == 'Province') {
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<form action="DeleteProvince" method="post"><table><td></td><td></td> <td></td><td></td> <td></td><td><input type="submit" value="Delete"></td> <td></td>';
            html += '<tr><th>matp</th>' +
                '<th>name</th>' +
                '<th>type</th>' +
                '<th>slug</th>' +
                '<th>Click to update Province</th> ' +
                '<th>Click to delete Province</th> ' +
                '<th>Click to add/up/del District</th> </tr>';
            for (const x of myObj) {
                html += '<tr><td>' + x.matp + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td>' + x.slug + '</td> ' +
                    '<td><a href="UpdateProvince?IDProvince='+x.matp+'">Update</a></td> ' +
                    '<td><input type="checkbox" name="cb" value="' + x.matp + '"/></td> ' +
                    '<td><button id="IDProv" type="button" onclick="loadDistrict(\'' + x.matp + '\')">Go</button></td> </tr>';
            }
            html += '</table></form>';
            table.innerHTML = html;
        }
        xhttp.open("GET", "findProv?searchBox=" + key.value);
        xhttp.send();
    } else if (type.value == 'District') {
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            var html = '<form action="DeleteDistrict" method="post"><table><td></td><td></td> <td></td><td></td> <td><input type="hidden" name="IDProvince" value="'+IDDistrict+'"></td><td><input type="submit" value="Delete"></td> <td></td>';
            html += '<tr><th>maqh</th>' +
                '<th>name</th>' +
                '<th>type</th>' +
                '<th>matp</th>' +
                '<th>Click to update District</th> ' +
                '<th>Click to delete District</th> ' +
                '<th>Click to add/up/del Commune</th> </tr>';

            for (const x of myObj) {
                html += '<tr><td>' + x.maqh + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td>' + x.matp + '</td> ' +
                    '<td><a href="UpdateDistrict?IDDistrict='+x.maqh+'">Update</a></td> ' +
                    '<td><input type="checkbox" name="cb" value="' + x.maqh + '"/></td> ' +
                    '<td><button type="button" id="IDDistrict" onclick="loadCommune(\'' + x.maqh + '\')">Go</button></td></tr>';
            }
            html += '</table></form>';
            table.innerHTML = html;
        }
        var IDDistrict = document.getElementById("idDistrict").value;
        xhttp.open("GET", "findDistrict?searchBox=" + key.value + "&IDDistrict=" + IDDistrict);
        xhttp.send();
    }else if(type.value == 'Commune'){
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);

            var html = '<form action="DeleteCommune" method="post"><table><td></td><td></td> <td></td><td></td> <td><input type="hidden" name="IDDistrict" value="'+IDCommune+'"></td><td><input type="submit" value="Delete"></td> <td></td>';
            html += '<tr><th>xaid</th>' +
                '<th>name</th>' +
                '<th>type</th>' +
                '<th>maqh</th>' +
                '<th>Click to update Commune</th> ' +
                '<th>Click to delete Commune</th> ';
            for (const x of myObj) {
                html += '<tr><td>' + x.xaid + '</td>' +
                    '<td>' + x.name + '</td>' +
                    '<td>' + x.type + '</td>' +
                    '<td>' + x.maqh + '</td> ' +
                    '<td><a href=UpdateCommune?IDCommune='+x.xaid+'>Update</a></td>  ' +
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
        document.getElementById("Add").innerHTML = '<a href="AddDistrict?IDProvince='+IDProv+'">Add District</a>';
        var html = '<form action="DeleteDistrict" method="post"><table><td></td><td></td> <td></td><td></td> <td><input type="hidden" name="IDProvince" value="'+IDProv+'"></td><td><input type="submit" value="Delete"></td> <td></td>';
        html += '<tr><th>maqh</th>' +
            '<th>name</th>' +
            '<th>type</th>' +
            '<th>matp</th>' +
            '<th>Click to update District</th> ' +
            '<th>Click to delete District</th> ' +
            '<th>Click to add/up/del Commune</th> </tr>';

        for (const x of myObj) {
            html += '<tr><td>' + x.maqh + '</td>' +
                '<td>' + x.name + '</td>' +
                '<td>' + x.type + '</td>' +
                '<td>' + x.matp + '</td> ' +
                '<td><a href="UpdateDistrict?IDDistrict='+x.maqh+'">Update</a></td> ' +
                '<td><input type="checkbox" name="cb" value="' + x.maqh + '"/></td> ' +
                '<td><button  type="button" id="IDDistrict" onclick="loadCommune(\'' + x.maqh + '\')">Go</button></td></tr>';
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
        document.getElementById("Add").innerHTML = '<a href="AddCommune?IDDistrict='+IDDistrict+'">Add Commune</a>';
        var html = '<form action="DeleteCommune" method="post"><table><td></td><td></td> <td></td><td></td> <td><input type="hidden" name="IDDistrict" value="'+IDDistrict+'"></td><td><input type="submit" value="Delete"></td> <td></td>';
        html += '<tr><th>xaid</th>' +
            '<th>name</th>' +
            '<th>type</th>' +
            '<th>maqh</th>' +
            '<th>Click to update Commune</th> ' +
            '<th>Click to delete Commune</th> ';
        for (const x of myObj) {
            html += '<tr><td>' + x.xaid + '</td>' +
                '<td>' + x.name + '</td>' +
                '<td>' + x.type + '</td>' +
                '<td>' + x.maqh + '</td> ' +
                '<td><a href=UpdateCommune?IDCommune='+x.xaid+'>Update</a></td> ' +
                '<td><input type="checkbox" name="cb" value="' + x.xaid + '"/></td> ';
        }
        html += '</table></form>';
        table.innerHTML = html;
    }
    xhttp.open("GET", "getCommune?IDDistrict=" + IDDistrict);
    xhttp.send();
}