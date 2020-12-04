<%@page import="java.util.ArrayList"%>
<%@page import="entities.Bill"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.time.LocalDate"%>
<%@page import="service.BillServiceImpl"%>
<%@page import="java.util.Comparator"%>
<%@page import="service.PriceTimeServiceImpl"%>
<%@page import="entities.PriceTime"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>THEM HOA DON</title>
<style type="text/css">
</style>
<link rel='stylesheet' href='css/bootstrap.min.css'>

<link rel="stylesheet" href="css/style.css">
<script src='js/jquery.min.js'></script>
<script src="js/index.js"></script>
<script type="text/javascript">
	localStorage.removeItem('items');
	function getSelectValue() {
		var selectedValue = document.getElementById("state_list").value;
		return selectedValue;
	}

	function addItemToTable() {
		var itemsStorage = localStorage.getItem('items');
		if (!itemsStorage) {
			itemsStorage = [];
		} else {
			itemsStorage = JSON.parse(itemsStorage);
		}

		var table = document.getElementById("table-bill");
		var currentSelectItem = document.getElementById("state_list").value;
		var arrayProperties = currentSelectItem.slice(11, -1).split(',');
		// Create an empty <tr> element and add it to the 1st position of the table:
		var row = table.insertRow(-1);
		var cellSTT = row.insertCell(0);
		var cellCode = row.insertCell(1);
		var cellName = row.insertCell(2);
		var cellUnit = row.insertCell(3);
		var cellPrice = row.insertCell(4);

		cellCode.innerText = arrayProperties[0].split('=')[1];
		cellName.innerText = arrayProperties[2].split('=')[1];
		cellUnit.innerText = "VND";

		cellPrice.innerText = arrayProperties[1].split('=')[1].toString();
		itemsStorage.push({
			code : arrayProperties[0].split('=')[1],
			price : arrayProperties[1].split('=')[1]
		})
		cellSTT.innerText = (itemsStorage.length).toString();
		var totalBill = 0;
		for (var i = 0; i < itemsStorage.length; i++) {
			totalBill += Number(itemsStorage[i].price);
		}
		document.getElementById('total-money').innerText = totalBill.toString();
		localStorage.setItem('items', JSON.stringify(itemsStorage))
	}

	function redirectToBillInsert(idBill) {
		var itemsStorage = localStorage.getItem('items');
		if (!itemsStorage) {
			itemsStorage = [];
		} else {
			itemsStorage = JSON.parse(itemsStorage);
		}
		let idListBill = [];
		for (var i = 0; i < itemsStorage.length; i++) {
			idListBill.push(itemsStorage[i].code);
		}
		idListBill = idListBill.join(',')
		window.location.href = 'BillInsertControl?billId=' + idBill + '&idListItem='
				+ idListBill;
	}
</script>
</head>

<%
	String warn = (String) request.getAttribute("warn");
	List<PriceTime> priceTime = new PriceTimeServiceImpl().getAll();
	priceTime.sort(new Comparator<PriceTime>() {
		public int compare(PriceTime o1, PriceTime o2) {
			return o1.getIdPriceTime().compareTo(o2.getIdPriceTime());
		}
	});
	String id = new BillServiceImpl().randomId();
	List<PriceTime> list = new ArrayList<>();
%>
<body>
	<jsp:include page="/WEB-INF/views/_header.jsp"></jsp:include>
	<div
		class="offset-xl-2 col-xl-8 col-lg-12 col-md-12 col-sm-12 col-12 padding"
		style="margin-top: 50px">
		<button class="btn btn-success add"
			onclick="redirectToBillInsert('<%=id%>')" type="submit">Thêm
			hóa đơn</button>
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
				<div>
					<div style="float: left; margin-bottom: 10px">
						<select class="form-control form-control-xs selectpicker" name=""
							data-size="7" data-title="Location" id="state_list"
							data-width="40%">
							<%
								for (PriceTime pt : priceTime) {
							%>
							<option value="<%=pt.toString()%>" selected>
								<%=pt.getIdPriceTime() + " - " + pt.getDesPriceTime()%>
							</option>
							<%
								}
							%>
						</select>
					</div>
					<div>
						<button class="btn btn-success add" style="margin-left: 5px;"
							onclick="addItemToTable()">Thêm</button>
					</div>
				</div>
				<div class="table-responsive-sm">
					<table class="table table-striped" id="table-bill">
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
											tiền:</strong></td>
									<td class="right" id="total-money"><%=(new Bill()).getMoney(list)%></td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
			</div>

		</div>

	</div>
	<div><br><br><br></div>
	<jsp:include page="/WEB-INF/views/_footer.jsp"></jsp:include>

</body>
</html>