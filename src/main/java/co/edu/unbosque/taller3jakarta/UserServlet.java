package co.edu.unbosque.taller3jakarta;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "UserServlet", value = "/User-Servlet")
@MultipartConfig(
        fileSizeThreshold = 1024*1024*10,
        maxFileSize = 1024*1024*5*10,
        maxRequestSize =1024*1024*5*5*10)
public class UserServlet extends HttpServlet {

    private String UPLOAD_DIRECTORY ="uploads";

    private String message;
    public void init() {
        message = "Hello World!";
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            response.setContentType("text/html");

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
                request.setAttribute("message","fiel"+fileName+"has uploades sucessfully");
            }catch (IOException fne){
                System.out.println("eror catch");
                request.setAttribute("message","There was an error"+fne.getMessage());
            }
            //getServletContext().getRequestDispatcher("/result.jsp").forward(request,response);
    }

    public void destroy() {
    }
}
