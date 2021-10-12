package co.edu.unbosque.servlets;
import co.edu.unbosque.dtos.User;
import co.edu.unbosque.services.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "ReadCountries", urlPatterns = {"/read"})
public class ReadCountries extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        Optional<List<User>> users = UserService.getListOfCountries();

        String templateName;
        if (users.isPresent()) {
            request.setAttribute("countries", users.get());
            templateName = "listCountries.jsp";
        } else {
            templateName = "showError.jsp";
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(templateName);
        dispatcher.forward(request, response);
    }
}
