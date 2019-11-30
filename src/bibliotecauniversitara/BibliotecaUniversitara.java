package bibliotecauniversitara;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BibliotecaUniversitara {
    
    //dates for connecting at data base
    private static final String user = "root";
    private static final String pws= "";
    private static final String sc = "jdbc:mysql://localhost:3306/biblioteca_universitara"; 
    
    public static Connection getConnection () throws SQLException
    { //function for connecting at data base
        return (Connection) DriverManager.getConnection(sc, user, pws);
    }
    
    public static void main(String[] args) throws SQLException {
      Connection con = BibliotecaUniversitara.getConnection();
      //principal page
        PrincipalPage f = new PrincipalPage();
        f.setVisible(true);
    }
    
}
