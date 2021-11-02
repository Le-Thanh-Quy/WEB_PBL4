function btnAddH() {
    var icon = document.getElementById("icon");
    icon.style.backgroundImage = "url('./img/icon/addT.png')";
}
function btnAddL() {
    var icon = document.getElementById("icon");
    if (document.body.scrollTop > 50 || document.documentElement.scrollTop > 50) {
        icon.style.backgroundImage = "url('./img/icon/addD.png')";
    } else {
        icon.style.backgroundImage = "url('./img/icon/addT.png')";
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
        logo.src = 'img/black-logo.png';
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
            icon.style.backgroundImage = "url('./img/icon/addD.png')";
        active.style.color = "#8d99af!important";
    } else {
        header.style.backgroundColor = "transparent";
        header.style.height = "13%";
        logo.src = 'img/white-logo.png';
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
            icon.style.backgroundImage = "url('./img/icon/addT.png')";
        active.style.color = "#8d99af!important";
    }
    if ((window.scrollY + window.innerHeight) >= document.body.scrollHeight - 1) {
        var loadPost = document.getElementById("loadPost");
        if (check) {
            loadPost.style.display = "block";
            check = false;
            setTimeout(LoadPost, 4000);
        }

    }
}
var check = true;
function LoadPost() {
    document.getElementById("list-post").innerHTML += '<div class="post">' +
        '<img class="post-img" src="./img/test/listing-02.jpg" alt="">' +

        '<div class="post-main">' +
        '<h1>Trần Nguyễn Anh Trình</h1>' +
        '<h5>12:20</h5>' +

        '<ul class="rate">' +
        '<li><i class="fas fa-star"></i></li>' +
        '<li><i class="fas fa-star"></i></li>' +
        '<li><i class="far fa-star"></i></li>' +
        '<li><i class="far fa-star"></i></li>' +
        '<li><i class="far fa-star"></i></li>' +
        '<li>(5) Reviews</li>' +
        '</ul>' +

        '<div class="info">' +
        '<div class="start-info">' +
        '<h3>Điểm Xuất Phát</h3>' +
        '<ul class="address">' +
        '<li><i class="fas fa-map-marker-alt"></i> Duy Thu</li>' +
        '<li><i class="fas fa-map-marker-alt"></i> Duy Xuyên</li>' +
        '<li><i class="fas fa-map-marker-alt"></i> Quảng Nam</li>' +
        '</ul>' +
        '  </div>' +
        ' <div class="time-info">' +
        '  <h3>Thời gian: </h3>' +
        '    <p><i class="far fa-clock"></i> 14:00 - 16:00</p>' +
        ' </div>' +
        '<div class="end-info">' +
        '<h3>Điểm Đến</h3>' +
        '<ul class="address">' +
        '<li><i class="fas fa-map-marker"></i> Hòa Khánh Bắc</li>' +
        '<li><i class="fas fa-map-marker"></i> Liên Chiểu</li>' +
        '<li><i class="fas fa-map-marker"></i> Đà Nẵng</li>' +
        '</ul>' +
        '</div>' +


        '</div>' +
        '<div class="status">' +
        '<p><i class="far fa-clipboard"></i> Chuyên lừa đảo</p>' +
        '</div>' +
        '<div class="post-button">' +
        ' <a href=""><i class="far fa-thumbs-up"></i> Thích </a>' +
        '<a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>' +
        '<a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>' +
        '</div>' +
        '</div>' +
        '</div>' +




        '<div class="post">' +
        '<img class="post-img" src="./img/test/listing-05.jpg" alt="">' +

        '<div class="post-main">' +
        '<h1>Lê Thanh Quý</h1>' +
        '<h5>12:25</h5>' +

        '<ul class="rate">' +
        '<li><i class="fas fa-star"></i></li>' +
        '<li><i class="fas fa-star"></i></li>' +
        '<li><i class="fas fa-star"></i></li>' +
        '<li><i class="far fa-star"></i></li>' +
        '<li><i class="far fa-star"></i></li>' +
        '<li>(15) Reviews</li>' +
        '</ul>' +

        '<div class="info">' +
        '<div class="start-info">' +
        '<h3>Điểm Xuất Phát</h3>' +
        '<ul class="address">' +
        '<li><i class="fas fa-map-marker-alt"></i> Hòa Khánh Bắc</li>' +
        '<li><i class="fas fa-map-marker-alt"></i> Liên Chiểu</li>' +
        '<li><i class="fas fa-map-marker-alt"></i> Đà Nẵng</li>' +
        '</ul>' +
        '  </div>' +
        ' <div class="time-info">' +
        '  <h3>Thời gian: </h3>' +
        '    <p><i class="far fa-clock"></i> 17:00 - 19:00</p>' +
        ' </div>' +
        '<div class="end-info">' +
        '<h3>Điểm Đến</h3>' +
        '<ul class="address">' +

        '<li><i class="fas fa-map-marker"></i> Tam Xuân 2</li>' +
        '<li><i class="fas fa-map-marker"></i> Núi Thành</li>' +
        '<li><i class="fas fa-map-marker"></i> Quảng Nam</li>' +
        '</ul>' +
        '</div>' +


        '</div>' +
        '<div class="status">' +
        '<p><i class="far fa-clipboard"></i> Không uy thì ai uy tín nữa</p>' +
        '</div>' +
        '<div class="post-button">' +
        ' <a href=""><i class="far fa-thumbs-up"></i> Thích </a>' +
        '<a href=""><i class="far fa-comment-alt"></i> Bình Luận </a>' +
        '<a href=""><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>' +
        '</div>' +
        '</div>' +
        '</div>';
    check = true;
    var loadPost = document.getElementById("loadPost");
    loadPost.style.display = "none";
}

window.onload = function Load() {
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



var TinhS, HuyenS, XaS, SorE;
function SelectStart() {
    SorE = 0;
    var selectXaClone = document.getElementById("selectXaClone");
    selectXaClone.style.display = "block";
    var modal = document.getElementById("myModal");
    var selectTinh = document.getElementById("selectTinhS");
    var selectHuyen = document.getElementById("selectHuyen");
    selectHuyen.selectedIndex = "0";
    var nameTinh = document.getElementById("nameTinh");
    nameTinh.innerHTML = selectTinh.value;
    if (selectTinh.value != "Điểm khởi hành") {
        var selectXa = document.getElementById("selectXa");
        selectXa.style.display = "none";
        modal.style.display = "block";
        Tinh = selectTinh.value;
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function () {
            modal.style.display = "none";
            selectTinh.selectedIndex = "0";
        }
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
    nameTinh.innerHTML = selectTinh.value;
    if (selectTinh.value != "Điểm đến") {
        var selectXa = document.getElementById("selectXa");
        selectXa.style.display = "none";
        modal.style.display = "block";
        Tinh = selectTinh.value;
        var span = document.getElementsByClassName("close")[0];
        span.onclick = function () {
            modal.style.display = "none";
            selectTinh.selectedIndex = "0";
        }
    }

}

function SelectHuyen() {

    var selectHuyen = document.getElementById("selectXa");
    selectHuyen.selectedIndex = "0";

    var selectHuyen = document.getElementById("selectHuyen");

    if (selectHuyen.value != "Chọn Quận/Huyện") {
        var selectXa = document.getElementById("selectXa");
        selectXa.style.display = "block";
        var selectXaClone = document.getElementById("selectXaClone");
        selectXaClone.style.display = "none";
        Huyen = selectHuyen.value;
    } else {
        var selectXa = document.getElementById("selectXa");
        selectXa.style.display = "none";
        var selectXaClone = document.getElementById("selectXaClone");
        selectXaClone.style.display = "block";
    }

}

function SelectXa() {
    if (selectXa.value != "Chọn Xã/Phường") {
        var modal = document.getElementById("myModal");
        modal.style.display = "none";
        Xa = selectXa.value;
        alert("Tỉnh: " + Tinh + ", Huyện: " + Huyen + ", Xã: " + Xa);
    }

}


window.onclick = function (event) {
    var modal = document.getElementById("myModal");
    var modal1 = document.getElementById("myModal-login");
    var modal2 = document.getElementById("myModal-signup");
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
    }
}




