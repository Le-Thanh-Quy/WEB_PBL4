function findPost(){
    const xhttp = new XMLHttpRequest();
    xhttp.onload = function () {
        const myObj = JSON.parse(this.responseText);
        var html='';
        for (const x of myObj) {
            html += '<p>ID: '+x.ID+'</p>';
            html += '<p>UserID: '+x.UserID+'</p>';
            html += '<p>Cap: '+x.Caption+'</p>';
            html += '<p>IMG: '+x.Image+'</p>';
            html += '<a href="DeletePost?IDPost='+x.ID+'">Delete</a><br><br>';
        }
        document.getElementById("data").innerHTML = html;
    }
    var key = document.getElementById("searchBox");
    xhttp.open("GET", "FindPost?searchBox=" + key.value);
    xhttp.send();
}