let ID = -1;


window.onload = function LoadFormAccount() {
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var framePostInfo = document.getElementById("framePostInfo");
    var frameEspeciallyInfo = document.getElementById("frameEspeciallyInfo");
    framePostInfo.style.display = "block";
    frameDetalInfo.style.display = "none";
    frameEspeciallyInfo.style.display = "none";
    var header = document.getElementById("menu");
    header.style.height = "13%";
    var text = document.getElementsByClassName("tab");
    for (let index = 0; index < text.length; index++) {
        text[index].style.fontSize = "18px";
    }
    check = true;

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
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var frameEspeciallyInfo = document.getElementById("frameEspeciallyInfo");
    if ((window.scrollY + window.innerHeight) >= document.body.scrollHeight - 1 &&
        frameDetalInfo.style.display == "none" && check && ID != -1 &&
        frameEspeciallyInfo.style.display == "none") {
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
        xhttp.open("GET", "getPosts?id=" + ID + "&userID=" + UserID);
        xhttp.send();


    }
}

var check = true;

function LoadPost(myObj) {
    for (const x of myObj) {
        ID = x.ID;
        var str = "";
        str +=
            '<div class="post">';
        if (myID == x.user.ID) {
            str += ' <span class="delete" onClick="DeletePost(' + x.ID + ')">&times;</span>';
        }
        str +=
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
            '<div class="post-button">';


        if (myID != x.user.ID) {
            str += ' <a href="chat?myID=' + myID + '&theirID=' + x.user.ID + '"><i class="far fa-comment"></i> Liên Hệ </a>';
            str += '<a href="comment?postID=' + x.ID + '&myID=' + myID + '" onclick="OpenComment()" target="commentFrame"><i class="far fa-comment-alt"></i> Bình Luận </a>';
            str += '<a href="report?myID=' + myID + '&theirID=' + x.user.ID + '" onclick="OpenReport()" target="reportFrame" ><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>';
        } else {
            str += ' <a><i class="far fa-comment"></i> Liên Hệ </a>';
            str += '<a href="comment?postID=' + x.ID + '&myID=' + myID + '" onclick="OpenComment()" target="commentFrame"><i class="far fa-comment-alt"></i> Bình Luận </a>';
            str += '<a><i class="fas fa-exclamation-triangle"></i> Báo Cáo</a>';
        }

        str +=
            '</div>' +
            '</div>' +
            '</div>';
        document.getElementById("list-post").innerHTML += str;
    }

    check = true;
    var loadPost = document.getElementById("loadPost");
    loadPost.style.display = "none";
}


function MenuOn() {
    var menu = document.getElementById("menu_logout");
    menu.style.display = "block";

}

function MenuOff() {
    var menu = document.getElementById("menu_logout");
    menu.style.display = "none";
}

function ChangePage(checkPage) {

    var post_info = document.getElementById("post-info");
    var detal_info = document.getElementById("detal-info");
    var especially_info = document.getElementById("especially-info");
    var frameDetalInfo = document.getElementById("frameDetalInfo");
    var framePostInfo = document.getElementById("framePostInfo");
    var frameEspeciallyInfo = document.getElementById("frameEspeciallyInfo");
    if (checkPage == 1) {
        if (post_info.className == "active-info") {
            return;
        } else {
            detal_info.className = "";
            post_info.className = "active-info";
            especially_info.className = "";
            framePostInfo.style.display = "block";
            frameDetalInfo.style.display = "none";
            frameEspeciallyInfo.style.display = "none";
        }
    } else if (checkPage == 2) {
        if (detal_info.className == "active-info") {
            return;
        } else {
            detal_info.className = "active-info";
            post_info.className = "";
            especially_info.className = "";
            framePostInfo.style.display = "none";
            frameDetalInfo.style.display = "block";
            frameEspeciallyInfo.style.display = "none";
        }
    } else {
        if (especially_info.className == "active-info") {
            return;
        } else {
            detal_info.className = "";
            post_info.className = "";
            especially_info.className = "active-info";
            framePostInfo.style.display = "none";
            frameDetalInfo.style.display = "none";
            frameEspeciallyInfo.style.display = "block";
        }
    }

}


function viewAvatar() {
    var viewAvatar = document.getElementById("viewAvatar");
    viewAvatar.style.display = 'block';

}


let chooseStar = 0;

function ChooseStar(check) {
    var choose1 = document.getElementById("choose1");
    var choose2 = document.getElementById("choose2");
    var choose3 = document.getElementById("choose3");
    var choose4 = document.getElementById("choose4");
    var choose5 = document.getElementById("choose5");
    if (check == 1) {
        choose1.className = "fas fa-star choose";
        choose2.className = "far fa-star choose";
        choose3.className = "far fa-star choose";
        choose4.className = "far fa-star choose";
        choose5.className = "far fa-star choose";
    } else if (check == 2) {
        choose1.className = "fas fa-star choose";
        choose2.className = "fas fa-star choose";
        choose3.className = "far fa-star choose";
        choose4.className = "far fa-star choose";
        choose5.className = "far fa-star choose";
    } else if (check == 3) {
        choose1.className = "fas fa-star choose";
        choose2.className = "fas fa-star choose";
        choose3.className = "fas fa-star choose";
        choose4.className = "far fa-star choose";
        choose5.className = "far fa-star choose";
    } else if (check == 4) {
        choose1.className = "fas fa-star choose";
        choose2.className = "fas fa-star choose";
        choose3.className = "fas fa-star choose";
        choose4.className = "fas fa-star choose";
        choose5.className = "far fa-star choose";
    } else if (check == 5) {
        choose1.className = "fas fa-star choose";
        choose2.className = "fas fa-star choose";
        choose3.className = "fas fa-star choose";
        choose4.className = "fas fa-star choose";
        choose5.className = "fas fa-star choose";
    }
    chooseStar = check;
}


function SubmitAssess(myID, theirID) {
    if (chooseStar != 0) {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            if (this.responseText == "true") {
                location.reload();
            }
        }
        xhttp.open("POST", "account?rank=" + chooseStar + "&myID=" + myID + "&theirID=" + theirID);
        xhttp.send();
    }
}

function DeletePost(postID) {
    var answer = window.confirm("Bạn chắc chắn muốn xóa bài viết này?");
    if (answer) {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            if (this.responseText == "true") {
                location.reload();
            } else {
                alert("Xóa không thành công!");
            }
        }
        xhttp.open("POST", "account?postID=" + postID);
        xhttp.send();
    }

}

function Hide_Show_PassOld() {
    var x = document.getElementById("pass_old");
    var icon = document.getElementById("hide_show_passOld");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}

function Hide_Show_PassNew() {
    var x = document.getElementById("pass_new");
    var icon = document.getElementById("hide_show_passNew");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}

function Hide_Show_PassConfirm() {
    var x = document.getElementById("pass_confirm");
    var icon = document.getElementById("hide_show_confPass");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}

function ChangePassSubmit() {

    var pass_old = document.getElementById("pass_old");
    var pass_new = document.getElementById("pass_new");
    var pass_confirm = document.getElementById("pass_confirm");
    var notification = document.getElementById("notification");
    var notificationForm = document.getElementById("notificationForm");

    if (pass_old.value.trim() == "") {
        notification.innerHTML = "Không được để trống mật khẩu cũ";
        notificationForm.style.display = "block";
        setTimeout(function () {
            notificationForm.style.display = "none";
        }, 3000);
    } else if (pass_new.value.trim() == "") {
        notification.innerHTML = "Không được để trống mật khẩu mới";
        notificationForm.style.display = "block";
        setTimeout(function () {
            notificationForm.style.display = "none";
        }, 3000);
    } else if (pass_confirm.value.trim() != pass_new.value.trim()) {
        notification.innerHTML = "Mật khẩu xác nhận không trùng khớp";
        notificationForm.style.display = "block";
        setTimeout(function () {
            notificationForm.style.display = "none";
        }, 3000);
    }else{
        document.getElementById("updatePass").submit();
    }


}
