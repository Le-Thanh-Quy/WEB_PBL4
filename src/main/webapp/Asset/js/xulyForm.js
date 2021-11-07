var TinhS, HuyenS, XaS, TinhE, HuyenE, XaE, SorE;

function SelectStart() {
    SorE = 0;
    var selectXaClone = document.getElementById("selectXaClone");
    selectXaClone.style.display = "block";
    var modal = document.getElementById("myModal");
    var selectTinh = document.getElementById("selectTinhS");
    var selectHuyen = document.getElementById("selectHuyen");
    selectHuyen.selectedIndex = "0";
    var nameTinh = document.getElementById("nameTinh");
    nameTinh.innerHTML = selectTinh.options[selectTinh.selectedIndex].text;
    selectHuyen.innerHTML = "<option selected>Chọn Quận/Huyện</option>";
    if (selectTinh.value != "Điểm khởi hành") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                selectHuyen.innerHTML += "<option value= " + x.maqh + ">" + x.name + "</option>";
            }
            var selectXa = document.getElementById("selectXa");
            selectXa.style.display = "none";
            modal.style.display = "block";
            TinhS = selectTinh.options[selectTinh.selectedIndex].text;
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function () {
                modal.style.display = "none";
                selectTinh.selectedIndex = "0";
            }
        }
        xhttp.open("GET", "getHuyen?id=" + selectTinh.options[selectTinh.selectedIndex].value);
        xhttp.send();
    }
}

function SelectEnd() {
    SorE = 1;
    var selectXaClone = document.getElementById("selectXaClone");
    selectXaClone.style.display = "block";
    var modal = document.getElementById("myModal");
    var selectTinh = document.getElementById("selectTinhE");
    var selectHuyen = document.getElementById("selectHuyen");
    selectHuyen.selectedIndex = "0";
    var nameTinh = document.getElementById("nameTinh");
    nameTinh.innerHTML = selectTinh.options[selectTinh.selectedIndex].text;
    selectHuyen.innerHTML = "<option selected>Chọn Quận/Huyện</option>";
    if (selectTinh.value != "Điểm đến") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                selectHuyen.innerHTML += "<option value= " + x.maqh + ">" + x.name + "</option>";
            }
            var selectXa = document.getElementById("selectXa");
            selectXa.style.display = "none";
            modal.style.display = "block";
            TinhE = selectTinh.options[selectTinh.selectedIndex].text;
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function () {
                modal.style.display = "none";
                selectTinh.selectedIndex = "0";
            }
        }
        xhttp.open("GET", "getHuyen?id=" + selectTinh.options[selectTinh.selectedIndex].value);
        xhttp.send();
    }
}

function SelectHuyen() {
    var selectXa = document.getElementById("selectXa");
    selectXa.selectedIndex = "0";
    var selectHuyen = document.getElementById("selectHuyen");
    selectXa.innerHTML = "<option selected>Chọn Xã/Phường</option>";
    if (selectHuyen.value != "Chọn Quận/Huyện") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                selectXa.innerHTML += "<option value= " + x.xaid + ">" + x.name + "</option>";
            }
            selectXa.style.display = "block";
            var selectXaClone = document.getElementById("selectXaClone");
            selectXaClone.style.display = "none";
            if (SorE == 0) {
                HuyenS = selectHuyen.options[selectHuyen.selectedIndex].text;
            } else {
                HuyenE = selectHuyen.options[selectHuyen.selectedIndex].text;
            }

        }
        xhttp.open("GET", "getXaPhuong?id=" + selectHuyen.options[selectHuyen.selectedIndex].value);
        xhttp.send();
    } else {
        selectXa.style.display = "none";
        var selectXaClone = document.getElementById("selectXaClone");
        selectXaClone.style.display = "block";
    }

}

function SelectXa() {
    if (selectXa.value != "Chọn Xã/Phường") {
        var modal = document.getElementById("myModal");
        modal.style.display = "none";
        if (SorE == 0) {
            XaS = selectXa.options[selectXa.selectedIndex].text;
            alert("Tỉnh: " + TinhS + ", Huyện: " + HuyenS + ", Xã: " + XaS);
        } else {
            XaE = selectXa.options[selectXa.selectedIndex].text;
            alert("Tỉnh: " + TinhE + ", Huyện: " + HuyenE + ", Xã: " + XaE);
        }


    }

}





window.onclick = function (event) {
    var modal = document.getElementById("myModal");
    var modal1 = document.getElementById("myModal-login");
    var modal2 = document.getElementById("myModal-signup");
    var modalpost = document.getElementById("myModal-newPost");
    var selectTinh;
    if (SorE == 0) {
        selectTinh = document.getElementById("selectTinhS");
    } else {
        selectTinh = document.getElementById("selectTinhE");
    }

    if (event.target == modal) {
        modal.style.display = "none";
        selectTinh.selectedIndex = "0";
    } else if (event.target == modal1) {
        modal1.style.display = "none";
    } else if (event.target == modal2) {
        modal2.style.display = "none";
    } else if (event.target == modalpost) {
        modalpost.style.display = "none";
    }
}




