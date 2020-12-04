<%@page import="entities.PriceTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="entities.PriceTime"%>
<%@ page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mặt hàng</title>
<link rel="stylesheet" href="css/style.css">
<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src="js/index.js"></script>
<link rel='stylesheet' href="css/itemview.css">
<link rel='stylesheet' href="css/all.css">

<script src="js/bootstrap.bundle.min.js"></script>

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
html{
 height: 100%;
}
body {
	font-family: 'Maven Pro', sans-serif;
	background-color: #eee;
	min-height: 100%;
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
</style>

</head>
<body>
	<%
		if ((String) request.getSession().getAttribute("account") == null) {
			response.sendRedirect("index.jsp");
		}
	%>
	<%
		List<PriceTime> priceTimes = (ArrayList<PriceTime>) request.getAttribute("priceTimes");
	%>
	<jsp:include page="_header.jsp"></jsp:include>
	<div class="container mt-5 mb-5">
		<div>
			<br> <br>
		</div>
		<div class="d-flex justify-content-between mb-3">
			<span style="font-size: 24px">Sản phẩm</span>
			<button class="btn btn-success add"
				onclick="window.location.href='PriceTimeAdd?Size=<%=priceTimes.size()%>'">Thêm
				sản phẩm</button>
		</div>
		<div class="row g-2">
			<%
				for (PriceTime priceTime : priceTimes) {
			%>

			<div class="col-md-3">
				<div class="card p-2 py-3 text-center">
					<div class="img mb-2">
						<img src="assets/img/food.jpg" width="70" class="rounded-circle">
					</div>
					<h5 class="mb-0">
						<%=priceTime.getDesPriceTime()%>
					</h5>
					<small> <%=String.valueOf(priceTime.getMoneyPriceTime()) + " VNĐ"%>
					</small>

					<div class="mt-4 apointment">
						<button class="btn btn-success text-uppercase"
							onclick="window.location.href='PriceTimeEdit?IdPriceTime=<%=priceTime.getIdPriceTime()%>&Name=<%=priceTime.getDesPriceTime()%>&Price=<%=String.valueOf(priceTime.getMoneyPriceTime())%>'">Edit</button>
					
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