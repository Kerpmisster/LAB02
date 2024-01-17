package devmaster.edu.vn.servlet.lab02;
import java.sql.*;
public class TestConnect {
    public static void main(String[] args)
            throws ClassNotFoundException, SQLException {
        System.out.println("Get connection ... ");
        // Lấy ra đối tượng Connection kết nối vào database.
        Connection conn = ConnectSQL.getMSSQLConnection();
        System.out.println(conn + "èunifis");
        System.out.println("Done!");
    }
}
