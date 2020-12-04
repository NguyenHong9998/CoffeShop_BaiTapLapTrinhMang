<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">

<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src="js/index.js"></script>
</head>

<body>
<body class="hero-anime">

	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>
	<div class="section">
		<div class="absolute-top" style="margin-top: 100px">
			<div class="section">
				<h1>
					<span>wellcome</span> <span>to</span><br> <span>Coffee
						shop</span>
				</h1>
			</div>
		</div>

	</div>
	<div>
		<dl class="row" style="margin-left: 30px; margin-top: 50px">
			<dt class="col-sm-3">Đăng nhập</dt>
			<dd class="col-sm-9">
				Admin nhấn Login và đăng nhập theo tài khoản: <label
					style="font-style: oblique; font-size: 20px;"> admin</label>, mật
				khẩu :<label style="font-style: oblique; font-size: 20px;">
					admin</label>
			</dd>


			<dt class="col-sm-3">Sản phẩm</dt>
			<dd class="col-sm-9">
				<label>Sau khi đăng nhập thành công, Admin có thể chọn sản
					phẩm để xem các mặt hàng trong quán</label> <label>Chọn "Thêm sản
					phẩm" để thêm 1 sản phẩm vào DB </label> <label>Trên mỗi sản phẩm,
					Chọn "Edit" để chỉnh sửa thông tin sản phẩm và cập nhật vào DB </label>

			</dd>

			<dt class="col-sm-3">Khách hàng</dt>
			<dd class="col-sm-9">
				<label>Sau khi đăng nhập thành công, Admin có thể chọn khách
					hàng để xem các khách hàng tiềm năng trong quán</label> <label>Chọn
					"Thêm khách hàng" để thêm 1 khách hàng vào DB </label> <label>Trên
					mỗi khách hàng, Chọn "Edit" để chỉnh sửa thông tin khách hàng và
					cập nhật vào DB , Chọn "Xóa" để xóa thông tin khách hàng </label>

			</dd>

			<dt class="col-sm-3 text-truncate">Hóa đơn</dt>
			<dd class="col-sm-9">
				<label>Sau khi đăng nhập thành công, Admin có thể chọn Hóa
					đơn để xem các hóa đơn chưa thanh toán trong quán</label> <label>Chọn
					"Thêm hóa đơn" để thêm 1 hóa đơn vào DB </label> <label>Trên mỗi
					hóa đơn, chọn "Xem chi tiết" để xem chi tiết hóa đơn </label>
			</dd>
		</dl>
	</div>
	<div>
		<br> <br> <br>
	</div>
	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>

</body>

</body>
</html>