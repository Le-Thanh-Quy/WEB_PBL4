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
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    if ((window.scrollY + window.innerHeight) >= document.body.scrollHeight - 1 && frameDetalInfo.style.display == "none") {
        var loadPost = document.getElementById("loadPost");
        if (check) {
            if (loadPost != null) {
                loadPost.style.display = "block";
            }
            check = false;
            const xhttp = new XMLHttpRequest();
            xhttp.onload = function () {
                const myObj = JSON.parse(this.responseText);
                LoadPost(myObj);

            }
            xhttp.open("GET", "getPosts?id=" + ID + "&userID=" + UserID);
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


window.onload = function LoadFormAccount() {
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var framePostInfo = document.getElementById("framePostInfo");
    framePostInfo.style.display = "block";
    frameDetalInfo.style.display = "none";
    var header = document.getElementById("menu");
    header.style.height = "13%";
    var text = document.getElementsByClassName("tab");
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

function ChangePage1() {
    var post_info = document.getElementById("post-info");
    var detal_info = document.getElementById("detal-info");
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var framePostInfo = document.getElementById("framePostInfo");
    if (post_info.className == "active-info") {
        return;
    } else {
        detal_info.className = "";
        post_info.className = "active-info";
        framePostInfo.style.display = "block";
        frameDetalInfo.style.display = "none";
    }
}

function ChangePage2() {
    var detal_info = document.getElementById("detal-info");
    var post_info = document.getElementById("post-info");
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var framePostInfo = document.getElementById("framePostInfo");
    if (detal_info.className == "active-info") {
        return;
    } else {
        post_info.className = "";
        detal_info.className = "active-info";
        frameDetalInfo.style.display = "block";
        framePostInfo.style.display = "none";
    }
}

function viewAvatar() {
    var viewAvatar = document.getElementById("viewAvatar");
    viewAvatar.style.display = 'block';

}

window.onclick = function (event) {
    var viewAvatar = document.getElementById("viewAvatar");
    if (event.target == viewAvatar) {
        viewAvatar.style.display = "none";
    }
}