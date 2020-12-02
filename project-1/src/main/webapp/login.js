let button = document.getElementById("login");

button.addEventListener("click", checkLogin);


function checkLogin() {
    
    let data = { username: "username", password: "password"}
    jData = JSON.stringify(data);
    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {
        if(this.readyState == 4 && this.status == 200) {
            xhr.open("POST","/login")
            
            
          }
    }
}