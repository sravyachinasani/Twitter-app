package dao;

import entity.Tweets;

import java.sql.*;

public class Tweetsdao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/twitter","root","iphone21");

        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(Tweets tweets)
    {
        int status=0;
        Tweets tweets1=new Tweets();
        try
        {
            Connection con=Tweetsdao.getConnection();
            PreparedStatement ps=con.prepareStatement("Insert into tweets (tweet,user_id) values (?,?)");
          // PreparedStatement ps1= connection.prepareStatement("select * from tweets where tweets.user_id=users.id");
            ps.setString(1,tweets.getTweet());
            ps.setInt(2,tweets.getUser_id());

           ps.executeUpdate();
//            ResultSet rs=ps1.executeQuery();
//            if(rs.next())
//            {
//                tweets1.setId(rs.getInt(1));
//
//            }
            con.close();
//            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
