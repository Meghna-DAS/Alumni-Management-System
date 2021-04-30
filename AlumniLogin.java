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

public class AlumniLogin extends HttpServlet {  
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        request.getRequestDispatcher("link.html").include(request, response);  
        
        try {
                Statement stmt;
                // Initialize the database
                Connection con = Database.initializeDatabase();
                stmt = con.createStatement();
                String st = "select * from alumni details";
                ResultSet rs = stmt.executeQuery(st);
                while (rs.next()) {
                    String email = rs.getString("email");
                    String password = rs.getString("password");

                    String un = request.getParameter("email");                  
                    String pwd = request.getParameter("password");
                    if(email.equals(un)){
                        if(password.equals(pwd)){
                            // route to somewhere
                        }
                        
                    }
                  
                }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
        String email=request.getParameter("email");  
        String password=request.getParameter("password");  
          
        if(password.equals("admin123")){  
            out.print("You are successfully logged in!");  
            out.print("<br>Welcome, "+email);  
              
            Cookie ck=new Cookie("email",email);  
            response.addCookie(ck);  
        }else{  
            out.print("sorry, email or password error!");  
            request.getRequestDispatcher("index.html").include(request, response);  
        }  
          
        out.close();  
    }  
  
}  
