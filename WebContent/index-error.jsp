<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Операционный отдел</title>

<link rel="stylesheet" media="all" type="text/css"	href="css/bootstrap.css" />
<link rel="stylesheet" media="all" type="text/css"	href="css/app.css" />
</head>
<body>
<div class="hero-unit">
  <h1>Операционный отдел</h1>
  <p>Веб-система редактирования платёжных документов</p>
</div>
	<form method="post" action="login" id="sign-in">
		<div class="control-group">
			<div class="form-group has-error">
				<label class="control-label" for="inputError">${error}</label>
				<input type="text" name="login" type="text" placeholder="Login" class="form-control" id="Login" value="${login} ">
			</div>
			<div class="form-group has-error">
				<input name="password" type="password" placeholder="Password" class="form-control" value="${password}"/><br/>
			</div>
			<input value="Enter" type="submit" class="btn btn-large btn-primary"/><br/>
		</div>
	</form>
	
	<form method="post" action="registrate" id="sign-up">
		<div class="control-group">
			<input value="" name="firstname" type="text" placeholder="Firstname*"/><br/>
			<input type="text" name="lastname" placeholder="Lastname*" /><br/>
			<input type="text" name="email" placeholder="E-mail: qwerty@gmail.com" /><br/>
			<input type="text" name="phone" placeholder="Phone: 8 000 000 00 00" /><br/>
			<input value="" name="login" type="text" placeholder="Login*"/><br/>
			<input value=""	name="password" type="password" placeholder="Password*"/><br/>
			<input value="Register" type="submit" class="btn btn-large btn-primary"/><br/>
		</div>
	</form>
</body>
</html>