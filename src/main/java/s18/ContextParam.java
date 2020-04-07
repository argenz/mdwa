package s18;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s18/contextParam")
public class ContextParam extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(ContextParam.class);

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.trace("called");

        String admin = this.getServletContext().getInitParameter("admin");    //ti permette di vedere il contesto della servlet, qundi la webapp in generale.  
        request.setAttribute("admin", admin);
        
        String password = this.getServletContext().getInitParameter("password");
        request.setAttribute("password", password);

        RequestDispatcher rd = request.getRequestDispatcher("/s18/contextParam.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
