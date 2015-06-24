<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Login</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/css/style.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</head>
<body>
<div class="login-container">
	<c:if test="${error}">
		<div class="alert alert-danger alert-dismissible" role="alert">
			<button type="button" class="close" data-dismiss="alert" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<strong>Error!</strong> Incorrect login or password.
		</div>
	</c:if>
	<div class="col-sm-6 col-md-4 col-md-offset-4" style="background-color: #FFF; padding:20px; border-radius:4px; margin-top:40px;">
	    <h3>Sign in to use this service</h3>
	    <form method=post action="j_security_check">
			<input name="j_username" type="text" class="form-control" placeholder="Login" style="margin-bottom:10px;" required autofocus>
			<input name="j_password" type="password" class="form-control" placeholder="Password" style="margin-bottom:10px;" required>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
	    </form>
	</div>
</div>
</body>
</html>
