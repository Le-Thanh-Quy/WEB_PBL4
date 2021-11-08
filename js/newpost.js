


function newPost() {
    var post = document.getElementById("myModal-newPost");
    post.style.display = "block";
    var span = document.getElementsByClassName("close")[2];
    span.onclick = function () {
        post.style.display = "none";
    }
}

function ClosePost() {
    var post = document.getElementById("myModal-newPost");
    post.style.display = "none";
}

var loadFile = function (event) {
    var output = document.getElementById('out_img-newPost');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src);
    }
};