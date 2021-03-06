<!DOCTYPE html>
<html lang="en">
<head>
    <title>Signin Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar{
            background: #2f6f9f;
        }
        .nav.navbar-nav.navbar-right li a{
            color: white;
        }
    </style>
</head>
<body>
<%
    session.setAttribute("id", null);
%>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">

            </button>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="signup.jsp">Signup</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <h2>Signin</h2>
    <form action="/loginservlet" method="post">
        <div class="form-group">
            <label for="usr">Username:</label>
            <input type="text" class="form-control" id="usr" placeholder="Enter Username" name="username">

        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="password">
        </div>
        <div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>
        <button type="submit" class="btn btn-primary btn-block">Login</button>
    </form>
    <form action="profile.jsp" method="post">
        <%
            session.setAttribute("userName","username");
        %>
    </form>
</div>

</body>
</html>
