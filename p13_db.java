

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class p13_db1 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // out.println("<h1> into class</h1>");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/fandom", "root", "");
            if (conn != null) {
                out.println("<h1> No issues in Connection</h1>");
            }
            stmt = conn.createStatement();
            String sql;
            // display all the students' marks
            sql = "SELECT * FROM main";
            ResultSet rs = stmt.executeQuery(sql);
            // Extract data from result set
            while (rs.next()) {
                // out.println("<h1> into while loop</h1>");
                // Retrieve by column name
                String id = rs.getString("FanId");
                String name = rs.getString("Name");
                Integer age = rs.getInt("Age");
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

