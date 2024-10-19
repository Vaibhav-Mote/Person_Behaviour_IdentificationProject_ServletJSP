function isUniqueUsername(str) {
    var username = document.getElementById("username").value;
    var name = document.getElementById("name").value;
    var email = document.getElementById("email").value;
    let xhttp = new XMLHttpRequest();
     
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            document.getElementById("message").innerHTML = this.responseText;
        }
        
    };
    xhttp.open("GET", "editProfile?username=" +username+ "&name=" +name+ "&email="+email +"&registerid="+str, true);
    xhttp.send();
    
    
    return false;
}


