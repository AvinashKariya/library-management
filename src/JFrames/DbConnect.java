package JFrames;
import java.sql.*;
public class DbConnect {
    static Connection con = null;
    public static Connection getConnection(){
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lib_mng","root","root");
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
}
