$(document).ready(()=>{
	$('#fRegister').submit((event)=>{
		event.preventDefault();
		
		let username = $('#fUsername').val();
		let password = $('#fPassword').val();
		
		if(username === '' || password === ''){
			alert("Fields must not be empty!");
			return;
		}
		
		$.ajax({
			type: 'POST', 
			url:'rest/users/register',
			data: JSON.stringify({username, password}),
			contentType: 'application/json',
			success: function(msg){
				if(msg === 'success'){
					alert("Account has been registered");
					window.location = './index.html';
				}else{
					alert("Username already exists");
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