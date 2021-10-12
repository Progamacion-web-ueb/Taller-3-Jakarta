package co.edu.unbosque.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet(name = "UserServlet", value = "/User-Servlet")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*5,
        maxRequestSize =1024*1024*5*5)
public class UserServlet extends HttpServlet {

    private String UPLOAD_DIRECTORY ="uploads";

    public void init() {

    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            response.setContentType("text/html");
            String message;
            System.out.println("name: "+request.getParameter("name"));
            String uploadPath = getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String fileName="";
            try{
                for (Part part : request.getParts()) {
                    fileName = part.getSubmittedFileName();
                    part.write(uploadPath + File.separator + fileName);
                }
                 message= ("file "+fileName+" has uploads sucessfully");
                request.setAttribute("message","fiel"+fileName+"has uploads sucessfully");
            }catch (IOException fne){
                System.out.println("error catch");
                message=("There was an error "+fne.getMessage());
                request.setAttribute("message","There was an error"+fne.getMessage());
            }

        Cookie cookie = new Cookie("request",message+"");
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        out.println("<meta http-equiv='refresh' content='1; URL=UserForm.html'>");
    }


    public void destroy() {
    }
}
