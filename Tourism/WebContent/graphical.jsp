<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.util.ArrayList"%>
	<%@ page import="java.util.Collection"%>
	<%@ page import="model.db.CountryDB" %>
	<%@ page import="model.Country" %>
<jsp:include page="/utils/header.jsp"></jsp:include>


<div class="row">
	<div class="col-md-4">
		<div class="col-md-10 col-md-offset-2">
			<h1>Données</h1>
			<p>Veuillez choisir un ou plusieurs pays</p>
			<form>
				<div>
					<select class="selectpicker" 
						title="Select one country" id="countrySelect">
						<%
						ArrayList<String> countrys = CountryDB.getAllCountryName();
		
						for(String name : countrys){
							%>
						<option><%=name%></option>	
							
							<%
						}
						%>
					</select>
				</div>
				<div id="testDiv"></div>
				<script type="text/javascript">
		
					$("#countrySelect").change(function(){
						var countryName = $("#countrySelect").val();
						$.ajax({type : "POST",
							url : "/Tourism/Controller/Graphic",
							data : {country:countryName },
							dataType: "json",
							success : function(data) {
							   var tourists = data.tourists;
							   var incomes = data.income;
							   var json_tourists = new Array();
							   var json_year = new Array();
							   var json_incomes = new Array();
							   var countryName = data.name;

							   for(var key in tourists){
								   json_tourists.push(tourists[key]);
								   json_year.push(key);						
							   }
							       
							   for(var key in incomes){
								   json_incomes.push(incomes[key]);
							   }						   
							 
							        $('#container').highcharts({
							            title: {
							                text: 'Data',
							                x: -20 //center
							            },
							            subtitle: {
							                text: 'Source: OpenData',
							                x: -20
							            },
							            xAxis: {
							                categories: json_year
							            },
							            yAxis: {
							                title: {
							                    text: 'Millions'
							                },
							                plotLines: [{
							                    value: 0,
							                    width: 1,
							                    color: '#808080'
							                }]
							            },
							            tooltip: {
							                valueSuffix: 'Millions'
							            },
							            legend: {
							                layout: 'vertical',
							                align: 'right',
							                verticalAlign: 'middle',
							                borderWidth: 0
							            },
							            series: [
							                 {
							                name: countryName + " arrivers",
							                data: json_tourists
							           		 },{
							           			 name: countryName + " recettes",
							           			 data: json_incomes
							           		 }
							               ]
							        });
							       
							},
							error : function() {							
									$("#testDiv").append("<h1>fails</h1>");
							}
						});
					});
					
				</script>
				<br>
				<div>
					<select class="selectpicker" 
						title="Select another country" id="countrySelect2">
						<%
						ArrayList<String> countrys2 = CountryDB.getAllCountryName();
						
						for(String name : countrys2){
							%>
						<option><%=name%></option>	
							
							<%
						}
						%>
					</select>
					<script>
					$("#countrySelect2").change(function(){
						var countryName = $("#countrySelect2").val();
						$.ajax({type : "POST",
							url : "/Tourism/Controller/Graphic",
							data : {country:countryName },
							dataType: "json",
							success : function(data) {
							   var tourists = data.tourists;
							   var incomes = data.income;
							   var json_tourists = new Array();
							   var json_incomes = new Array();
							   var countryName = data.name;
								
							   var newSeries1 = {
									   name:"",
									   data: []
							   };
							   var newSeries2 = {
									   name:"",
									   data: []
							   };
							   
							   for(var key in tourists){
								   json_tourists.push(tourists[key]);
								   json_year.push(key);						
							   }
							       
							   for(var key in incomes){
								   json_incomes.push(incomes[key]);
							   }		
							   
							   
							   $('#container').highcharts.addSeries(json_incomes);
							   $('#container').highcharts.addSeries(json_tourists);
							},
							error : function() {							
									$("#testDiv").append("<h1>fails</h1>");
							}
						});
					});
					</script>
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
		
	});
</script>


<jsp:include page="/utils/footer.jsp"></jsp:include>
