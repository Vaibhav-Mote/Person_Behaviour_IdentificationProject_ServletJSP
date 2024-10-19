/*
document.addEventListener('DOMContentLoaded', function () {
			const emailInput = document.getElementById('email');
			const emailMessage = document.getElementById('emailMessage');
			const submitbtn=document.getElementById("submitbtn");
		    
			emailInput.addEventListener('input', function () {
				if (!emailInput.value.includes('@')&&( emailInput.value.trim() !==''))  {
				   emailMessage.textContent = "Invalid email must be contain @";
					emailMessage.style.display = 'inline'; 
					submitbtn.disabled=true;
					 submitbtn.onmouseover=show();
				    
				}else if(!emailInput.value.includes('.com')&&( emailInput.value.trim() !=='')){
					emailMessage.textContent = "Email must be contain .com";
					emailMessage.style.display = 'inline';	
				}      
				else {
					emailMessage.style.display = 'none';
					submitbtn.disabled=false;
				    
				}
			});
		});
    
  
   */

function register() {
	var user = document.getElementById("name").value;
	var email = document.getElementById("email").value;
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	var btn = document.getElementById("submitbtn");


	if (!validname(user)) {
		alert("Please Enter Alphabates only");
		return false;
	}
	else if (!validemail(email)) {
		alert("invalid email");
		return false;
	} 
	else if(username==""){
		alert("username is null");
		return false;
	}
	else if(password=="") {
		alert("Password is null")
		return false;
	}else{
		return true;
	}

}
function validname(name) {
	let pattern = /^[a-zA-Z]+$/;
	return pattern.test(name);
}
function validemail(email) {
	let pattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	return pattern.test(email);
}

