<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 01.09.2024
  Time: 01:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Error</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/outcome.css" rel="stylesheet">
</head>
<body>

<div class="outcome-frame">
    <div class="result-text">
        Unfortunately, You are mistaken... <br>
        But it seems like you have some time till collapse <br>
        So try one more time!
    </div>

    <form class="form-section" action="/start" method="post">
        <input type="submit" class="btn btn-primary" value="Retry">
    </form>

    <div class="statistic">
        <p>Statistic:</p><br>
        <p>Name: ${sessionScope.username}</p><br>
        <p>IP address: ${sessionScope.IPAddress}</p><br>
        <p>Games played: ${sessionScope.gamesCounter}</p>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
