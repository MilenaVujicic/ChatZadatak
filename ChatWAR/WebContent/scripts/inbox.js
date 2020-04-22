$(document).ready(()=>{
	$('#tMessages tbody').empty();
	let username = localStorage.getItem("user");
	$.ajax({
		type: 'GET',
		url:'rest/messages/' + username,
		success: function(messages){
			for(let msg of messages){
				let tr = $('<tr></tr>');
				let tdSender = $('<td>' + msg.sender.username + '</td>');
				let tdSubject = $('<td>' + msg.subject + '</td>');
				let tdContent = $('<td>' + msg.content + '</td>');
				let date = msg.dateCreated;
				let formattedDate = new Date(date);
				formattedDate = formattedDate.toUTCString();
				let tdDate = $('<td>' + formattedDate + '</td>');
				
				tr.append(tdSender).append(tdSubject).append(tdContent).append(tdDate);
				$('#tMessages tbody').append(tr);
			}
		},
		error: function(){
			alert('Something went wrong');
		}
	});
});

