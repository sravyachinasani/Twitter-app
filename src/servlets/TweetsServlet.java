package servlets;

import dao.Tweetsdao;
import entity.Tweets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
@WebServlet("/tweetservlet")
public class TweetsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
//        String Follower_t=request.getParameter("follower");
//        System.out.println("follower in tweets is"+Follower_t);
        String tweet = request.getParameter("tweetc");
        String username = (String) session.getAttribute("username");
        System.out.println("username is" + username);
//
        Object id=session.getAttribute("id");
      Integer user_id=null;
      if(id!=null)
      {
       user_id=(Integer)id;

      }

       Tweets tweets = new Tweets();
        tweets.setTweet(tweet);
        tweets.setUser_id(user_id);
        Tweetsdao.save(tweets);
        System.out.println("user_id in tweets" + user_id);
        System.out.println("tweet is" + tweet);


        ArrayList<String> list=new ArrayList<String>();
        String param=request.getParameter("tweetc");
        list.add(param);
        session.setAttribute("param",param);
        request.getRequestDispatcher("profile.jsp").forward(request, response);
//        for(int i=0;i<list.size();i++)
//        {
//            list.add(param);
//            session.setAttribute("param",param);
//            request.getRequestDispatcher("profile.jsp").include(request, response);
//            //RequestDispatcher rd = getServletContext().getRequestDispatcher("/profile.jsp");
//            //rd.forward(request, response);
//            out.println(list.get(i));
//        }
    }
}
