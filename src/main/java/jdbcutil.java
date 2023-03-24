import java.io.IOException;
import java.sql.*;


public class jdbcutil {
    private jdbcutil(){

    }
    static {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException ce)
        {
            ce.printStackTrace();

        }
    }

    public static Connection getjdbcConnection()  throws SQLException, IOException
    {

        Connection connection=null;
        String url="jdbc:mysql:///FULLSTACKJAVA";
        String username="root";
        String password="17113128@@@Uk";
        connection= DriverManager.getConnection(url,username,password);
        System.out.print("connection established");
        return connection;
    }
    public static void cleanup(Connection con, Statement statement, ResultSet resultSet) throws SQLException{
        if(con!=null)
        {
            con.close();
        }
        if(statement!=null)
        {
            statement.close();
        }

    }
}
