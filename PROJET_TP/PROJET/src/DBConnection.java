import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn;

    public static Connection getInstance() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/paie",
                        "root",
                        ""
                );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
}