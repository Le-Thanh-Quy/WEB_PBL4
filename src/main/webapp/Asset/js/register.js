var loadFile = function (event) {
    var output = document.getElementById('out_img');
    var avatar = document.getElementById("avatar");
    const value = event.target.value;
    console.log(value);
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src);
        avatar.value = output.src;
    }
};


function selectTinhRegister() {
    var selectTinh = null;
    var selectHuyen = null;
    var selectXa = null;
    selectTinh = document.getElementById("selectTinh");
    selectHuyen = document.getElementById("selectHuyen");
    selectXa = document.getElementById("selectXa");

    selectHuyen.innerHTML = "<option selected>Quận/Huyện</option>";
    selectXa.innerHTML = "<option selected>Xã/Phường</option>";
    selectHuyen.selectedIndex = "0";
    selectXa.selectedIndex = "0";
    if (selectTinh.value != "Tỉnh/Thành Phố") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                selectHuyen.innerHTML += "<option value= " + x.maqh + ">" + x.name + "</option>";
            }
        }
        xhttp.open("GET", "getHuyen?id=" + selectTinh.options[selectTinh.selectedIndex].value);
        xhttp.send();
    }
}

function selectHuyenRegister() {
    var selectHuyen = null;
    var selectXa = null;

    selectHuyen = document.getElementById("selectHuyen");
    selectXa = document.getElementById("selectXa");

    selectXa.innerHTML = "<option selected>Xã/Phường</option>";
    selectXa.selectedIndex = "0";

    if (selectHuyen.value != "Quận/Huyện") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                selectXa.innerHTML += "<option value= " + x.xaid + ">" + x.name + "</option>";
            }
        }
        xhttp.open("GET", "getXaPhuong?id=" + selectHuyen.options[selectHuyen.selectedIndex].value);
        xhttp.send();
    }
}

