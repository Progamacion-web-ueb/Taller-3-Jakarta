package co.edu.unbosque.servlets;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
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
    private Object tableOfficial;
    private Date fecha;
    ArrayList<String> table;


    public void init() {
        table= new ArrayList<>();
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

            response.setContentType("text/html");

            String message;
            String  petName = request.getParameter("name");
            System.out.println("name: "+petName);

            String uploadPath = getServletContext().getRealPath("")+File.separator+UPLOAD_DIRECTORY;
            File uploadDir = new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdir();
            }
            String fileName="";
            String fileName1="";
            int aux=0;
            try{
                for (Part part : request.getParts()) {
                    fileName = part.getSubmittedFileName();
                    part.write(uploadPath + File.separator + fileName);
                    if(aux<1){
                        fileName1=fileName;
                    }
                    aux++;
                }
                 message= ("file "+fileName1+" has uploads sucessfully");
                request.setAttribute("message","fiel"+fileName1+"has uploads sucessfully");
            }catch (IOException fne){
                System.out.println("error catch");
                message=("There was an error "+fne.getMessage());
                request.setAttribute("message","There was an error"+fne.getMessage());
            }
        java.util.Date fecha = new Date();
        String tableOfficial= ("!"+fecha+"="+petName+"="+fileName1);

        int  valorEntero = (int) Math.floor(Math.random()*(100-1+1)+1);

        Cookie cookie1 = new Cookie(valorEntero+"",tableOfficial+"");
        response.addCookie(cookie1);

        Cookie cookie = new Cookie("request",message+"");
        cookie.setMaxAge(5);
        response.addCookie(cookie);
        PrintWriter out = response.getWriter();
        out.println("<meta http-equiv='refresh' content='1; URL=UserForm.html'>");
    }

    public void destroy() {
    }
}
