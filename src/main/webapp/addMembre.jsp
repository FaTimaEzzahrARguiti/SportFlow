<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ajouter un Membre</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container {
            max-width: 600px;
            margin-top: 50px;
        }
        .form-group label {
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="text-center mb-4">Ajouter un Nouveau Membre</h1>
    <form action="<%=request.getContextPath()%>/membre/new" method="post">
        <div class="form-group">
            <label for="nom">Nom</label>
            <input type="text" class="form-control" id="nom" name="nom" required>
        </div>
        <div class="form-group">
            <label for="prenom">Prénom</label>
            <input type="text" class="form-control" id="prenom" name="prenom" required>
        </div>
        <div class="form-group">
            <label for="tele">Téléphone</label>
            <input type="text" class="form-control" id="tele" name="tele" required>
        </div>
        <div class="form-group">
            <label for="role">Rôle</label>
            <select class="form-control" id="role" name="role" required>
                <option value="membre">Membre</option>
            </select>
        </div>
        <div class="form-group">
            <label for="username">Nom d'utilisateur</label>
            <input type="text" class="form-control" id="username" name="username" required>
        </div>
        <div class="form-group">
            <label for="password">Mot de passe</label>
            <input type="password" class="form-control" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="dateNaissance">Date de naissance</label>
            <input type="date" class="form-control" id="dateNaissance" name="dateNaissance" required>
        </div>
        <div class="form-group">
            <label for="sportPratique">Sport pratiqué</label>
            <select class="form-control" id="sportPratique" name="sportPratique" required>
                <option value="">-- Sélectionner un sport --</option>
                <option value="Football">Football</option>
                <option value="Basketball">Basketball</option>
                <option value="Natation">Natation</option>
                <option value="Tennis">Tennis</option>
                <option value="Athlétisme">Athlétisme</option>
                <option value="Volleyball">Volleyball</option>
                <option value="Boxe">Boxe</option>
                <option value="Cyclisme">Cyclisme</option>
            </select>
        </div>
        <div class="text-center">
            <button type="submit" class="btn btn-success">Ajouter</button>
            <a href="${pageContext.request.contextPath}/membre/list" class="btn btn-secondary">Annuler</a>
        </div>
    </form>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>