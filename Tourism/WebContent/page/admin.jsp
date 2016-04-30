<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	HttpSession sessionCheck = request.getSession();
	String islogin = (String) sessionCheck.getAttribute("isLogin");
	if (islogin != "true") {
		String site = new String(request.getContextPath() + "/Controller/Disconnect");
		response.setStatus(response.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", site);
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/Tourism/ETC/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="/Tourism/ETC/JQuery/jquery-1.12.1.min.js"></script>
<script src="/Tourism/ETC/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="/Tourism/ETC/Highcharts-4.2.4/highcharts.js"></script>
</head>
<body>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header"></div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">


			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Admin <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a
							href="<%=request.getContextPath()%>/Controller/Disconnect">Déconnecter</a></li>

					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div id="container"
				style="display:; min-width: 310px; height: 400px; margin: 0 auto">
			</div>
		</div>

	</div>
	<script>
		var option = {

			chart : {
				renderTo : "container",
				type : "column"
			},
			title : {
				text : 'Les statistiques utilisateurs',
				x : -20
			//center
			},
			subtitle : {
				text : '',
				x : -20
			},
			xAxis : {
				categories : []
			},
			yAxis : {
				title : {
					text : 'Personne'
				},
				plotLines : [ {
					value : 0,
					width : 1,
					color : '#808080'
				} ]
			},
			tooltip : {
				valueSuffix : ''
			},
			legend : {
				layout : 'vertical',
				align : 'right',
				verticalAlign : 'middle',
				borderWidth : 0
			},
			series : [{
				name:"",
				data:[]
			}]
		};
		$.ajax({
			type : "POST",
			url : "../Controller/GetAllUser",
			dataType : "json",
			success : function(data) {
				var json_countryname = new Array();
				var json_count = new Array();

				for ( var i=0;i<data.length;i++) {
					json_countryname.push(data[i].type);
					json_count.push(data[i].count);
					
				}

				option.series[0].name = "Nombre";
				option.series[0].data = json_count;				
				option.xAxis.categories = json_countryname;

				chart = new Highcharts.Chart(option);

			},
			error : function() {
				$("#testDiv").append("<h1>fails</h1>");
			}
		});
	</script>

</body>
</html>