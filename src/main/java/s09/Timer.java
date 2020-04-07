package s09;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s09/timer")    //annotazione che serve a localizzare la servlet che deve rispondere alla request che specifica "/s09/timer"
							 //è convenzione chimarla uguale alle risorse dinamiche. 

public class Timer extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Timer.class);  //utilizzo logger 

    //servlet,è una classe java che estende la classe HTTPservlet che serve a gestire i metodi di request e response 
    //Per leggere le request e fare le responses.
    //Tomcat legge la request e la trasforma in un oggetto HttpServlet Java
    //Che viene poi mandata dove speficicato secondo l'annotazione
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)  // implementa la get
            throws ServletException, IOException {
        logger.trace("called");								
        
        response.setContentType("text/html");               //spiega il tipo della response.
        response.setCharacterEncoding("utf-8");
        try (PrintWriter writer = response.getWriter()) {   //creates a document, html page. 
        													//PrintWriter allows to write lines in a document.
            writer.println("<!DOCTYPE html><html>");
            writer.println("<head><meta charset=\"utf-8\">");
            writer.println("<title>Hello Servlet</title></head>");
            writer.println("<body>");
            writer.println("<h1>" + LocalTime.now() + "</h1>");
            writer.println("<a href=\"..\">" + "back home" + "</a>");  // \" è per mettere davvero un doppio apice nella stringa, .. directory precendete, index 
            writer.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)// implementa la post come la get
            throws ServletException, IOException {
        doGet(request, response);							
    }
}
