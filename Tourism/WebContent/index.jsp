<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet"
	href="/Tourism/ETC/bootstrap-3.3.5-dist/css/bootstrap.min.css">
<script src="/Tourism/ETC/JQuery/jquery-1.12.1.min.js"></script>
<script src="/Tourism/ETC/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
<script src="/Tourism/ETC/Highcharts-4.2.4/highcharts.js"></script>
<script src="/Tourism/ETC/Bootstrap-validator/validator.min.js"></script>
</head>

<body>
	<br>
	<br>
	<br>
	<br>

	<div class="jumbotron">
		<center>
			<h1>Bienvenue</h1>
		</center>

		<br>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<p>
					<b>Je suis: </b>
				</p>
			</div>
		</div>

		<div class="row">
			<div class="col-md-4 col-md-offset-5">
				<p>
					<a class="btn btn-primary btn-lg btn-block"
						href="<%=request.getContextPath()%>/Controller/Login?id=1"
						role="button">Professionnel du tourisme</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-5">
				<p>
					<a class="btn btn-primary btn-lg btn-block"
						href="<%=request.getContextPath()%>/Controller/Login?id=2"
						role="button">Développeur</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-5">
				<p>
					<a class="btn btn-primary btn-lg btn-block"
						href="<%=request.getContextPath()%>/Controller/Login?id=3"
						role="button">Curieux</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-5">
				<p>
					<a class="btn btn-primary btn-lg btn-block"
						href="<%=request.getContextPath()%>/Controller/Login?id=4"
						role="button">Pas de réponse</a>
				</p>
			</div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-5">
				<button class="btn btn-info btn-block btn-lg" type="button"
					data-toggle="collapse" data-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">Admin</button>

				<br>
				<div class="collapse" id="collapseExample">
						<form id="form" method="post" data-toggle="validator"
					role="form">
						<div class="input-group">
							<input type="password" class="form-control"
								placeholder="Mot de passe" name="password"> <span
								class="input-group-btn">
								<button class="btn btn-default" type="submit">Connecter</button>
							</span>
						</div>
						<!-- /input-group -->
					</form>
					<br>
					<div id="ajaxResponse">
					
					</div>
					<script>
					$('#form').validator().on('submit', function (e) {
						$("#ajaxResponse").empty();
						  if (e.isDefaultPrevented()) {
						    // handle the invalid form...
						  } else {
							  var form = $('#form');
								$.ajax({type : "POST",
									url : "<%=request.getContextPath()%>/Controller/Login",
									data : form.serialize(),
									success : function(data) {
									if (data.isSuccess == "false") {
										$("#ajaxResponse").append("<div class='alert alert-danger' role='alert'>Mot de passe incorrect</div>");
									} else{
										location.href = "<%=request.getContextPath()%>/page/admin.jsp";
										
									}
									},
									error : function() {										
											$("#ajaxResponse").append("Serveur Error");
											}
								});
								return false;
						  }
						})					
				    </script>
				</div>
			</div>
		</div>




	</div>

</body>
</html>