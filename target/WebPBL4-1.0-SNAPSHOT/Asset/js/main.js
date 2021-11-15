let ID = -1;

window.onhashchange= function () {
    alert("Hash đã được thay đổi!");
}

function btnAddH() {
    var icon = document.getElementById("icon");
    icon.style.backgroundImage = "url('./Asset/img/icon/addT.png')";
}

function btnAddL() {
    var icon = document.getElementById("icon");
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        icon.style.backgroundImage = "url('./Asset/img/icon/addD.png')";
    } else {
        icon.style.backgroundImage = "url('./Asset/img/icon/addT.png')";
    }

}


window.onscroll = function scroll() {
    var header = document.getElementById("menu");
    var active = document.getElementById("active");
    var logo = document.getElementById("logo");
    var text = document.getElementsByClassName("tab");
    var bg = document.getElementsByClassName("btnAdd");
    var icon = document.getElementById("icon");

    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        header.style.backgroundColor = "rgb(240 245 251)";
        header.style.height = "11%";
        logo.src = './Asset/img/black-logo.png';
        for (let index = 0; index < text.length; index++) {
            text[index].style.color = "black";
            text[index].style.fontSize = "16px";
        }
        if (bg.length > 0) {
            bg[0].style.backgroundColor = "#8d99af";
            bg[0].style.color = "white";
            bg[0].style.fontSize = "16px";
        }
        if (icon != null)
            icon.style.backgroundImage = "url('./Asset/img/icon/addD.png')";
        active.style.color = "#8d99af!important";
    } else {
        header.style.backgroundColor = "transparent";
        header.style.height = "13%";
        logo.src = ' ./Asset/img/white-logo.png';
        for (let index = 0; index < text.length; index++) {
            text[index].style.color = "white";
            text[index].style.fontSize = "18px";
        }
        if (bg.length > 0) {
            bg[0].style.backgroundColor = "rgb(224, 224, 224)";
            bg[0].style.color = "black";
            bg[0].style.fontSize = "18px";
        }
        if (icon != null)
            icon.style.backgroundImage = "url('./Asset/img/icon/addT.png')";
        active.style.color = "#8d99af!important";
    }
    if ((window.scrollY + window.innerHeight) >= document.body.scrollHeight - 1 && ID != -1 && check) {
        var loadPost = document.getElementById("loadPost");

        if (loadPost != null) {
            loadPost.style.display = "block";
        }
        check = false;
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            const myObj = JSON.parse(this.responseText);
            if (myObj.length == 0) {
                var loadPost = document.getElementById("loadPost");
                loadPost.style.display = "none";
            } else {
                LoadPost(myObj);
            }


        }
        var CheckPostType = document.getElementById("CheckPostType");
        if (CheckPostType.textContent == "Lịch trình mới nhất") {
            xhttp.open("GET", "getPosts?id=" + ID + "&userID=null");
            xhttp.send();
        } else {

            var search_StartReceive = document.getElementById("search_StartReceive").value;
            var search_EndReceive = document.getElementById("search_EndReceive").value;
            var TimeReceive = document.getElementById("TimeReceive").value;
            var DateReceive = document.getElementById("DateReceive").value;

            xhttp.open("POST", "getPosts?id=" + ID + "&search_Start=" + search_StartReceive +
                "&search_End=" + search_EndReceive + "&Time=" + TimeReceive +
                "&Date=" + DateReceive);
            xhttp.send();
        }

    }
}
var check = true;

function LoadPost(myObj) {
    for (const x of myObj) {
        ID = x.ID;
        var str = "";
        str +=
            '<div class="post">' +
            '<img class="post-img" src="' + x.Image + '" alt="">' +

            '<div class="post-main">' +
            '<h1>' + x.user.Name + '</h1>' +
            '<h5>' + x.DateTime + '</h5>' +

            '<ul class="rate">';

        for (var i = 1; i <= x.user.Assess.Rate; i++) {
            str += '<li><i class="fas fa-star"></i></li>';
        }
        for (var i = x.user.Assess.Rate; i <= 4; i++) {
            str += '<li><i class="far fa-star"></i></li>';
        }
        str +=
            '<li>(' + x.user.Assess.Review + ') Reviews</li>' +
            '</ul>' +

            '<div class="info">' +
            '<div class="start-info">' +
            '<h3>Điểm Xuất Phát</h3>' +
            '<ul class="address">' +
            '<li><i class="fas fa-map-marker-alt"></i> ' + x.StartProvince + '</li>' +
            '<li><i class="fas fa-map-marker-alt"></i> ' + x.StartDistrict + '</li>' +
            '<li><i class="fas fa-map-marker-alt"></i> ' + x.StartCommune + '</li>' +
            '</ul>' +
            '  </div>' +
            ' <div class="time-info">' +
            '  <h3>Thời gian: </h3>' +
            '    <p><i class="far fa-clock"></i> ' + x.TimeStart + '</p>' +
            '    <p><i class="far fa-calendar-alt"></i> ' + x.Date + '</p>' +

            ' </div>' +
            '<div class="end-info">' +
            '<h3>Điểm Đến</h3>' +
            '<ul class="address">' +
            '<li><i class="fas fa-map-marker"></i> ' + x.EndProvince + '</li>' +
            '<li><i class="fas fa-map-marker"></i> ' + x.EndDistrict + '</li>' +
            '<li><i class="fas fa-map-marker"></i> ' + x.EndCommune + '</li>' +
            '</ul>' +
            '</div>' +


            '</div>' +
            '<div class="status">' +
            '<p><i class="far fa-clipboard"></i> ' + x.Caption + '</p>' +
            '</div>' +
            '<div class="post-button">' +
            ' <a href=""><i class="far fa-comment"></i> Liên Hệ </a>' +
            '<a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>' +
            '<a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>' +
            '</div>' +
            '</div>' +
            '</div>';
        document.getElementById("list-post").innerHTML += str;
    }

    check = true;
    var loadPost = document.getElementById("loadPost");
    loadPost.style.display = "none";
}

window.onload = function Load() {
    check = true;
    var header = document.getElementById("menu");
    header.style.height = "13%";
    var text = document.getElementsByClassName("tab");
    var bg = document.getElementsByClassName("btnAdd");
    if (bg.length != 0) {
        bg[0].style.fontSize = "18px";
    }
    for (let index = 0; index < text.length; index++) {
        text[index].style.fontSize = "18px";
    }
}

function MenuOn() {
    var menu = document.getElementById("menu_logout");
    menu.style.display = "block";

}

function MenuOff() {
    var menu = document.getElementById("menu_logout");
    menu.style.display = "none";
}






