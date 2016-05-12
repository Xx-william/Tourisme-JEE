<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="model.db.CountryDB"%>

<jsp:include page="/utils/header.jsp"></jsp:include>

<script src="https://code.highcharts.com/maps/highmaps.js"></script>
<script src="https://code.highcharts.com/maps/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/custom/world.js"></script>
<script
	src="https://code.highcharts.com/mapdata/custom/world-continents.js"></script>

<div class="col-md-4">
	<div class="col-md-10 col-md-offset-2">
		<h1>Données</h1>
		<p>Veuillez choisir un ou plusieurs pays</p>

		<form>
			<div>
				<select class="selectpicker" title="Choisir une zone" id="select1">
					<option selected value="1">Région</option>
					<option value="2">Pays</option>
				</select>
			</div>
			<br>
			<div>
				<select class="selectpicker" title="Choisir une année" id="select2">
					<%
						ArrayList<Integer> years = CountryDB.getYears();
						for (int year : years) {
					%>
					<option value="<%=year%>"><%=year%></option>

					<%
						}
					%>
				</select>
			</div>
			<br>
			<div>
				<input type="radio" name="datatype" id="radio1" value="1" checked>Arrivées
				(Millions)
			</div>

			<br>
			<div>
				<input type="radio" name="datatype" value="2" id="radio2">Recette
				(Millions)

			</div>

			<div id="testDiv"></div>
		</form>
	</div>
</div>
<div class="col-md-7">
	<div id="container"></div>
</div>
<script>
	var typeSelect = $("#select1").val();
	var yearSelect = "";
	var datatype = $("input[name='datatype']:checked").val();
	var map;

	$("#select1").change(function() {
		typeSelect = $("#select1").val();

		refreshMap();
	});
	$("#select2").change(function() {
		yearSelect = $("#select2").val();
		refreshMap();
	});

	$("input[name='datatype']").change(function() {
		datatype = $("input[name='datatype']:checked").val();
		refreshMap();
	});

	function refreshMap() {
		// Prepare demo data
		var data = [];
		var option = {
			chart : {
				renderTo : "container"
			},
			title : {
				text : 'Carte du monde'
			},

			subtitle : {
				text : 'Source: OpenData'
			},

			mapNavigation : {
				enabled : true,
				buttonOptions : {
					verticalAlign : 'bottom'
				}
			},

			colorAxis : {
				min : 0
			},

			series : [ {
				data : data,
				//mapData: Highcharts.maps['custom/world'],
				mapData : '',
				joinBy : 'hc-key',
				name : '',
				states : {
					hover : {
						color : '#BADA55'
					}
				}

			} ]

		};
		if (yearSelect == "") {

		} else {
			$
					.ajax({
						type : "POST",
						url : "/Tourism/Controller/Map",
						data : {

						},
						dataType : "json",
						success : function(data) {

							if (typeSelect == "1") {
								option.series[0].mapData = Highcharts.maps['custom/world-continents'];
								if (datatype == "2") {
									dataT = [
											{
												"hc-key" : "eu",
												"value" : data[0].regionIncomes[yearSelect]
											},
											{
												"hc-key" : "oc",
												"value" : data[1].regionIncomes[yearSelect]
											},
											{
												"hc-key" : "af",
												"value" : data[3].regionIncomes[yearSelect]
											},
											{
												"hc-key" : "as",
												"value" : data[1].regionIncomes[yearSelect]
											},
											{
												"hc-key" : "na",
												"value" : data[2].regionIncomes[yearSelect]
											},
											{
												"hc-key" : "sa",
												"value" : data[2].regionIncomes[yearSelect]
											} ];
									option.series[0].name = yearSelect
											+ " Recette";
								} else {
									dataT = [
											{
												"hc-key" : "eu",
												"value" : data[0].regionTourists[yearSelect]
											},
											{
												"hc-key" : "oc",
												"value" : data[1].regionTourists[yearSelect]
											},
											{
												"hc-key" : "af",
												"value" : data[3].regionTourists[yearSelect]
											},
											{
												"hc-key" : "as",
												"value" : data[1].regionTourists[yearSelect]
											},
											{
												"hc-key" : "na",
												"value" : data[2].regionTourists[yearSelect]
											},
											{
												"hc-key" : "sa",
												"value" : data[2].regionTourists[yearSelect]
											} ];
									option.series[0].name = yearSelect
											+ " Arrivées";
								}
								option.series[0].data = dataT;

							} else {

								option.series[0].mapData = Highcharts.maps['custom/world'];
								if (datatype == "1") {
									var dataT = [];
									for (var i = 0; i < 5; i++) {
										var countrys = data[i].countrys;

										for (var j = 0; j < countrys.length; j++) {
											var countrytemp = {
												"hc-key" : countrys[j].hckey,
												"value" : countrys[j].tourists[yearSelect]
											};
											dataT.push(countrytemp);
										}

									}
									option.series[0].name = yearSelect
											+ " Arrivées";
								} else {
									var dataT = [];
									for (var i = 0; i < 5; i++) {
										var countrys = data[i].countrys;
										for (var j = 0; j < countrys.length; j++) {
											var countrytemp = {
												"hc-key" : countrys[j].hckey,
												"value" : countrys[j].income[yearSelect]
											};
											dataT.push(countrytemp);
										}

									}
									option.series[0].name = yearSelect
											+ " Recette";
								}
								option.series[0].data = dataT;

							}
							map = new Highcharts.Map(option);
						},
						error : function() {
							$("#testDiv").append("<h1>fails</h1>");
						}
					});

		}
	}
</script>

<jsp:include page="/utils/footer.jsp"></jsp:include>