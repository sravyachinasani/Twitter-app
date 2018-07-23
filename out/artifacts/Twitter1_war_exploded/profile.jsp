<%
    if (session.getAttribute("id") == null) {
        response.sendRedirect(request.getContextPath() + "/login.jsp");
    }
%>

<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: divum
  Date: 12/7/18
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css" integrity="sha384-Smlep5jCw/wG7hdkwQ/Z5nLIefveQRIY9nfy6xoR1uRYBtpZgI6339F5dgvm/e9B" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js" integrity="sha384-o+RDsa0aLu++PJvFqy8fFScvbHFLtbvScb8AjopnFD+iEQ7wo/CG0xlczd+2O/em" crossorigin="anonymous"></script>
    <%@ page import="java.sql.Connection" %>
    <%@ page import="java.sql.ResultSet" %>
    <%@ page import="java.sql.SQLException" %>
    <%@ page import="dao.Tweetsdao" %>
    <%@ page import="dao.Messagesdao" %>
</head>

<body>

<nav class="navbar navbar-expand-sm bg-dark">
    <ul class="navbar-nav">
        <li class="nav-item">
            <a class="nav-link" href="#" data-toggle="modal" data-target="#messagemodal">Messages</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="login.jsp">Logout</a>
        </li>
    </ul>
</nav>

<div id="messagemodal" class="modal fade" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <a href="#newMessage" role="button" class="btn btn-primary" data-toggle="modal"
                   style="text-align: center; margin: 5px">New Message</a>
                <p>Recent</p>
                <%
                    try {
                        Connection con = Messagesdao.getConnection();
                        java.sql.Statement st = con.createStatement();
                        ResultSet rs = null;
                        rs = st.executeQuery("select * FROM twitter_messages where user_id=("+session.getAttribute("id")+ ");");
                        while (rs.next()) {
                            out.print(rs.getInt("follower_id") + " ");
                            out.print(rs.getString("message") + " ");
                            out.print(rs.getTime("time"));
                            out.print("<br/>");
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                %>
            </div>

        </div>
    </div>
</div>
<div id="newMessage" class="modal modal-child" data-backdrop-limit="1" tabindex="-1" role="dialog"
     aria-labelledby="myModalLabel" aria-hidden="true" data-modal-parent="messagemodal">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <center>New Message</center>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>
            <div class="modal-body">
                <p>Send message to:</p>
                <div class="container" style="width: 100%">
                    <form action="/messagesservlet" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control" id="follower" placeholder="enter name"
                                   name="follower">
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control" id="message" placeholder="enter message"
                                   name="message">
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">send</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="row">
    <div class="col-lg-3 " style="background-color:blue;color:white">
        <div class="container">
            <a href="#">
                <span class="glyphicon glyphicon-user" style="color:white;font-size: 50px;text-align: center; "></span>
            </a>
        </div>
        <h3 align="center"> <br/><%=session.getAttribute("username")%>
        </h3>
    </div>
    <div class="col-lg-9 " style="background-color:white;">
        <form action="/tweetservlet" method="post">
            <div>
                <div class="form-group">
                    <input type="text" class="form-control" id="usr" placeholder="What's Happening" name="tweetc">
                </div>
                <div class="done">
                    <button type="submit" class="btn btn-primary btn-block">Tweet</button>
                    <div>
                        <%
                            try {
                                Connection con = Tweetsdao.getConnection();
                                java.sql.Statement st = con.createStatement();
                                ResultSet rs = null;
//                                 rs = st.executeQuery("select * FROM tweets where user_id in( " + session.getAttribute("id") + ");");
//                                 rs = st.executeQuery("select * FROM tweets where user_id in (select id from users where id in( " + session.getAttribute("id") + "));");
                                   rs = st.executeQuery("select * FROM tweets where user_id in (select id from users where id in( " + session.getAttribute("id") +","+session.getAttribute("follower_id")+ "));");
//                                rs = st.executeQuery("select * FROM tweets where user_id in (select id from users where username in( " + session.getAttribute("username") + "));");

                                while (rs.next()) {

                                    out.print("<div class='card'><div class='card-body'>" +session.getAttribute("username")+"        "+ rs.getString("tweet") +"                    "+rs.getTimestamp("time")+ "</div></div>");
                                }
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }


                        %>

                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>
