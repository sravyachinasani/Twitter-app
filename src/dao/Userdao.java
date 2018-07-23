package dao;
import entity.Users;
import servlets.LoginServlet;

import java.sql.*;


public class Userdao {

    public static Connection getConnection(){
        Connection con=null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost/twitter","root","iphone21");

        }catch(Exception e){System.out.println(e);}
        return con;
    }
    public static int save(Users users)
    {
        int status=0;

        try {
            Connection con=Userdao.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into users (username,firstname,lastname,email,mobileno,password) values(?,?,?,?,?,?)");
            //ps.setInt(1,users.getId());
            ps.setString(1,users.getUsername());
            ps.setString(2,users.getFirstname());
            ps.setString(3,users.getLastname());
            ps.setString(4,users.getEmail());
            ps.setString(5,users.getMobileno());
          //  ps.setDate(7,users.getDOB());
            ps.setString(6,users.getPassword());
            status=ps.executeUpdate();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return status;
    }

    public static boolean getUser(String username,String password)
    {
        boolean status=false;
        try {
            Connection con=Userdao.getConnection();
            PreparedStatement ps=con.prepareStatement("select username,password,id from users where username=? and password=? ");
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            status=rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return status;

    }
    public static Users getId(String username)
    {
        Users users=new Users();
        try
        {
            Connection con=Userdao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {
                users.setId(rs.getInt(1));

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } return users;
    }

    public static int getIdd(String username)
    {
        int id=0;
        Users users=new Users();
        try
        {
            Connection con=Userdao.getConnection();
            PreparedStatement ps=con.prepareStatement("select * from users where username=?");
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next())
            {

               users.setId(rs.getInt(1));
               id=(users.getId());

            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
