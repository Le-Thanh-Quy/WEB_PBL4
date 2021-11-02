
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