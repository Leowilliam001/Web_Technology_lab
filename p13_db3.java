

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class p13_db3 extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        Connection conn = null;
        Statement stmt = null;
        PrintWriter out = response.getWriter();
        // String department = request.getParameter("course");
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // create a database connection using jdbc , port no used here is 3306
            // database name is college and username is root , there is no password
            conn = DriverManager.getConnection(
                    "conn = DriverManager.getConnection(\"jdbc:mysql://localhost:3306/fandom",
                    "root", "");
            stmt = conn.createStatement();
            PreparedStatement pstmt = conn.prepareStatement("insert into main values(?, ?, ?, ?, ?)");
            pstmt.setInt(1, Integer.valueOf(request.getParameter("FanId")));
            // Same for second parameter
            pstmt.setString(2, request.getParameter("Name"));
            pstmt.setInt(3, Integer.valueOf(request.getParameter("Age")));
            pstmt.setString(4, request.getParameter("Favourite_Anime"));
            pstmt.setString(5, request.getParameter("Recommended_Genre"));
            // Execute the insert command using executeUpdate()
            // to make changes in database
            pstmt.executeUpdate();
            out.println("<html><body><p> Database Updated</p>");
            // select data from table where dept matches the value given by user in form
            String sql = "SELECT * FROM main";
            pstmt = conn.prepareStatement(sql);
            // pstmt.setString(1, department);
            ResultSet rs = pstmt.executeQuery();
            // Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int fid = rs.getInt("FanId");
                String fname = rs.getString("Name");
                int fage = rs.getInt("Age");
                String ffav = rs.getString("Favourite_Anime");
                String frec = rs.getString("Recommended_Genre");

                // Display values
                out.println("<p> FanID: " + fid + "<br>");
                out.println("Name: " + fname + "<br>");
                out.println("Nge: " + fage + "<br>");
                out.println("Name: " + ffav + "<br>");
                out.println("Number of Students: " + frec + "<br></p>");
            }
            out.println("</body> Successful </html>");
            // Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.out.print("Do not connect to DB - Error:" + e);
        }
    }
}

