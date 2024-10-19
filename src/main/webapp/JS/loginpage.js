function login() {
    var username = document.getElementById("name").value;
    var password = document.getElementById("password").value;
    var btn = document.getElementById("submitbtn");

   
    if (username.trim() =='') {
        btn.disabled = true;
        alert("username not null");
        return false;
    }

    if (password.trim() =='') {
        btn.disabled = true;
        alert("fill the password");
        return false;
    } else {
        btn.disabled = false;
        return true;    
    }
}
