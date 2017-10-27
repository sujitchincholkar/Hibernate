function formValidate() {
	var email = document.getElementById("email").value;
	var password = document.getElementById("pwd").value;
	var mobile = document.getElementById("no").value;
	var name = document.getElementById("name").value;
	document.getElementById("emailerr").innerHTML = "";
	document.getElementById("pwderr").innerHTML = "";
	document.getElementById("nameerr").innerHTML = "";
	document.getElementById("noerr").innerHTML = "";
	var isValid = true;
	var emailValidation = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
	var mobileValidation = /^((\+)?(\d{2}[-]))?(\d{10})$/;
	var username = /^[a-zA-Z]{3,}?(\d{0,})$/;
	if (!username.test(name)) {
		document.getElementById("nameerr").innerHTML = "Invalid name";
		isValid = false;
	}
	if (!emailValidation.test(email)) {
		document.getElementById("emailerr").innerHTML = "Invalid email";
		isValid = false;
	}
	if (password.length < 8) {
		document.getElementById("pwderr").innerHTML = "Password must contain 8 characters"
		isValid = false;
	}
	if (!mobileValidation.test(mobile)) {
		document.getElementById("noerr").innerHTML = "Invalid Mobile number";
		isValid = false;
	}

	return isValid;
}
$(document).ready(function() {
	
	$("#email").blur(function() {
		$("#emailerr").text("");
		var emailValidation = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
		if (!emailValidation.test($("#email").val())) {
			$("#emailerr").text("Invalid email");
		
		}else{
			$.ajax({
				type :"post",
				url : "EmailValidator",
				data : {
					email:$("#email").val()
				},
				datatype:"json",
				success:function(data){
					console.log(data);
					if(data.exist==true){
						$("#emailerr").text("Email already exist");
						isValid=false;
					}else{
						$("#emailerr").text("");
					}
					return isExist;
				}
			});
		}
		});
	});