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

<script
	src="/Tourism/ETC/bootstrap-select/js/bootstrap-select.js"></script>
	<link rel="stylesheet"
	href="/Tourism/ETC/bootstrap-select/css/bootstrap-select.min.css">
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">Statourist</a>
    </div>
  	<div class="navbar-right">
  	  	<a class="btn btn-info btn-sm navbar-btn" href="<%=request.getContextPath()%>/graphical.jsp">Aperçu Graphique</a>
  		<a class="btn btn-info btn-sm navbar-btn" href="<%=request.getContextPath()%>/map.jsp">Carte du Monde</a>
  	</div>
 
  </div><!-- /.container-fluid -->
</nav>

<!-- body and html not closed -->
