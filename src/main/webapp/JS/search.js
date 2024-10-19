function isSearchUser(str){
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
	if(this.readyState==4 && this.status==200){
		document.getElementById("pointedDiv").innerHTML=this.responseText;
	}
	};
	xhttp.open("Get","search?n="+str,true);
	xhttp.send();
	
}

function isSearchUseradmin(str){
	let xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
	if(this.readyState==4 && this.status==200){
		document.getElementById("pointedDiv").innerHTML=this.responseText;
	}
	};
	xhttp.open("Get","adminSearchUserController?n="+str,true);
	xhttp.send();
	
}

function follow(registerid, userid) {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let followbtn = document.getElementById("follow");
            followbtn.innerHTML = "following";
        }
    };

    xhttp.open("GET", "followController?registerid=" + registerid + "&&userid=" + userid, true);
    xhttp.send();
}


