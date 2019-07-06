<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="First crud attempt">
    <meta name="keywords" content="JAVA,SPRING, PSQL">
    <meta name="author" content="Rafal Hejnowicz">
    <!-- LINKI -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
<h1>LISTA KLIENTOW</h1>
<div class="row">
    <div class="col s3">Imie</div>
    <div class="col s3">Nazwisko</div>
    <div class="col s3">Email</div>
    <div class="col s3">ID przedmiotu</div>
    <c:forEach var="client" items="${list}">
    <div class="col s3">client.first_name</div>
    <div class="col s3">client.last_name</div>
    <div class="col s3">client.email</div>
    <div class="col s3">client.item_id</div>
    <a href="EditClient/${client.id}">Edytuj</a>
    <a href="delete/${client.id}">Usun</a>
    </c:forEach>
    <a href="ClientsForm">Dodaj klienta</a>
</div>

</body>
</html>