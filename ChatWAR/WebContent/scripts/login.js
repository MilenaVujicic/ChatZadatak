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
			success: function(msg){
				if(msg === 'success'){
					alert("Logged in!");
					window.location = "./index.html";
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