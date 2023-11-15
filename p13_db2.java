
import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class p13_db2 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        String department = request.getParameter("course");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fandom", "root", "");
            stmt = conn.createStatement();
            String sql;
            // select data from table where dept matches the value given by user in form
            sql = "SELECT * FROM main where Recommended_Genre = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, department);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                String id = rs.getString("FanId");
                String name = rs.getString("Name");
                int age = rs.getInt("Age");
                String favo = rs.getString("Favourite_Anime");
                String genre = rs.getString("Recommended_Genre");
                // Display values
                out.println("<p> FanId: " + id + "<br>");
                out.println("Name: " + name + "<br>");
                out.println("Aget: " + age + "<br>");
                out.println("Favourite_Anime: " + favo + "<br>");
                out.println("Recommended_Genre: " + genre + "<br></p>");
            }
            out.println("</body></html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}

