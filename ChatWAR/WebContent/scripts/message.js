var selection = 'allReg';

$(document).ready(()=>{
	
	document.getElementById('rSelect').addEventListener('click', changeToSelect, false);
	document.getElementById('rAllReg').addEventListener('click', changeToAll, false);
	document.getElementById('btnSend').addEventListener('click', sendMessage, false);
	$.ajax({
		type: 'GET',
		url: 'rest/users/registered',
		success: function(users){
			for(let u of users){
				let option = $('<option></option>');
				option.append(u.username);
				$('#sUsers').append(option);
			}
		},
		error: function(){
			alert('Something went wrong');
		}
	});
	
	
});

function changeToSelect(){
	$('#sUsers').attr('hidden', false);
	selection = 'select';
}

function changeToAll(){
	$('#sUsers').attr('hidden', true);
	selection = 'allReg';
}

function sendMessage(){

	//let selection = $('input:radio[name=sel]').val();
	let sender = JSON.parse(localStorage.getItem("userObject"));
	let subject = $('#subjectContent').val();
	let content = $('#textContent').val();
	if(selection === 'allReg'){
		
		$.ajax({
			type: 'POST',
			url:'rest/messages/all',
			data: JSON.stringify({subject, content, sender}),
			contentType: 'application/json',
			success: function(){
				alert("Message sent");
				location.reload();
			},
			error: function(){
				alert('Something went wrong');
			}
		});
		
	}else if(selection === 'select'){
		let selUser = $('#sUsers').val();
		$.ajax({
			type: 'POST',
			url: 'rest/messages/' + selUser,
			data: JSON.stringify({subject, content, sender}),
			contentType: 'application/json',
			success: function(){
				alert("Message sent to " + selUser);
				location.reload();
			},
			error: function(){
				alert('Something went wrong');
			}
		})
	}
}