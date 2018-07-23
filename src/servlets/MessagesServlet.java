package servlets;

import dao.Messagesdao;
import dao.Userdao;
import entity.Messages;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/messagesservlet")
public class MessagesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String follower_name=request.getParameter("follower");
        Messages messages=new Messages();
         int follower_id=Userdao.getIdd(follower_name);
         session.setAttribute("follower_id",follower_id);
         System.out.println("follower id is"+follower_id);
        String message=request.getParameter("message");
         Object id=session.getAttribute("id");
         Integer user_id=null;
         if(id!=null)
         {
             user_id=(Integer)id;
         }

        messages.setFollower_id(follower_id);
        messages.setMessage(message);
        messages.setUser_id(user_id);
        Messagesdao.save(messages);

    }
}
