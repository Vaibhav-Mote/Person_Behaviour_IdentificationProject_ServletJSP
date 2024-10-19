function isValidPost() {
	var post=document.getElementById("newpost").value;
	var btn =document.getElementById("btn");
	if(post.trim()==''){
		 btn.disabled = false;
		 alert("enter the post")
		return false;
		
	}
	else{
		btn.disabled=false;
		return true;
	}
    
}

function previewImage() {
    var file = document.getElementById('file').files[0];
    var reader = new FileReader();
    reader.onloadend = function () {
        var img = document.getElementById('postimg');
        img.src = reader.result;
        img.style.width="250px";
        img.style.height="100%";
    }
    if (file) {
        reader.readAsDataURL(file);
    } else {
        document.getElementById('postimg').alt = 'Welcome'; // Default image
    }
    }