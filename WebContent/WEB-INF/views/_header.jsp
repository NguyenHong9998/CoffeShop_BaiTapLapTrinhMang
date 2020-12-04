<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="navigation-wrap bg-light start-header start-style">
	<div class="container">
		<div class="row">
			<div class="col-12">
				<nav class="navbar navbar-expand-md navbar-light">

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav ml-auto py-4 py-md-0">
						<li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4"><a
							class="nav-link" href="${pageContext.request.contextPath}/">Trang
								chủ</a></li>
						<li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4 "><a
							class="nav-link"
							href="${pageContext.request.contextPath}/PriceTimeList">Sản
								phẩm</a></li>


						<li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4"><a
							class="nav-link"
							href="${pageContext.request.contextPath}/CustomerList">Khách
								hàng</a></li>
						<li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4"><a
							class="nav-link"
							href="${pageContext.request.contextPath}/BillList" role="button">Hóa
								đơn</a></li>
						<li class="nav-item pl-4 pl-md-0 ml-0 ml-md-4">
							<%
								if (session.getAttribute("account") == null) {
							%> <a class="nav-link"
							href="${pageContext.request.contextPath}/Login">Login</a> <%
 	} else {
 %> <a class="nav-link" href="${pageContext.request.contextPath}/Logout">
								Hello <%=session.getAttribute("account")%>,Logout
						</a> <%
 	}
 %>
						</li>
					</ul>
				</div>
				</nav>
			</div>
		</div>
	</div>
</div>