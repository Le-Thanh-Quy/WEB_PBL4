var StartorEnd;

function SelectStart() {
    StartorEnd = 0;
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
    StartorEnd = 1;
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
    var selectXa = document.getElementById("selectXa");
    if (selectXa.value != "Chọn Xã/Phường") {
        var modal = document.getElementById("myModal");
        modal.style.display = "none";
        if (StartorEnd == 0) {
            var input = document.getElementById("search_Start");
            input.value = selectXa.value;
        } else {
            var input = document.getElementById("search_End");
            input.value = selectXa.value;
        }

    }
}


function CloseComment() {

    var comment = document.getElementById("myModal-comment");
    var commentFrame = document.getElementById("commentFrame");
    comment.style.display = "none";
    commentFrame.src = "";
    document.body.style.overflow = "auto";
}

function OpenComment() {
    var comment = document.getElementById("myModal-comment");
    comment.style.display = "block";
    document.body.style.overflow = "hidden";

}

function CloseReport() {
    var report = document.getElementById("myModal-report");
    var reportFrame = document.getElementById("reportFrame");
    report.style.display = "none";
    reportFrame.src = "";
    document.body.style.overflow = "auto";
}

function OpenReport() {
    var report = document.getElementById("myModal-report");
    report.style.display = "block";
    document.body.style.overflow = "hidden";
}

window.onclick = function (event) {
    var modal = document.getElementById("myModal");
    var modal1 = document.getElementById("myModal-login");
    var modal2 = document.getElementById("myModal-signup");
    var modalpost = document.getElementById("myModal-newPost");
    var comment = document.getElementById("myModal-comment");
    var report = document.getElementById("myModal-report");
    var viewAvatar = document.getElementById("viewAvatar");
    var myModal_request = document.getElementById("myModal-request");

    var selectTinh;
    if (StartorEnd == 0) {
        selectTinh = document.getElementById("selectTinhS");
    } else {
        selectTinh = document.getElementById("selectTinhE");
    }

    if (event.target == viewAvatar) {
        viewAvatar.style.display = "none";
    } else if (event.target == modal) {
        modal.style.display = "none";
        selectTinh.selectedIndex = "0";
    } else if (event.target == modal1) {
        modal1.style.display = "none";
    } else if (event.target == modal2) {
        modal2.style.display = "none";
    } else if (event.target == modalpost) {
        modalpost.style.display = "none";
    } else if (event.target == comment) {
        var commentFrame = document.getElementById("commentFrame");
        comment.style.display = "none";
        commentFrame.src = "";
        document.body.style.overflow = "auto";
    } else if (event.target == report) {
        var reportFrame = document.getElementById("reportFrame");
        report.style.display = "none";
        reportFrame.src = "";
        document.body.style.overflow = "auto";
    }else if(event.target == myModal_request){
        myModal_request.style.display = "none";
    }
}
function OpenRequest(senderID , receiverID , postID) {
    var SenderID = document.getElementById("senderID");
    var ReceiverID = document.getElementById("receiverID");
    var PostID= document.getElementById("postID");
    SenderID.value = senderID;
    ReceiverID.value = receiverID;
    PostID.value = postID;
    var myModal_request = document.getElementById("myModal-request");
    myModal_request.style.display = "block";
}
function CloseRequest() {
    var myModal_request = document.getElementById("myModal-request");
    myModal_request.style.display = "none";
}




