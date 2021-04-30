import java.io.IOException;  
import java.io.PrintWriter;  
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;  
import javax.servlet.http.Cookie;  
import javax.servlet.http.HttpServlet;  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  

public class ContactUs extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("index.html").include(request, response);  
        
        try {
                Statement stmt;
                // Initialize the database
                Connection con = Database.initializeDatabase();
                stmt = con.createStatement();
                String nm = request.getParameter("name");                  
                String em = request.getParameter("email");
                String qr= request.getParameter("query");
                
                String st = "Insert into contact us values(" + nm + "," + em + "," + qr + ")";
       
                ResultSet rs = stmt.executeQuery(st);
                while (rs.next()) 
                {
                    String Name = rs.getString("name");
                    String Email = rs.getString("email");
                    String Query=rs.getString("query");

                   
                  
                }
        }
         
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
