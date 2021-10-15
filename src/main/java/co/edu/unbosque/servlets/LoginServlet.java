package co.edu.unbosque.servlets;

import co.edu.unbosque.dtos.User;
import co.edu.unbosque.services.UserService;

import java.io.*;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "loginServlet", value = "/Login-servlet")

public class LoginServlet extends HttpServlet {
    private String message;

    public void init() {
         //UserDTO dto = new UserDTO();
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        String passwordRqt = request.getParameter("password");

        response.setContentType("text/html");

        Optional<List<User>> users = UserService.getListOfCountries();
        int aux=0;
        int tamaño=7;
        for(int i=0;i<tamaño;i++){
            String passwordDb=users.get().get(i).getPassword();
            String emailDb=users.get().get(i).getEmail();
            int roleDb=users.get().get(i).getRole();

            if (username.equals(emailDb) && passwordRqt.equals(passwordDb)) {
                aux++;
                response.setContentType("text/html");
                Cookie cookieE = new Cookie("username",emailDb);
                cookieE.setMaxAge(3600);
                Cookie cookieP = new Cookie("password",passwordDb);
                cookieP.setMaxAge(3600);
                Cookie cookieR = new Cookie("role",(roleDb+""));
                cookieR.setMaxAge(3600);
                response.addCookie(cookieE);
                response.addCookie(cookieP);
                response.addCookie(cookieR);
                System.out.println("cookie content"+ cookieE.getValue());
                PrintWriter out = response.getWriter();
                out.println("<html><body>");
                if(roleDb==1){
                    out.println("<meta http-equiv='refresh' content='1; URL=UserForm.html'>");
                }else if(roleDb==2){
                    out.println("<meta http-equiv='refresh' content='1; URL=OficialForm.html'>");
                }
                out.println("</body></html>");
            }
        }
        if(aux==0){
            response.sendError(401);
        }

    }

    public void destroy() {
    }
}