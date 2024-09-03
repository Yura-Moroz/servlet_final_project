<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>The entry page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="/css/indexStyle.css" rel="stylesheet">
    <script src="/js/indexScripts.js" defer></script>
</head>

<body class="d-flex justify-content-center align-items-center vh-100">
<div class="text-center">
    <h1>Prologue</h1>
    <br/>
    <div id="text1-container" class="typed-text"></div><div class="cursor"></div>
    <br>
    <div id="text2-container" class="typed-text"></div><div class="cursor"></div>
    <br>
    <div id="text3-container" class="typed-text"></div><div class="cursor"></div>
    <br>
    <div id="text4-container" class="typed-text"></div><div class="cursor"></div>
    <br>
    <div id="text5-container" class="typed-text"></div><div class="cursor"></div>

    <!-- Form section that appears after the last paragraph -->
    <div class="form-section">
        <form action="/start" method="post">
            <div class="mb-3">
                <label for="username" class="form-label visually-hidden">Your name:</label>
                <input type="text" id="username" name="username" class="form-control" required placeholder="Your name">
            </div>
            <button type="submit" class="btn btn-primary">Submit</button>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>
