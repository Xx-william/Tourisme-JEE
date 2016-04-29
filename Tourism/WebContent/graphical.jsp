<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Collection"%>
<%@ page import="model.db.CountryDB"%>
<%@ page import="model.Country"%>
<jsp:include page="/utils/header.jsp"></jsp:include>

<script src="/Tourism/ETC/Highcharts-4.2.4/highcharts.js"></script>
<div class="row">
	<div class="col-md-4">
		<div class="col-md-10 col-md-offset-2">
			<h1>Données</h1>
			<p>Veuillez choisir un ou plusieurs pays</p>
			<form>
				<div>
					<select class="selectpicker" title="Select one country"
						id="countrySelect">
						<%
							ArrayList<String> countrys = CountryDB.getAllCountryName();

							for (String name : countrys) {
						%>
						<option><%=name%></option>

						<%
							}
						%>
					</select>
				</div>
				<div id="testDiv"></div>

				<br>
				<div>
					<select class="selectpicker" title="Select another country"
						id="countrySelect2">
						<%
							ArrayList<String> countrys2 = CountryDB.getAllCountryName();
							for (String name : countrys2) {
						%>
						<option><%=name%></option>

						<%
							}
						%>
						
						
					</select>
					
				</div>

				<br>
				<div>
					<input type="checkbox" id="checkbox1" checked disabled>Arrivées (Millions)
				</div>

				<br>
				<div>
					<input type="checkbox" id="checkbox2" checked disabled>Recette (Millions)
				</div>
				
				<br>

				<div class="col-md-8">
					<button class="btn btn-default" type="button"
						data-toggle="collapse" data-target="#collapseExample"
						aria-expanded="false" aria-controls="collapseExample">Détails</button>

					<div class="collapse" id="collapseExample">
						<br>
						<div>
							<input type="checkbox"> Toutes les donées
						</div>
						<div>
							<input type="checkbox" id="checkCompa"> Comparaison dans le monde
						</div>
					</div>
				</div>

				<script type="text/javascript">
					
						var chart;
						
						var option = {
							
							chart : {
								renderTo : "container",
								type : "line"
							},
							title : {
								text : 'Data',
								x : -20
							//center
							},
							subtitle : {
								text : 'Source: OpenData',
								x : -20
							},
							xAxis : {
								categories : []
							},
							yAxis : {
								title : {
									text : 'Millions'
								},
								plotLines : [ {
									value : 0,
									width : 1,
									color : '#808080'
								} ]
							},
							tooltip : {
								valueSuffix : 'Millions'
							},
							legend : {
								layout : 'vertical',
								align : 'right',
								verticalAlign : 'middle',
								borderWidth : 0
							},
							series : [ {
								name : "",
								data : [],
								
								
							
							}, {
								name : "",
								data : [],
								
							}, {
								name : " ",
								data : [],
								
								
							}, {
								name : " ",
								data : [],
								
							} ]
						};
						
						$("#checkbox1").change(function(){
							var series1 = chart.series[0];
							 var series2 = chart.series[2];
							 
						        if (series1.visible) {
						            series1.hide();
						            series2.hide();
						        } else {
						            series1.show();
						            series2.show();
						        }
						});
						$("#checkbox2").change(function(){
							 var series1 = chart.series[1];
							 var series2 = chart.series[3];
							 
						        if (series1.visible) {
						            series1.hide();
						            series2.hide();
						        } else {
						            series1.show();
						            series2.show();
						        }
						});
						
						$("#countrySelect").change(function() {
							refreshCharts(1);
							
							$("#checkbox1").removeAttr("disabled");
							$("#checkbox2").removeAttr("disabled");
							
							
						});
						$("#countrySelect2").change(function() {
							refreshCharts(2);
							$("#checkbox1").removeAttr("disabled");
							$("#checkbox2").removeAttr("disabled");
						});
						
						
						$("#checkCompa").change(function() {
							
							if($("#checkCompa").prop('checked')){
								$("#tableDiv").removeAttr("style");
								$("#container").hide();
								$("#tableDiv").show							
								refreshTable();
							}else{
								$("#tableDiv").hide();
								$("#container").show();
							}													
						});
						
						function refreshTable(){
							var tableHead="";
							var tableBody="";
							
							
							var touristsName1 = chart.series[0].name;
							var tourists1 = chart.series[0].data;
							
							var incomeName1 = chart.series[1].name;
							var incomes1 = chart.series[1].data;
							
							var touristsName2 = chart.series[2].name;
							var tourists2 = chart.series[2].data;
							
							var incomeName2 = chart.series[3].name;
							var incomes2 = chart.series[3].data;
							
							tableHead = "<tr>"+
					          "<th>Annee</th>"+
							  "<th>"+ touristsName1+"</th>"+
							  "<th>"+ incomeName1+"</th>"+
							  "<th>"+ touristsName2+"</th>"+
							  "<th>"+ incomeName2+"</th>"+
					          "</tr>";
					         
						    $("#tableHead").html(tableHead);
						      
							 for(var i = 0;i<tourists1.length;i++){
								 tableBody = tableBody +"<tr>"+
						    	  "<td>"+
						    	  tourists1[i].category+
						    	  "</td>"+
						    	  "<td>"+
						    	  	tourists1[i].options.y+
						    	  "</td>"+
						    	  "<td>"+
						    	  incomes1[i].options.y+
						    	  "</td>"+
						    	  "<td>"+
						    	  	tourists2[i].options.y+
						    	  "</td>"+
						    	  "<td>"+
						    	  incomes2[i].options.y+
						    	  "</td>"+
						    	  "</tr>";
						      }
							 
						      $("#tableBody").html(tableBody);
						};
						
						function refreshCharts(n) {
							var countryName;
							if(n == 1){
								countryName = $("#countrySelect").val();
							}else if(n==2){
								countryName = $("#countrySelect2").val();
							}
							
							$.ajax({
								type : "POST",
								url : "/Tourism/Controller/Graphic",
								data : {
									country : countryName
								},
								dataType : "json",
								success : function(data) {

									var tourists = data.tourists;
									var incomes = data.income;
									var json_tourists = new Array();
									var json_year = new Array();
									var json_incomes = new Array();
									var countryName = data.name;

									for ( var key in tourists) {
										json_tourists.push(tourists[key]);
										json_year.push(key);
									}

									for ( var key in incomes) {
										json_incomes.push(incomes[key]);
									}
									if(n==1){
										option.series[0].name = countryName + " arrivers";
										option.series[0].data = json_tourists;
										option.series[1].name = countryName + " recettes";
										option.series[1].data = json_incomes;	
									}else if(n==2){
										option.series[2].name = countryName + " arrivers";
										option.series[2].data = json_tourists;
										option.series[3].name = countryName + " recettes";
										option.series[3].data = json_incomes;	
									}
																	
								
									option.xAxis.categories = json_year;

									 chart = new Highcharts.Chart(option);

								},
								error : function() {
									$("#testDiv").append("<h1>fails</h1>");
								}
							});
						};
					</script>


			</form>
		</div>


	</div>

	<div class="col-md-7 ">
		<div id="container"
			style="display: ; min-width: 310px; height: 400px; margin: 0 auto">
		</div>
		<div id="tableDiv" style="display:">
		<table class="table table-bordered" id ="table">
    		<thead id="tableHead"></thead>
    		<tbody id="tableBody"></tbody>
   		 </table>
		</div>
					
	</div>

</div>

<jsp:include page="/utils/footer.jsp"></jsp:include>
