$(document).ready(()=>{
	
	$('#tRegistered tbody').empty();
	$('#tLogged tbody').empty();
	
	$.ajax({
		type: 'GET',
		url: 'rest/users/registered',
		success: function(users){
			for(let u of users){
				let tr = $('<tr></tr>');
				let td = $('<td>' + u.username + '</td>');
				tr.append(td);
				$('#tRegistered tbody').append(tr);
			}
		},
		error: function(){
			alert('Something went wrong');
		}
	});
	
	$.ajax({
		type: 'GET',
		url: 'rest/users/loggedIn',
		success: function(users){
			for(let u of users){
				let tr = $('<tr></tr>');
				let td = $('<td>' + u.username + '</td>');
				tr.append(td);
				$('#tLogged tbody').append(tr);
			}
		},
		error: function(){
			alert('Something went wrong');
		}
	});
});