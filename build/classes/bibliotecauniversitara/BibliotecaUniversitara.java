package bibliotecauniversitara;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BibliotecaUniversitara {
    
    private static final String user = "root";
    private static final String pws= "";
    private static final String sc = "jdbc:mysql://localhost:3306/biblioteca_universitara"; 
    
    public static Connection getConnection () throws SQLException
    {
        return (Connection) DriverManager.getConnection(sc, user, pws);
    }
    
    public static void main(String[] args) throws SQLException {
      Connection con = BibliotecaUniversitara.getConnection();
        //String sql_select = "select * from cititori";
        //Statement stmt = con.createStatement();
        //ResultSet rs = stmt.executeQuery(sql_select);
//        while (rs.next())
//        {
//            System.out.println(rs.getString(3) +" " + rs.getString(4));
//        }
        PrincipalPage f = new PrincipalPage();
        f.setVisible(true);
    }
    
}
