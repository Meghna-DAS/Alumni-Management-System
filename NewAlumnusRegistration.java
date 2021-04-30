/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NewAlumnusRegistration extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  
        throws ServletException, IOException {  
            response.setContentType("text/html");  
            PrintWriter out=response.getWriter();  
              
            request.getRequestDispatcher("AlumniLogin.html").include(request, response);  
              
            try {
                Connection con = Database.initializeDatabase();
                
                PreparedStatement st;
                st = con.prepareStatement("Insert into alumni details");
               
               

                st.setString(1, request.getParameter("name"));
                st.setString(2, request.getParameter("email"));
                st.setString(3, request.getParameter("course"));
                st.setString(4, request.getParameter("branch"));
                st.setString(5, request.getParameter("PRN"));
                st.setString(6, request.getParameter("organization"));
                st.setString(7, request.getParameter("designation"));
                st.setString(8, request.getParameter("password"));

                st.executeUpdate();
            }
            
            catch (Exception e) {
                e.printStackTrace();
            }  
            
            out.close();
        }
    }