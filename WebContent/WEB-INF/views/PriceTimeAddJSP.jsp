<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>THEM HOA DON</title>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">
<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src="js/index.js"></script>

<style type="text/css">
body, html {
	margin: 0;
	padding: 0;
	height: 100%;
	background: #60a3bc !important;
}

.user_card {
	height: 400px;
	width: 350px;
	margin-top: auto;
	margin-bottom: auto;
	background: #f39c12;
	position: relative;
	display: flex;
	justify-content: center;
	flex-direction: column;
	padding: 10px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-moz-box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	border-radius: 5px;
}

.brand_logo_container {
	position: absolute;
	height: 170px;
	width: 170px;
	top: -75px;
	border-radius: 50%;
	background: #60a3bc;
	padding: 10px;
	text-align: center;
}

.brand_logo {
	height: 150px;
	width: 150px;
	border-radius: 50%;
	border: 2px solid white;
}

.form_container {
	margin-top: 100px;
}

.login_btn {
	width: 100%;
	background: #c0392b !important;
	color: white !important;
}

.login_btn:focus {
	box-shadow: none !important;
	outline: 0px !important;
}

.login_container {
	padding: 0 2rem;
}

.input-group-text {
	background: #c0392b !important;
	color: white !important;
	border: 0 !important;
	border-radius: 0.25rem 0 0 0.25rem !important;
}

.input_user, .input_pass:focus {
	box-shadow: none !important;
	outline: 0px !important;
}

.custom-checkbox .custom-control-input:checked ~.custom-control-label::before
	{
	background-color: #c0392b !important;
}
</style>
</head>
<%
	String warn = (String) request.getAttribute("warn");
%>
<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<div class="container h-100">
		<div class="d-flex justify-content-center h-100">
			<div class="user_card">
				<div class="d-flex justify-content-center">
					<div class="brand_logo_container">
						<img src="assets/img/food_edit.png" class="brand_logo" alt="Logo">
					</div>
				</div>
				<div class="d-flex justify-content-center form_container">
					<form method="POST"
						action="${pageContext.request.contextPath}/PriceTimeAdd">
						
						<div class="input-group mb-3" style="margin-top: -60px">

							<input type="text" name="tenMatHang" placeholder="Tên mặt hàng">
						</div>
						<div class="input-group mb-2">

							<input type="text" name="donGia" placeholder="Nhập đơn giá">
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
						<div class="d-flex justify-content-center mt-3 login_container">
							<button type="submit" name="button" class="btn login_btn">Thêm mặt hàng</button>
						</div>
					</form>
				</div>


			</div>
		</div>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>