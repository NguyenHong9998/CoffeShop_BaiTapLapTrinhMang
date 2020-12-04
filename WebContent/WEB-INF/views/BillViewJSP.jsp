<%@page import="java.util.ArrayList"%>
<%@page import="entities.PriceTime"%>
<%@page import="java.util.List"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết hóa đơn</title>
<style type="text/css">
body {
	background-color: #000
}

.padding {
	padding: 2rem !important
}

.card {
	margin-bottom: 30px;
	border: none;
	-webkit-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
	-moz-box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22);
	box-shadow: 0px 1px 2px 1px rgba(154, 154, 204, 0.22)
}

.card-header {
	background-color: #fff;
	border-bottom: 1px solid #e6e6f2
}

h3 {
	font-size: 20px
}

h5 {
	font-size: 15px;
	line-height: 26px;
	color: #3d405c;
	margin: 0px 0px 15px 0px;
	font-family: 'Circular Std Medium'
}

.text-dark {
	color: #3d405c !important
}

.searchbar {
	margin-bottom: auto;
	margin-top: auto;
	height: 50px;
	background-color: #353b48;
	border-radius: 50px;
	padding: 10px;
}

.search_input {
	color: #fff;
	border: 0;
	outline: 0;
	background: none;
	width: 0;
	caret-color: transparent;
	line-height: 30px;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_input {
	padding: 0 8px;
	width: 150px;
	caret-color: red;
	transition: width 0.4s linear;
}

.searchbar:hover>.search_icon {
	background: white;
	color: #e74c3c;
}

.search_icon {
	height: 30px;
	width: 30px;
	float: right;
	display: flex;
	justify-content: center;
	align-items: center;
	border-radius: 50%;
	background: white;
	text-decoration: none;
}
</style>
<link rel='stylesheet' href='css/bootstrap.min.css'>
<link rel="stylesheet" href="css/style.css">
<script src='js/jquery.min.js'></script>
<script src='js/bootstrap.min.js'></script>
<script src='js/socket.io.min.js'></script>
<script src="js/index.js"></script>

<link rel="stylesheet" href="css/search/css/all.css">
<script type="text/javascript">
	function showChangeMoney() {

		var total = Number(document.getElementById('total').textContent);
		var thanhTienString = document.getElementById('thanh-tien').textContent;
		var thanhTien = Number(thanhTienString.substring(0, thanhTienString.indexOf(" ")));
		console.log(thanhTien)
		var changeMoney = thanhTien - total;
		console.log(changeMoney)
		document.getElementById('changeMoney').innerText = changeMoney;

	}

	function check() {
		var checkbox = document.getElementById('exampleCheck1');
		var discount = document.getElementById('discount');
		var total = document.getElementById('total');
		var money = document.getElementById('money');
		var x = Number(money.textContent);

		if (checkbox.checked == true) {
			discount.innerText = "5.0%";
			y = x * 95 / 100;
			total.innerText = y.toString() + ".0 VNĐ";

		} else {
			document.getElementById('discount').innerText = "0.0%";
			total.innerText = x.toString() + ".0 VNĐ";

		}

	}

	function selectBoxChange() {
		console.log('Thuan')
		changePaidMoney();
		/* 		window.location.href = 'BillInsertControl?billId=' + idBill + '&idListItem='+ idListBill;
		 */}

	function changePaidMoney() {
		console.log('change paid')
		var paidMoney = document.getElementById("paidMoney").value;
		var unit = document.getElementById("unitSelectBox").value;

		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log('vao day nay');
				document.getElementById("thanh-tien").innerHTML = this.responseText;
			}
		};
		xhttp.open("GET",
				"http://localhost:8010/BaiTapLapTrinhMang/Money?paidMoney="
						+ paidMoney + '&unit=' + unit, true);
		xhttp.send();
	}
</script>
</head>
<body>
	<%
		String id = (String) request.getAttribute("Id");
		List<PriceTime> list = (ArrayList<PriceTime>) request.getAttribute("list");
		Double money = (Double) request.getAttribute("money");
	%>
	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>
	<div
		class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding"
		style="margin-top: 40px">
		<button class="btn btn-success add"
			onclick="window.location.href='BillDelete?billId=<%=id%>'">Thanh
			toán</button>
		<div class="card" style="margin-top: 10px">
			<div class="card-header p-4">
				<div style="float: left;">
					<h3 class="mb-0">Fanpage</h3>
					<a class="pt-2 d-inline-block"
						href="https://www.facebook.com/i.am.waitting.for.something/"
						data-abc="true">CoffeeShop.com</a>
				</div>
				<div class="float-right" style="float: right;">
					<h3 class="mb-0">
						Mã hóa đơn:
						<%=id%>
					</h3>
					Date:
					<%=LocalDate.now().format(DateTimeFormatter.ofPattern("dd,MMM,yyyy"))%>
				</div>
			</div>
			<div class="card-body">
				<div class="row mb-4">
					<div class="col-sm-6">
						<h3 class="text-dark mb-1">BK CoffeeShop</h3>
						<div>60, Ngô Sĩ Liên</div>
						<div>Hòa Khánh Bắc, Liên Chiểu</div>

					</div>
					<div class="col-sm-6 ">
						<div style="margin-top: 40px">Email: BKCoffeeShop@gmail.com</div>
						<div>Phone: +84 0395077731</div>
					</div>
				</div>
				<div class="table-responsive-sm">
					<table class="table table-striped">
						<thead>
							<tr>
								<th class="center">STT</th>
								<th>MaMatHang</th>
								<th>Mô tả</th>
								<th class="right">Đơn vị tiền</th>
								<th class="right">Giá tiền</th>

							</tr>
						</thead>
						<tbody>
							<%
								for (int i = 0; i < list.size(); i++) {
							%>
							<tr>
								<td class="center"><%=i + 1%></td>
								<td class="left strong"><%=list.get(i).getIdPriceTime()%></td>
								<td class="left"><%=list.get(i).getDesPriceTime()%></td>
								<td class="center">VNĐ</td>
								<td class="right"><%=list.get(i).getMoneyPriceTime()%></td>

							</tr>
							<%
								}
							%>


						</tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-lg-4 col-sm-5"></div>
					<div class="col-lg-4 col-sm-5 ml-auto">
						<table class="table table-clear">
							<tbody>
								<tr>
									<td class="left"><strong class="text-dark">Tổng
											phụ:</strong></td>
									<td class="right" id="money"><%=money%></td>
								</tr>

							</tbody>
						</table>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-7 col-sm-5 ml-auto">
						<table class="table table-clear">
							<tbody>
								<tr>
									<td><input type="checkbox" id="exampleCheck1"
										onchange="check()"> <label>Được giảm giá</label></td>
									<td><strong class="text-dark">Discount:</strong></td>
									<td><label id="discount">0.0%</label></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-4 col-sm-5"></div>
					<div class="col-lg-4 col-sm-5 ml-auto">
						<table class="table table-clear">
							<tbody>
								<tr>
									<td class="left"><strong class="text-dark">Tổng
											tiền:</strong></td>
									<td class="right" id="total"><%=money%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-9 col-sm-5 ml-auto">
						<table class="table table-clear">
							<tbody>
								<tr>
									<td><strong class="text-dark">Khách trả:</strong></td>
									<td><input onchange="changePaidMoney()" type="number"
										required size="10" minlength="4" maxlength="8" id="paidMoney"></td>
									<td>Đơn vị:</td>
									<td><select id="unitSelectBox"
										onchange="selectBoxChange()">
											<option>VND</option>
											<option>USD</option>
											<option>THB</option>
											<option>TWD</option>
											<option>KRW</option>
											<option>JPY</option>
									</select></td>
								</tr>
								<tr>
									<td><strong class="text-dark">Thành tiền:</strong></td>
									<td id="thanh-tien">50000</td>
									<td><button class="btn btn-success add"
											onclick="showChangeMoney()">Tiền thừa:</button></td>
									<td><label required size="10" minlength="4" maxlength="8"
										id="changeMoney">0.0</label></td>
									<td>VNĐ</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>

	</div>
	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>
</body>
</html>