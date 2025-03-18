import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBd {
    private static final String URL = "jdbc:mysql://srv1770.hstgr.io:3306/u441839449_nutricion_db";
    private static final String USER = "u441839449_nutricion_db";
    private static final String PASSWORD = "^5e~xLWe;ZGv";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
