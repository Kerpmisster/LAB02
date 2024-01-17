package devmaster.edu.vn.servlet.lab02;

import java.sql.*;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SearchAccount", value = "/search-account")
public class SearchAccount extends HttpServlet {
    public SearchAccount() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String phone = req.getParameter("phone");
        out.println("<html><head><meta charset='UTF-8'><title>InputForm</title> </head>");
        out.println("<body style='text-align:center'>"); out.println("<h1> SEARCH RESULTS </h1>");
        out.println("<form action='search-account' method='post'>");
        out.println("<p> Input phone: ");
        out.println("<input type=text name='phone' value='" + phone + "'/>");
        out.println("<p> <input type='submit' value='Search' />");
        out.println("</form>");
        try {
            String sql = "SELECT * FROM USER_ACCOUNT ";
            if(phone!=null && phone.length()!=0)
                sql +=" WHERE CusPhone like '%" + phone +"%'";
            Connection conn = ConnectSQL.getMSSQLConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            out.println("<h2> List</h2>");
            out.println("<table border=1 align='center' style='width:100%'>");
            out.println("<tr><th>User</th><th>Name</t ><th>Phone</th><tr>");
            if (rs != null) {
                while (rs.next()) {
                    out.println("<tr>");
                    out.println("<td>" + rs.getString("CusUser") + "</td>");
                    out.println("<td>" + rs.getString("CusName") + "</td>");
                    out.println("<td>" + rs.getString("CusPhone") + "</td>");
                    out.println("</tr>");
                }
            }
            rs.close();
            conn.close();
            out.println("</table>");

        } catch (Exception ex) {
            out.println("<h1>" + ex.getMessage() + " </h1>");
            out.println("<p>" + ex.toString() + " </p>");
        }
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    public void init(ServletConfig config) throws ServletException {

    }
}
