function checkLogin() {
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


