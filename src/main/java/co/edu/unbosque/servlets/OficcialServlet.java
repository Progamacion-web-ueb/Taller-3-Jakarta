package co.edu.unbosque.servlets;

import co.edu.unbosque.dtos.User;
import co.edu.unbosque.services.UserService;
import org.json.JSONObject;

import java.io.*;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "oficcialServlet", value = "/oficcial-servlet")

public class OficcialServlet extends HttpServlet{

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        JSONObject myObject = new JSONObject();
        myObject.put("name", "Carlos");
        myObject.put("last_name", "Carlos");
        for(int i=0;i<7;i++){
            Optional<List<User>> users = UserService.getListOfCountries();
            String a=users.get().get(i).getPassword();
            String emailDb=users.get().get(i).getEmail();
            int roleDb=users.get().get(i).getRole();
            myObject.put("email", "Carlos");
            myObject.put("last_name", "Carlos");
        }

        out.println(myObject);
    }
}
