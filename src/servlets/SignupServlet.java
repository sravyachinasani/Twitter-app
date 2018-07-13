package servlets;

import dao.Userdao;
import entity.Users;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/signupservlet")
public class SignupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstname=request.getParameter("firstname");
        String lastname=request.getParameter("lastname");
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        String mobileno=request.getParameter("mobileno");
       HashFunction hashFunction=new HashFunction();
      String password1= hashFunction.generateHash(password);

        Users users=new Users();
        users.setFirstname(firstname);
        users.setLastname(lastname);
        users.setUsername(username);
        users.setEmail(email);
        users.setMobileno(mobileno);
        users.setPassword(password1);
        int status=Userdao.save(users);

        if(status>0){
            out.print("<p>Record saved successfully!</p>");
            //out.print(password1);
            request.getRequestDispatcher("signup.jsp").include(request, response);
        }else{
            out.println("Sorry! unable to save record");
        }

        out.close();
    }
}

