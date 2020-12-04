<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm khách hàng</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">

<!-- Website Font style -->
<link rel="stylesheet" href="css/search/css/all.css">


<style type="text/css">
body, html {
	background-repeat: no-repeat;
	font-family: 'Oxygen', sans-serif;
}

.main {
	margin-top: 70px;
}

.form-group {
	margin-bottom: 15px;
}

label {
	margin-bottom: 14px;
}

input, input::-webkit-input-placeholder {
	font-size: 9px;
	padding-top: 3px;
}

.main-login {
	background-color: #fff;
	/* shadows and rounded borders */
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	-webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
	box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}

.main-center {
	margin-top: 30px;
	margin: 0 auto;
	width: 450px;
	padding: 40px 40px;
}

.login-button {
	margin-top: 3px;
}

.login-register {
	font-size: 8px;
	text-align: center;
}
</style>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">
<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src="js/index.js"></script>
</head>
<%
	String warn = (String) request.getAttribute("warn");
%>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	<div class="container mt-5 mb-5">
		<div class="row main">

			<div class="main-login main-center" style="margin-top: 40px">
				<div>
					<h2 style="text-align: center">Khách hàng tiềm năng</h2>
				</div>

				<form class="form-horizontal" method="POST"
					action="${pageContext.request.contextPath}/CustomerInsert"
					style="margin-top: 30px">

					<div class="form-group">
						<label for="name" class="cols-sm-2 control-label">Họ tên</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fa fa-user fa"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									style="margin-left: 5px" name="nameCustomer" id="name"
									placeholder="Nhập tên khách hàng" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="email" class="cols-sm-2 control-label"">Địa
							chỉ</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i class="fas fa-home"
									aria-hidden="true"></i></span> <input type="text" class="form-control"
									name="address" id="address" style="margin-left: 5px"
									placeholder="Địa chỉ khách hàng" />
							</div>
						</div>
					</div>

					<div class="form-group">
						<label for="mobile" class="cols-sm-2 control-label required">Số
							ĐT</label>
						<div class="cols-sm-10">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="fa fa-mobile aria-hidden="true"></i></span> <input type="text"
									class="form-control" name="phone" id="phone"
									style="margin-left: 5px" placeholder="Nhập SĐT khách hàng" />
							</div>
						</div>
					</div>

					<div class="form-group ">
						<button type="submit"
							class="btn btn-primary btn-lg btn-block login-button"
							style="width: 40%; margin-left: 30%">Submit</button>
					</div>
					<div>

						<%
							if (warn != null) {
						%>
						<label><%=warn%></label>
						<%
							}
						%>
					</div>

				</form>
			</div>
		</div>
	</div>

	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>