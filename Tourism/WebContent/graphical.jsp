<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="/utils/header.jsp"></jsp:include>


<div class="row">
	<div class="col-md-4">
		<div class="col-md-10 col-md-offset-2">
			<h1>Données</h1>
			<p>Veuillez choisir un ou plusieurs pays</p>
			<form>


				<div>
					<select class="selectpicker" multiple
						title="Choose one of the following...">
						<option>Mustard</option>
						<option>Ketchup</option>
						<option>Relish</option>
					</select>
				</div>
				<br>
				<div>
					<select class="selectpicker" multiple
						title="Choose one of the following...">
						<option>Mustard</option>
						<option>Ketchup</option>
						<option>Relish</option>
					</select>
				</div>

				<br>
				<div>
					<input type="checkbox">Arrivées (Millions)
				</div>

				<br>
				<div>
					<input type="checkbox">Recette (Millions)
				</div>

				<br>
				
				<div class="col-md-8">
				<button class="btn btn-default" type="button" data-toggle="collapse"
					data-target="#collapseExample" aria-expanded="false"
					aria-controls="collapseExample">Détails</button>
				
				<div class="collapse" id="collapseExample">
				<br>
				<div>
					<input type="checkbox"> Toutes les donées
				</div>
				<div>
					<input type="checkbox"> Comparaison dans le monde
				</div>
				</div>
				</div>
				



			</form>
		</div>


	</div>

	<div class="col-md-7 ">
		<div id="container"
			style="min-width: 310px; height: 400px; margin: 0 auto"></div>
	</div>

</div>




<script>
	$(function() {
		$('#container')
				.highcharts(
						{
							title : {
								text : 'Monthly Average Temperature',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: WorldClimate.com',
								x : -20
							},
							xAxis : {
								categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
										'May', 'Jun', 'Jul', 'Aug', 'Sep',
										'Oct', 'Nov', 'Dec' ]
							},
							yAxis : {
								title : {
									text : 'Temperature (°C)'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							tooltip : {
								valueSuffix : '°C'
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [
									{
										name : 'Tokyo',
										data : [ 7.0, 6.9, 9.5, 14.5, 18.2,
												21.5, 25.2, 26.5, 23.3, 18.3,
												13.9, 9.6 ]
									},
									{
										name : 'New York',
										data : [ -0.2, 0.8, 5.7, 11.3, 17.0,
												22.0, 24.8, 24.1, 20.1, 14.1,
												8.6, 2.5 ]
									},
									{
										name : 'Berlin',
										data : [ -0.9, 0.6, 3.5, 8.4, 13.5,
												17.0, 18.6, 17.9, 14.3, 9.0,
												3.9, 1.0 ]
									},
									{
										name : 'London',
										data : [ 3.9, 4.2, 5.7, 8.5, 11.9,
												15.2, 17.0, 16.6, 14.2, 10.3,
												6.6, 4.8 ]
									} ]
						});
	});
</script>


<jsp:include page="/utils/footer.jsp"></jsp:include>