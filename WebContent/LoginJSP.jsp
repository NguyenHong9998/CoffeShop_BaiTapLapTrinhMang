<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<style type="text/css">
body#LoginForm {
	background-image: url("assets/img/blur-26347-27038-hd-wallpapers.jpg");
	background-repeat: no-repeat;
	background-position: center;
	background-size: cover;
	padding: 10px;
	background-repeat: no-repeat;
}

.form-heading {
	color: #fff;
	font-size: 23px;
}

.panel h2 {
	color: #444444;
	font-size: 18px;
	margin: 0 0 8px 0;
}

.panel p {
	color: #777777;
	font-size: 14px;
	margin-bottom: 30px;
	line-height: 24px;
}

.login-form .form-control {
	background: #f7f7f7 none repeat scroll 0 0;
	border: 1px solid #d4d4d4;
	border-radius: 4px;
	font-size: 14px;
	height: 50px;
	width: 70%;
	line-height: 50px;
}

.main-div {
	background: #ffffff none repeat scroll 0 0;
	border-radius: 2px;
	margin: 10px auto 30px;
	max-width: 38%;
	padding: 50px 70px 70px 71px;
}

.login-form .form-group {
	margin-bottom: 10px;
}

.login-form {
	text-align: center;
}

.forgot a {
	color: #777777;
	font-size: 14px;
	text-decoration: underline;
}

.login-form  .btn.btn-primary {
	background: #f0ad4e none repeat scroll 0 0;
	border-color: #f0ad4e;
	color: #ffffff;
	font-size: 14px;
	width: 50%;
	height: 50px;
	line-height: 50px;
	padding: 0;
}

.forgot {
	text-align: left;
	margin-bottom: 30px;
}

.botto-text {
	color: #ffffff;
	font-size: 14px;
	margin: auto;
}

.login-form .btn.btn-primary.reset {
	background: #ff9900 none repeat scroll 0 0;
}

.back {
	text-align: left;
	margin-top: 10px;
}

.back a {
	color: #444444;
	font-size: 13px;
	text-decoration: none;
}
</style>

</head>
<%
	String warn = (String) request.getAttribute("warn");
	if ((String)request.getSession().getAttribute("account") != null) {
		response.sendRedirect("index.jsp");
	}
%>
<body id="LoginForm">
	
	<div class="container">
		<div class="login-form">
			<div class="main-div">
				<div class="panel">
					<h1>Admin Đăng nhập</h1>
					<p>Nhập tài khoản và mật khẩu</p>
				</div>
				<form id="Login" method="POST"
					action="${pageContext.request.contextPath}/Login">

					<div class="form-group">

						<input class="form-control" id="inputEmail" name="user"
							placeholder="Tài khoản">

					</div>

					<div class="form-group">

						<input type="password" class="form-control" id="inputPassword"
							name="pass" placeholder="Mật khẩu">

					</div>

					<button type="submit" class="btn btn-primary">Đăng nhập</button>

				</form>
				<%
					if (warn == null) {
				%>
				<h6 align="center">
					<span><%=""%></span>
				</h6>
				<%
					} else {
				%>
				<h6 align="center">
					<span><%=warn%></span>
				</h6>
				<%
					}
				%>
			</div>
		</div>
	</div>


</body>
</html>