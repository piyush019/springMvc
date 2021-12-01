package mvc.javaee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        //write to response using response.getWriter
        PrintWriter writer = httpServletResponse.getWriter();
//        System.out.println(httpServletRequest.getParameter("name"));
        String name = httpServletRequest.getParameter("name");
        httpServletRequest.setAttribute("name", name);
        //Route to jsp
        httpServletRequest.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(httpServletRequest, httpServletResponse);
    }

    @Override
    protected void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        String name = httpServletRequest.getParameter("name");
        httpServletRequest.setAttribute("name", name);
        String password = httpServletRequest.getParameter("password");
        httpServletRequest.setAttribute("password", password);
        UserValidation userValidation = new UserValidation();
        boolean isValid = userValidation.isValid(name, password);
        if (isValid){
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(httpServletRequest, httpServletResponse);
        } else {
            httpServletRequest.setAttribute("error", "Invalid Credentials");
            httpServletRequest.getRequestDispatcher("/WEB-INF/views/index.jsp").forward(httpServletRequest, httpServletResponse);
        }

    }
}
