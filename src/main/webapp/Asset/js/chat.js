let myID = -1;

function SearchRoomChat() {
    if (myID != -1) {
        var txtSearch = document.getElementById("searchRoomChat");
        var recent_messages = document.getElementById("recent_messages");
        const xhttp = new XMLHttpRequest();

        xhttp.onload = function () {
            recent_messages.innerHTML = '<a href="">\n' +
                '                <div class="messages">\n' +
                '                    <img src="./Asset/img/logo/logo_user.png" alt="">\n' +
                '                    <div class="content">\n' +
                '                        <pre> Admin QTH</pre>\n' +
                '                        <p></p>\n' +
                '                    </div>\n' +
                '                </div>\n' +
                '            </a>';
            const myObj = JSON.parse(this.responseText);
            for (const x of myObj) {
                recent_messages.innerHTML +=
                    '<a href="chatDetail?RoomID=' + x.ID + '&myID=' + x.myUser.ID + '" target="chat_detail">\n' +
                    '                    <div class="messages">\n' +
                    '                        <img src="' + x.theirUser.Avatar + '" alt="">\n' +
                    '                        <div class="content">\n' +
                    '                            <pre>' + x.theirUser.Name + '</pre>\n' +
                    '                            <p></p>\n' +
                    '                        </div>\n' +
                    '                    </div>\n' +
                    '                </a>';
            }

        }
        xhttp.open("POST", "chat?myID=" + myID + "&searchContent=" + txtSearch.value);
        xhttp.send();
    }

}

function ReloadChatRoom(myID) {
    var reloadRoom = document.getElementById("reloadRoom");
    reloadRoom.style.WebkitAnimation = "mymove 1s 2";
    reloadRoom.style.animation = "mymove 1s 2";
    var recent_messages = document.getElementById("recent_messages");
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        recent_messages.innerHTML = '<a href="">\n' +
            '                <div class="messages">\n' +
            '                    <img src="./Asset/img/logo/logo_user.png" alt="">\n' +
            '                    <div class="content">\n' +
            '                        <pre> Admin QTH</pre>\n' +
            '                        <p></p>\n' +
            '                    </div>\n' +
            '                </div>\n' +
            '            </a>';
        const myObj = JSON.parse(this.responseText);
        console.log(myObj);
        for (const x of myObj) {
            var display = '';
            if (x.MyStatus == false) {
                display = 'style="display: block!important;"';
            }
            recent_messages.innerHTML +=
                '<a href="chatDetail?RoomID=' + x.ID + '&myID=' + x.myUser.ID + '" target="chat_detail">\n' +
                '                    <div class="messages">\n' +
                '                        <img src="' + x.theirUser.Avatar + '" alt="">\n' +
                '                        <div class="content">\n' +
                '                            <pre>' + x.theirUser.Name + '</pre>\n' +
                '                            <p><i class="fas fa-sms" \n' +
                display +
                '                                 ></i></p>\n' +
                '                        </div>\n' +
                '                    </div>\n' +
                '                </a>';
        }
        setTimeout(function () {
            reloadRoom.style.WebkitAnimation = "none";
            reloadRoom.style.animation = "none";
        } , 2000);

    }
    xhttp.open("POST", "chat?myID=" + myID);
    xhttp.send();
}