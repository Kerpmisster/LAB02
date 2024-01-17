package devmaster.edu.vn.servlet.lab02;
import java.sql.*;
public class ConnectSQL {
    public static Connection getMSSQLConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        String hostName = "LAPTOP-SSHUBNQA"; // Địa chỉ IP hoặc tên máy chủ của SQL Server.
        String sqlInstanceName = "SQLEXPRESS"; // Địa chỉ IP hoặc tên máy chủ của SQL Server.
        String dbName = "UserManage"; //Tên cơ sở dữ liệu bạn muốn kết nối.
        String userName = "sa"; //Tên đăng nhập SQL Server.
        String password = "123456"; //Mật khẩu đăng nhập SQL Server.

        String connectionURL = "jdbc:sqlserver://" + hostName + ":1433;instance=" + sqlInstanceName + ";databaseName="+ dbName;
        Connection conn = DriverManager.getConnection(connectionURL, userName, password);

        return conn;

    }
}
