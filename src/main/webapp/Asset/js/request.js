function OnTransaction(userID) {
    var transaction = document.getElementById("transaction");
    transaction.style.display = "block";
    document.getElementById("transactionFrame").src = "request?userID=" + userID;
}
function OffTransaction() {
    var transaction = document.getElementById("transaction");
    transaction.style.display = "none";
    document.getElementById("transactionFrame").src = "";
}

function ChangePage(check) {
    var btnReceive = document.getElementById("btnReceive");
    var receive = document.getElementById("receive");
    var btnSend= document.getElementById("btnSend");
    var send = document.getElementById("send");

    if(check == 1){

        btnReceive.className = "active-info";
        btnSend.className = "";
        receive.style.display = "block";
        send.style.display = "none";
    }else{
        btnSend.className = "active-info";
        btnReceive.className = "";
        send.style.display = "block";
        receive.style.display = "none";
    }
}


function newRequest() {
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        var check = this.responseText;
        var newRequestNotification = document.getElementById("newRequest");
        if(check == "true"){
            newRequestNotification.style.display = "block";
        }else{
            newRequestNotification.style.display = "none";
        }
        setTimeout(newRequest, 5000);
    }
    xhttp.open("POST", "request?newRequest=" + myID);
    xhttp.send();

}