
<%@ page contentType="text/html;charset=UTF-8" language="java" %>



<!DOCTYPE html>
<html>
<head>
    <title>Liste des Membres</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Liste des Membres</h1>
    <c:if test="${not empty message}">
        <div class="alert alert-${messageType}">${message}</div>
    </c:if>
    <table class="table">
        <thead>
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>Rôle</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="membre" items="${membres}">
            <tr>
                <td>${membre.id}</td>
                <td>${membre.nom}</td>
                <td>${membre.prenom}</td>
                <td>${membre.role}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>