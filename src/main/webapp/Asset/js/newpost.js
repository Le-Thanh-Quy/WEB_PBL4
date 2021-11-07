function newPost() {
    var post = document.getElementById("myModal-newPost");
    post.style.display = "block";
    var span = document.getElementsByClassName("close")[2];
    span.onclick = function () {
        post.style.display = "none";
    }
}

function ClosePost() {
    var post = document.getElementById("myModal-newPost");
    post.style.display = "none";
}

var loadFile = function (event) {
    var output = document.getElementById('out_img-newPost');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src);
        output.style.zIndex = '1000';
        var closeIMG = document.getElementById("closeIMG");
        closeIMG.style.display = 'block';
    }
};

function CloseChooseIMG() {
    var output = document.getElementById('out_img-newPost');
    var closeIMG = document.getElementById("closeIMG");
    output.src = "";
    output.style.zIndex = '0';
    closeIMG.style.display = 'none';
    document.getElementById("chooseIMGNewPost").value = null;

}

function selectTinhNewPost(check) {
    var newPostTinh = null;
    var newPostHuyen = null;
    var newPostXa = null;
    if (check == '0') {
        newPostTinh = document.getElementById("newPostTinhS");
        newPostHuyen = document.getElementById("newPostHuyenS");
        newPostXa = document.getElementById("newPostXaS");
    } else if (check == '1') {
        newPostTinh = document.getElementById("newPostTinhE");
        newPostHuyen = document.getElementById("newPostHuyenE");
        newPostXa = document.getElementById("newPostXaE");
    }

    newPostHuyen.innerHTML = "<option selected>Quận/Huyện</option>";
    newPostXa.innerHTML = "<option selected>Xã/Phường</option>";
    newPostHuyen.selectedIndex = "0";
    newPostXa.selectedIndex = "0";
    if (newPostTinh.value != "Tỉnh/Thành Phố") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                newPostHuyen.innerHTML += "<option value= " + x.maqh + ">" + x.name + "</option>";
            }
        }
        xhttp.open("GET", "getHuyen?id=" + newPostTinh.options[newPostTinh.selectedIndex].value);
        xhttp.send();
    }
}

function selectHuyenNewPost(check) {
    var newPostHuyen = null;
    var newPostXa = null;
    if (check == '0') {
        newPostHuyen = document.getElementById("newPostHuyenS");
        newPostXa = document.getElementById("newPostXaS");
    } else if (check == '1') {
        newPostHuyen = document.getElementById("newPostHuyenE");
        newPostXa = document.getElementById("newPostXaE");
    }

    newPostXa.innerHTML = "<option selected>Xã/Phường</option>";
    newPostXa.selectedIndex = "0";

    if (newPostHuyen.value != "Quận/Huyện") {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                newPostXa.innerHTML += "<option value= " + x.xaid + ">" + x.name + "</option>";
            }
        }
        xhttp.open("GET", "getXaPhuong?id=" + newPostHuyen.options[newPostHuyen.selectedIndex].value);
        xhttp.send();
    }
}

function dateNewPostChange(event) {
    var date = event.target.value;
    var d1 = new Date(date);
    var now = Date.now();
    var d2 = new Date(now);
    console.log(d2);
    if (d1 < now) {
        var day = d2.getDate().toString();
        if(d2.getDate() < 10){
            day = "0" + day;
        }
        var datestring =   d2.getFullYear() + "-" + (d2.getMonth() + 1) + "-" + day;
        console.log(datestring);
        event.target.value = datestring;
    }
}



