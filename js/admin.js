
window.onload = function Load() {
    for (let index = 0; index < 4; index++) {
        var choose = document.getElementById("choose" + index);
        choose.style.display == "none"
    }
    
}
function OpenChoose(check) {
    var choose = document.getElementById("choose" + check);
    var icon = document.getElementById("icon" + check);
    var header = document.getElementById("header" + check);

    if (choose.style.display == "none" || choose.style.display == "") {
        choose.style.display = "block";
        if(check == 0){
            icon.classList = "fas fa-chevron-down";
        }else{
            icon.classList = "fas fa-chevron-down icon";
            header.style.backgroundColor = "#6c757d";
        }
        

    } else {
        choose.style.display = "none";
        
        if(check == 0){
            icon.classList = "fas fa-chevron-left";
        }else{
            icon.classList = "fas fa-chevron-left icon";
            header.style.backgroundColor = "inherit";
        }
    }

}

function HideMenu() {
    
    var menu = document.getElementById("menu");
    var main = document.getElementById("main");
    if(menu.style.display == "none"){
        menu.style.display = "block";
        main.style.width = "87%";
    }else{
        menu.style.display = "none";
        main.style.width = "100%";
    }
}