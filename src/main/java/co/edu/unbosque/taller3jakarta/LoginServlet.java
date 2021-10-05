package co.edu.unbosque.taller3jakarta;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/Login-servlet")

public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);

        if (username.equals("admin") && password.equals("admin123")||username.equals("paco") && password.equals("paco123")) {
            response.setContentType("text/html");
            Cookie cookie = new Cookie("username","usuario");
            cookie.setMaxAge(1000);
            response.addCookie(cookie);
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            if(username.equals("admin")){
                out.println("<meta http-equiv='refresh' content='1; URL=OficialForm.html'>");
            }else if(username.equals("paco")){
                out.println("<meta http-equiv='refresh' content='1; URL=UserForm.html'>");
            }
            out.println("</body></html>");
        } else {
            response.sendError(401);
        }
    }

    public void destroy() {
    }
}