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
<title>Ajout d'un compte</title>

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
	<h1 class="page-title">Ajout d'un nouveau compte pour
		${client.firstname} ${client.lastname}</h1>
	<c:if test="${empty accountAdded}">
		<div class="form-cont">
			<form method="post" action="addaccount.html?id=${client.id}">
				<div class="edit-form">
					<div class="label-container">
						<label for="balance">Solde</label> 
						<label for="number">Numero</label>
						<label for="accountType">Type de compte</label> 
					</div>
					<div class="input-container">
						<input type="text" id="balance" name="balance"> 
						<input type="text" id="number" name="number"> 
						<input type="radio" name="accountType" value="current" checked>Courant<br>
						<input type="radio" name="accountType" value="savings"> Epargne<br>
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
	<c:if test="${not empty accountAdded.id}">
		<p>Ajout du nouveau compte à ${clientUpdated.firstname} ${clientUpdated.lastname}</p>
		<p>Compte numéro ${accountAdded.number}</p>
		<p>Solde initial : ${accountAdded.balance}</p>
		<p>Type de compte : ${account_Type}</p>
		<a href="index.html">
			<button class="button">Retour à l'accueil</button>
		</a>
	</c:if>

</body>
</html>