function UserBlur() {
    var user_txt = document.getElementById("user_txt");
    if (user_txt.value == "") {
        user_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    } else {
        user_txt.style.borderBottom = "5px solid rebeccapurple";
    }
}
function SingUpUserBlur() {
    var user_txt = document.getElementById("user_txt_singup");
    if (user_txt.value == "") {
        user_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    } else {
        user_txt.style.borderBottom = "5px solid rebeccapurple";
    }
}
function PassBlur() {
    var pass_txt = document.getElementById("pass_txt");
    if (pass_txt.value == "") {
        pass_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    } else {
        pass_txt.style.borderBottom = "5px solid rebeccapurple";
    }
}
function SingUpPassBlur() {
    var pass_txt = document.getElementById("pass_txt_signup");
    if (pass_txt.value == "") {
        pass_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    } else {
        pass_txt.style.borderBottom = "5px solid rebeccapurple";
    }
}
function ConfirmPassBlur() {
    var pass_txt = document.getElementById("pass_confirm_txt");
    if (pass_txt.value == "") {
        pass_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    } else {
        pass_txt.style.borderBottom = "5px solid rebeccapurple";
    }
}

var firtT = true;
function Close() {
    var modal1 = document.getElementById("myModal-login");
    var modal2 = document.getElementById("myModal-signup");
    modal1.style.display = "none";
    modal2.style.display = "none";
}
function Signup() {

    var myModal_login = document.getElementById("myModal-login");
    var myModal_signup = document.getElementById("myModal-signup");
    if (firtT) {
        myModal_signup.style.display = "none";
        firtT = false;
    }
    if (myModal_signup.style.display == "none") {
        myModal_login.style.display = "none";
        myModal_signup.style.display = "block";
    } else {
        myModal_login.style.display = "block";
        myModal_signup.style.display = "none";
    }
}

function HideShow() {
    var x = document.getElementById("pass_txt");
    var icon = document.getElementById("hide_show");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}

function HideShowSignUp() {
    var x = document.getElementById("pass_txt_signup");
    var icon = document.getElementById("hide_show_signup");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}

function HideShowR() {
    var x = document.getElementById("pass_confirm_txt");
    var icon = document.getElementById("hide_showr");
    if (x.type === "password") {
        x.type = "text";
        icon.className = "fas fa-eye-slash";
    } else {
        x.type = "password";
        icon.className = "fas fa-eye";
    }
}
let checkPage;
let messPage;
function OpenLogin(check , mess) {

    checkPage = check;
    messPage = mess;


    var user_txt = document.getElementById("user_txt");
    var pass_txt = document.getElementById("pass_txt");
    var user_txt_singup = document.getElementById("user_txt_singup");
    var pass_txt_signup = document.getElementById("pass_txt_signup");
    var pass_confirm_txt = document.getElementById("pass_confirm_txt");
    var myModal_login = document.getElementById("myModal-login");
    myModal_login.style.display = "block";
    pass_txt.value = "";
    user_txt_singup.value = "";
    pass_txt_signup.value = "";
    pass_confirm_txt.value = "";
    user_txt.value = "";
    pass_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    user_txt_singup.style.borderBottom = "5px solid rgb(214, 214, 214)";
    pass_txt_signup.style.borderBottom = "5px solid rgb(214, 214, 214)";
    pass_confirm_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
    user_txt.style.borderBottom = "5px solid rgb(214, 214, 214)";
}


function checkLogin(check) {
    var user_txt = document.getElementById("user_txt");
    var pass_txt = document.getElementById("pass_txt");
    var notification = document.getElementById("notification");
    var notificationForm = document.getElementById("notificationForm");
    if (user_txt.value.toString().trim() == "") {
        notification.innerHTML = "Không được để trống tài khoản!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    }else if (pass_txt.value.toString().trim() == ""){
        notification.innerHTML = "Không được để trống mật khẩu!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    }
    else {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            if(this.responseText == -1){
                notification.innerHTML = "Tài khoản hoặc mật khẩu của bạn không chính xác!";
                notificationForm.style.display = "block";
                setTimeout(function(){ notificationForm.style.display = "none"; }, 2000);
            }else{
                if(checkPage == "newPost"){
                    document.getElementById("checkTypeLogin").value = "newPost";
                }
                if(checkPage == "chat"){
                    if(messPage != null){
                        document.getElementById("checkMessLogin").value = messPage;
                    }
                    document.getElementById("checkTypeLogin").value = "chat";
                }
                if(checkPage == "comment"){
                    if(messPage != null){
                        document.getElementById("checkMessLogin").value = messPage;
                    }
                    document.getElementById("checkTypeLogin").value = "comment";
                }
                document.formLogin.submit();
            }
        }
        xhttp.open("GET", "checkLogin?username=" + user_txt.value + "&password=" + pass_txt.value);
        xhttp.send();
    }
}

function checkSignUp() {
    var user_txt_singup = document.getElementById("user_txt_singup");
    var pass_txt_signup = document.getElementById("pass_txt_signup");
    var pass_confirm_txt = document.getElementById("pass_confirm_txt");

    var notification = document.getElementById("notification");

    var notificationForm = document.getElementById("notificationForm");
    if (user_txt_singup.value.toString().trim() == "") {
        notification.innerHTML = "Không được để trống tài khoản!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    }else if (pass_txt_signup.value.toString().trim() == ""){
        notification.innerHTML = "Không được để trống mật khẩu!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    } else if(pass_confirm_txt.value.toString().trim() == ""){
        notification.innerHTML = "Không được để trống mật khẩu xác nhận!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    }else if(pass_confirm_txt.value.toString().trim() != pass_txt_signup.value.toString().trim()){
        notification.innerHTML = "Mật khẩu xác nhận không trùng khớp!";
        notificationForm.style.display = "block";
        setTimeout(function(){notificationForm.style.display = "none"; }, 2000);
    }
    else {
        const xhttp = new XMLHttpRequest();
        xhttp.onload = function () {
            if(this.responseText == -1){
                document.formSignUp.submit();
            }else{
                notification.innerHTML = "Tài khoản đã tồn tại!";
                notificationForm.style.display = "block";
                setTimeout(function(){ notificationForm.style.display = "none"; }, 2000);

            }
        }
        xhttp.open("GET", "checkLogin?username=" + user_txt_singup.value + "&password=");
        xhttp.send();
    }
}





