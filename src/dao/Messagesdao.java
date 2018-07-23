package dao;

import entity.Messages;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Messagesdao {
    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/twitter","root","iphone21");

        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(Messages messages)
    {
        int status=0;

        try {
            Connection con=Messagesdao.getConnection();
            PreparedStatement ps=con.prepareStatement("Insert into twitter_messages (message,follower_id,user_id) values (?,?,?)");
            ps.setString(1,messages.getMessage());
            ps.setInt(2,messages.getFollower_id());
            ps.setInt(3,messages.getUser_id());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;
    }
}
