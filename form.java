import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

// Extend HttpServlet class
public class p2 extends HttpServlet {
   public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
      // Set response content type
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      String title = "Fan Network";
      String docType =
         "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
         
      out.println(docType +
         "<html>\n" +
            "<head><title>" + title + "</title></head>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<h1 align = \"center\">" + title + "</h1>\n" +
               "<ul>\n" +
                  "  <li><b>Fan Name</b>: "
                  + request.getParameter("aname") + "\n" +
                  "  <li><b>Amount</b>: "
                  + request.getParameter("pamt") + "\n" +
               "</ul>\n" +
            "</body>" +
         "</html>"
      );

      out.println(docType +
         "<html>\n" +
            "<body bgcolor = \"#f0f0f0\">\n" +
               "<ul>\n" +
                  "  <li><b>Otaku: </b>: "
                  + request.getParameter("Profit") + "\n" +
                  "  <li><b>Time Pass: </b>: "
                  + request.getParameter("loss") + "\n" +
               "</ul>\n" +
            "</body>" +
         "</html>"
      );
   }
}


