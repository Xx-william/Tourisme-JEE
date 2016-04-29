<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="model.db.CountryDB"%>

<jsp:include page="/utils/header.jsp"></jsp:include>

<script src="https://code.highcharts.com/maps/highmaps.js"></script>
<script src="https://code.highcharts.com/maps/modules/exporting.js"></script>
<script src="https://code.highcharts.com/mapdata/custom/world.js"></script>


<div class="col-md-4">
	<div class="col-md-10 col-md-offset-2">
		<h1>Données</h1>
		<p>Veuillez choisir un ou plusieurs pays</p>

		<form>
			<div>
				<select class="selectpicker" title="Select one type" id="select1">
					<option>Région</option>
					<option>Pays</option>
				</select>
			</div>
			<br>
			<div>
				<select class="selectpicker" title="Select one year" id="select2">
					<%
							ArrayList<Integer> years = CountryDB.getYears();

							for (int year : years) {
						%>
						<option><%=year%></option>

						<%
							}
						%>
				</select>
			</div>
			<br>
			<div>
				<input type="checkbox" id="checkbox1" checked >Arrivées
				(Millions)
			</div>

			<br>
			<div>
				<input type="checkbox" id="checkbox2"  >Recette
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
$(function () {
	
    // Prepare demo data
    var data = [
        {
            "hc-key": "fo",
            "value": 0
        },
        {
            "hc-key": "um",
            "value": 1
        },
        {
            "hc-key": "us",
            "value": 2
        }
    ];

    // Initiate the chart
    $('#container').highcharts('Map', {

        title : {
            text : 'Highmaps basic demo'
        },

        subtitle : {
            text : 'Source'
        },

        mapNavigation: {
            enabled: true,
            buttonOptions: {
                verticalAlign: 'bottom'
            }
        },

        colorAxis: {
            min: 0
        },

        series : [{
            data : data,
            mapData: Highcharts.maps['custom/world'],
            joinBy: 'hc-key',
            name: 'Random data',
            states: {
                hover: {
                    color: '#BADA55'
                }
            },
            dataLabels: {
                enabled: true,
                format: '{point.name}'
            }
        }]
    });
});

</script>

<jsp:include page="/utils/footer.jsp"></jsp:include>