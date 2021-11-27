function OnTransaction() {
    var transaction = document.getElementById("transaction");
    transaction.style.display = "block";
}
function OffTransaction() {
    var transaction = document.getElementById("transaction");
    transaction.style.display = "none";
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