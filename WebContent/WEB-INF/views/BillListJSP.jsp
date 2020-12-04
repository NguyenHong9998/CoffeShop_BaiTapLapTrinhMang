<%@page import="entities.Customer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entities.Bill"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hóa đơn</title>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">
<link rel='stylesheet' href="css/itemview.css">

<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src="js/index.js"></script>
<link rel="stylesheet" href="css/search/css/all.css">


<style>

/* vietnamese */
@font-face {
	font-family: 'Maven Pro';
	font-style: normal;
	font-weight: 400;
	font-display: swap;
	unicode-range: U+0102-0103, U+0110-0111, U+0128-0129, U+0168-0169,
		U+01A0-01A1, U+01AF-01B0, U+1EA0-1EF9, U+20AB;
}
/* latin-ext */
@font-face {
	font-family: 'Maven Pro';
	font-style: normal;
	font-weight: 400;
	font-display: swap;
	unicode-range: U+0100-024F, U+0259, U+1E00-1EFF, U+2020, U+20A0-20AB,
		U+20AD-20CF, U+2113, U+2C60-2C7F, U+A720-A7FF;
}
/* latin */
@font-face {
	font-family: 'Maven Pro';
	font-style: normal;
	font-weight: 400;
	font-display: swap;
	unicode-range: U+0000-00FF, U+0131, U+0152-0153, U+02BB-02BC, U+02C6,
		U+02DA, U+02DC, U+2000-206F, U+2074, U+20AC, U+2122, U+2191, U+2193,
		U+2212, U+2215, U+FEFF, U+FFFD;
}

body {
	font-family: 'Maven Pro', sans-serif
}

body {
	background-color: #eee
}

.add {
	border-radius: 20px
}

.card {
	border: none;
	border-radius: 10px;
	transition: all 1s;
	cursor: pointer
}

.card:hover {
	-webkit-box-shadow: 3px 5px 17px -4px #777777;
	box-shadow: 3px 5px 17px -4px #777777
}

.ratings i {
	color: green
}

.apointment button {
	border-radius: 20px;
	background-color: #eee;
	color: #000;
	border-color: #eee;
	font-size: 13px
}

body, html {
	height: 100%;
	width: 100%;
	margin: 0;
	padding: 0;
}

.searchbar {
	margin-bottom: auto;
	margin-top: auto;
	height: 60px;
	background-color: #353b48;
	border-radius: 30px;
	padding: 10px;
}

.search_input {
	color: #fff;
	border: 0;
	outline: 0;
	background: none;
	width: 0;
	caret-color: transparent;
	line-height: 40px;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_input {
	padding: 0 10px;
	width: 450px;
	caret-color: red;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_icon {
	background: white;
	color: #e74c3c;
}

.search_icon {
	height: 40px;
	width: 40px;
	float: right;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	background: white;
	text-decoration: none;
}
</style>

<script type="text/javascript">
	function sendToPage() {
		var input = document.getElementById("search").value;
		window.location.href = "BillFind?Id=".concat(input);
	}
	function runScript(e) {
	    if (e.keyCode == 13) {
	        sendToPage();
	    }
	}
</script>
</head>
<%
	if ((String) request.getSession().getAttribute("account") == null) {
		response.sendRedirect("index.jsp");
	}
	List<Bill> bills = (ArrayList<Bill>) request.getAttribute("bills");
%>
<body>
	<jsp:include page="_header.jsp"></jsp:include>

	<div class="container mt-5 mb-5">
		<div>
			<br> <br>
		</div>
		<div class="d-flex justify-content-between mb-3">
			<span style="font-size: 24px">Hóa đơn</span>
			<div class="d-flex justify-content-center h-100">
				<div class="searchbar">
					<input class="search_input" type="text" name="search" id="search" onkeypress="runScript(event)"
						placeholder="Search...">
					<button onclick="sendToPage();" class="search_icon">
						<i class="fas fa-search"></i>
					</button>
				</div>
			</div>
			<button class="btn btn-success add"
				onclick="window.location.href='BillInsert?Size=<%=bills.size()%>'">Thêm
				hóa đơn</button>
		</div>
		<div class="row g-2" style="margin-top: 30px">
			<%
				for (Bill bill : bills) {
			%>

			<div class="col-md-3">
				<div class="card p-2 py-3 text-center">
					<div class="img mb-2">
						<img src="assets/img/bill.png" width="70" class="rounded-circle">
					</div>
					<h5 class="mb-0">
						<%=bill.getIdBill()%>
					</h5>
					<div class="mt-4 apointment">

						<button class="btn btn-success text-uppercase"
							onclick="window.location.href='BillView?Id=<%=bill.getIdBill()%>'">Chi tiết</button>

					</div>
				</div>
			</div>
			<%
				}
			%>

		</div>
	</div>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>