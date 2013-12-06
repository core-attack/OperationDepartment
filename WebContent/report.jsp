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
	<input id="login" name="login" type="text" placeholder="Login" value="${login}"/><br/>
	<form action="logout" method="POST" id="logout">
		<span class="label label-info"><div name='login' id="nikname">Вы вошли как ${login}</div></span>
		<input type="submit" class="btn btn-link" value="Выйти" id="logout">
	</form>
	<div id="message" name="message">${message}</div>
	<form method="post" action="toMain" id="back">
		<div class="control-group">
			<input value="Заполнить новый документ" type="submit" class="btn btn-large btn-primary"/><br/>
		</div>
	</form>
</body>
</html>