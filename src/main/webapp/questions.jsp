<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<html>
<head>
    <title>Question Page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/questionStyle.css" rel="stylesheet">
</head>
<body>
<div class="frame-container">
    <div class="question-title">
        <h2>Question ${sessionScope.question.getId()}</h2>
    </div>
    <div class="question-text">
        ${sessionScope.question.getText()}
    </div>
    <div class="answers-container">
        <form action="/question-servlet" method="post">
            <div class="option-style">
                <input type="radio" id="first" name="SQL_command" value="0">
                <label for="first">${sessionScope.question.getAnswers().get(0).getText()}</label><br><br>
            </div>
            <div class="option-style">
                <input type="radio" id="second" name="SQL_command" value="1">
                <label for="second">${sessionScope.question.getAnswers().get(1).getText()}</label><br><br>
            </div>
            <div class="option-style">
                <input type="radio" id="third" name="SQL_command" value="2">
                <label for="third">${sessionScope.question.getAnswers().get(2).getText()}</label><br><br>
            </div>
            <div class="option-style">
                <input type="radio" id="fourth" name="SQL_command" value="3">
                <label for="fourth">${sessionScope.question.getAnswers().get(3).getText()}</label><br><br>
            </div>
            <input type="submit" class="btn btn-primary" value="Submit">
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>