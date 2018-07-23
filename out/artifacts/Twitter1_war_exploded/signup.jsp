<!DOCTYPE html>
<html lang="en">
<head>
    <title>Signup Form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .navbar{
            background: dodgerblue;
        }
        .nav.navbar-nav.navbar-right li a {
            color: white;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">

            </button>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="login.jsp">Login</a></li>
        </ul>
    </div>
</nav>
<div class="container">
    <h2>Signup</h2>
    <form action="/signupservlet" method="post">

        <div class="form-group">
            <label for="usr">Firstname:</label>
            <input type="text" class="form-control" id="usr1" placeholder="Enter Firstname" name="firstname">
        </div>
        <div class="form-group">
            <label for="usr">Lastname:</label>
            <input type="text" class="form-control" id="usr2" placeholder="Enter Lastname"  name="lastname">
        </div>
        <div class="form-group">
            <label for="usr">Username:</label>
            <input type="text" class="form-control" id="usr" placeholder="Enter Username" name="username">
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
        </div>
        <div class="form-group">
            <label for="pwd">Password:</label>
            <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
        </div>
        <div class="form-group">
            <label for="example-tel-input" class="col-2 col-form-label">Telephone</label>
            <input type="tel" class="form-control" id="phn" placeholder="Enter mobile number" name="mobileno">
        </div>
        <%--<div class="form-group">--%>
            <%--<label for="example-date-input" class="col-2 col-form-label">Date</label>--%>
            <%--<input type="date" class="form-control" id="birthday" placeholder="Enter date of birth" name="birthday">--%>
        <%--</div>--%>
        <%--<div class="checkbox">
            <label><input type="checkbox" name="remember"> Remember me</label>
        </div>--%>
        <button type="submit" class="btn btn-primary btn-block">Signup</button>
    </form>
</div>

</body>
</html>
