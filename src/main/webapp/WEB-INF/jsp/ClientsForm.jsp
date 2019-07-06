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
<h1>KLIENT FORMULARZ</h1>
<form:form method="POST" action="save">
    <div class="row centered">
    <div class="col s12">
    <h5>First name:</h5>
    <form:input path="first_name"/>
    </div>
    <div class="col s12">
    <h5>Last name:</h5>
    <form:input path="last_name"/>
    </div>
    <div class="col s12">
    <h5>Email:</h5>
    <form:input path="email"/>
    </div>
    <div class="col s12">
    <h5>Item ID:</h5>
    <form:input path="item_id"/>
    </div>
    </form>
    </div>
    <div class="col s12 center-align">
        <input type="submit" value="Save" />
    </div>
</form:form>
</body>
</html>