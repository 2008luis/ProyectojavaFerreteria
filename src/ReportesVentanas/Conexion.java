package ReportesVentanas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
      String url = "jdbc:mysql://localhost:3306/Ferreteria";
    String user= "root";
    String pass= "camilo122002";

    public Conexion() {
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }
    
     public Connection obtenerConexion() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}