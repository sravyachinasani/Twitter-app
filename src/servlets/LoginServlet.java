package servlets;

import dao.Userdao;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginservlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        HashFunction hashFunction = new HashFunction();
        String password1 = hashFunction.generateHash(password);
        System.out.println("password1 is" + password);
        HttpSession session = request.getSession(true);

        if (Userdao.getUser(username, password1)) {
            session.setAttribute("username", username);
            response.sendRedirect("profile.jsp");
            request.getRequestDispatcher("profile.jsp").include(request, response);

        } else {
            out.println("Sorry! unable to login");
            request.getRequestDispatcher("login.jsp").include(request, response);
        }
        Users users = Userdao.getId(username);
        int id = users.getId();
        System.out.println("id is" + id);
        session.setAttribute("id", id);
//        session.setAttribute("usernamee",username);

    }
}
