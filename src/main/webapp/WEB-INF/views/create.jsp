<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">
<title>Ajout d'un client</title>

<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
	type="text/css">
<link href="https://fonts.googleapis.com/css?family=Montserrat:400,700"
	rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Kaushan+Script'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/agency.min.css" rel="stylesheet">
<link href="css/index.css" rel="stylesheet">
</head>
<body>
	<section class="head"></section>
	<h1 class="page-title">Insertion d'un nouveau client dans le Base de données.</h1>
	<c:if test="${empty clientAdded}">
	<div class="form-cont">
		<form method="post" action="">
			<div class="edit-form">
				<div class="label-container">
					<label for="lastname">Nom</label> 
					<label for="firstname">Prénom</label> 
					<label for="email">Email</label> 
					<label for="address"> Adresse</label> 
				</div>
				<div class="input-container">
					<input type="text" id="lastname" name="lastname" maxlength="45">
					<input type="text" id="firstname" name="firstname" maxlength="45">
					<input type="email" id="email" name="email" maxlength="45"> 
					<input type="text" id="address" name="address" maxlength="45">
				</div> 
				
			</div>
		<div class="buttons">
			<button class="button">Valider</button>
			<button type="reset" class="button">Réinitialiser</button>
		</div>
		</form>
			<a href="index.html">
				<button class="button">Retour à l'accueil</button>
			</a>
		</div>
		</c:if>
		<c:if test="${not empty clientAdded.id}">
		<p>Nouveau client ajouté !</p>
		<p>${clientAdded.firstname} ${clientAdded.lastname}</p>
		<p>${clientAdded.email}</p>
		<p>${clientAdded.address}</p>
		<a href="index.html">
				<button class="button">Retour à l'accueil</button>
			</a>
		</c:if>
		
</body>
</html>