$(document).ready(()=>{
	$('#fLogin').submit((event)=>{
		event.preventDefault();
		
		let username = $('#fUsername').val();
		let password = $('#fPassword').val();
		
		$.ajax({
			type: 'POST',
			url: "rest/users/login",
			data: JSON.stringify({username, password}),
			contentType: 'application/json',
			success: function(u){
				if(u != null){
					alert("Logged in!");
					localStorage.setItem("loggedUser", u.username);
					window.location.href = "./index.html";
				}else{
					alert("Wrong username or password");
					$('#fUsername').val('');
					$('#fPassword').val('');
					return;
				}
			},
			error: function(){
				alert('Something went wrong');
			}
		});
	})
})