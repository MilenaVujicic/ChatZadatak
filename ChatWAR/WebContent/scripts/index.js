$(document).ready(()=>{
	document.getElementById('aLogout').addEventListener('click', logout, false);
	let user = null;
	if("user" in localStorage)
		user = localStorage.getItem("user");
	

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
	let user = localStorage.getItem("user");
	if(user == null)
		return;
	
	$.ajax({
		type: 'DELETE',
		url: 'rest/users/loggedIn/' + user,
		success: function(){
			localStorage.removeItem("user");
			location.reload();
		},
		error: function(){
			alert('Something went wrong');
		}
	});
	
}