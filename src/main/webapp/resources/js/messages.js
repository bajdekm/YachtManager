function notAvailable(){
	$('#messages').html('<div class="alert alert-danger alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><strong>Error!</strong> This book was already taken by someone.</div>');
}

function available(id){
	$('#messages').html('<div class="alert alert-success alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><form method="post" action="reservation"><div class="input-group"><input name="clientId" type="text" class="form-control" placeholder="Type reader\'s club id"><span class="input-group-btn"><button class="btn btn-default" type="submit">Send</button></span><input type="hidden" name="bookId"></div></form></div>');
	$('#messages input[name="bookId"]').val(id);
}

function returnedBook() {
	$('#messages').html('<div class="alert alert-info alert-dismissible" role="alert"><button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button><form method="post" action="returning"><div class="input-group"><input name="bookId" type="text" class="form-control" placeholder="Type book\'s id"><span class="input-group-btn"><button class="btn btn-default" type="submit">Send</button></span></div></form></div>');
}