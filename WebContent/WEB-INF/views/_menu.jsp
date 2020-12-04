<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<style>
.dropbtn {
	background-color: #1b3f7d;
	color: white;
	padding: 10px;
	font-size: 16px;
	border: none;
	cursor: pointer;
}

.dropdown {
	position: relative;
	display: inline-block;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: #f1f1f1
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: #081f45;
}
</style>
</head>
<body>
	<%
		String name = (String) session.getAttribute("name");
	%>

	<div class="dropdown">
		<button class="dropbtn"
			onclick="window.location.href='${pageContext.request.contextPath}/'">Home</button>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Xem</button>
		<div class="dropdown-content">
			<a href="${pageContext.request.contextPath}/BillList">Hóa Đơn</a> <a
				href="${pageContext.request.contextPath}/CustomerList">Khách
				Hàng</a> <a href="${pageContext.request.contextPath}/PriceTimeList">Tiền
				Giờ</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Tìm Kiếm</button>
		<div class="dropdown-content">
			<a href="${pageContext.request.contextPath}/BillFind">Hóa Đơn</a> <a
				href="${pageContext.request.contextPath}/CustomerFind">Khách
				Hàng</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn">Thêm</button>
		<div class="dropdown-content">
			<a href="${pageContext.request.contextPath}/BillInsert">Hóa Đơn</a> <a
				href="${pageContext.request.contextPath}/CustomerInsert">Khách
				Hàng</a>
		</div>
	</div>
	<div class="dropdown">
		<button class="dropbtn"
			onclick="window.location.href='${pageContext.request.contextPath}/PrintBill'">In
			Hóa Đơn</button>
	</div>
	<div class="dropdown">
		<button class="dropbtn"
			onclick="window.location.href='${pageContext.request.contextPath}/Login'">Log
			Out</button>
	</div>
</body>
</head>
<div class="absolute-center">
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<h1>
						<span>B</span><span>o</span><span>o</span><span>t</span><span>s</span><span>t</span><span>r</span><span>a</span><span>p</span>
						<span>4</span><br> <span>m</span><span>e</span><span>n</span><span>u</span>
					</h1>
					<p>scroll for nav animation</p>
				</div>
			</div>
		</div>
	</div>
	<div class="section mt-5">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div id="switch">
						<div id="circle"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</html>
 --%>