<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Forgot password</title>
<link rel="stylesheet" media="all" type="text/css"	href="css/bootstrap.css" />
<link rel="stylesheet" media="all" type="text/css"	href="css/app.css" />
<script src="js/bootstrap.js"></script>
<script src="js/app.js"></script>
</head>
<body>
	<div class="alert alert-warning">
		<form method="post" action="createPassword">
			<p class="text-error">${login}, enter please your data, so we can make sure that it's you ;)</p>
			<div class="control-group">
				<input value="" name="firstname" type="text" placeholder="Firstname"/><br/>
				<input type="text" name="lastname" placeholder="Lastname" /><br/>
				<input type="text" id="email" name="email" placeholder="E-mail: qwerty@gmail.com" /><br/>
				<input type="text" id ="pass1" name="password" placeholder="Password" /><br/>
				<div class="controls">
				    <input type="text" id ="pass2" name="confirm_password" placeholder="Confirm password" onkeyup="confirmPassword()"/><br/>
				    <span id="help" class="help-inline"></span>
				  </div>
				<input value="Change password" id="submit" type="submit" class="btn btn-large btn-primary"/><br/>
			</div>
		</form>
	</div>
</body>
</html>