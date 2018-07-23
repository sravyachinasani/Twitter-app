import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String username=request.getParameter("Username");
      String firstname=request.getParameter("Firstname");
      String Lastname=request.getParameter("Lastname");
      String password=request.getParameter("Password");
      String contact=request.getParameter("Mobileno");
      String email=request.getParameter("Email");

//      if(username.equals("sravya@1") && password.equals("123"))
//      {
//          response.sendRedirect("signupsuccess.jsp");
//      }
//      else
//      {
//          response.sendRedirect("signup");
//      }
   }

//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
}
