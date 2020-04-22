$(document).ready(()=>{
	document.getElementById('aLogout').addEventListener('click', logout, false);
	let user = localStorage.getItem("loggedUser");
	alert(user.username);
	if(user != null)
		logged = true;
	else
		logged = false;
	
	if(logged){
		$('#notLogged').attr('hidden', true);
		$('#loggedIn').attr('hidden', false);
	}else{
		$('#notLogged').attr('hidden', false);
		$('#loggedIn').attr('hidden', true);
	}
});

function logout(event){
	event.preventDefault();
	let user = localStorage.getItem("loggedUser");
	if(user == null)
		return;
	
	$.ajax({
		type: 'DELETE',
		url: 'rest/users/loggedIn/' + user.username,
		success: function(){
			alert("Logged out!");
			localStorage.setItem("loggedUser", null);
			location.reload();
		},
		error: function(){
			alert('Something went wrong');
		}
	});
	
}