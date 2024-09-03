<%--
  Created by IntelliJ IDEA.
  User: Юра
  Date: 27.08.2024
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<html>
<head>
    <title>Finish</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/outcome.css" rel="stylesheet">
</head>
<body>
<div class="outcome-frame">
    <div class="result-text">
        Congratulations!!!<br>
        Your clever mind saved this planet!<br><br>
        You can do it once again)
    </div>

    <form action="/start" method="post">
        <input type="submit" class="btn btn-primary" value="Again">
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
