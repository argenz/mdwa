package s10;

import java.io.IOException;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/s10/checker")
public class Checker extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(Checker.class);
    //si usano solo risorse statiche, se si usano di istanza bisogna fare molta attenzione.

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        logger.trace("called for user [" + user + "]");

        Set<Character> set = new TreeSet<>();
        if (user != null) {
            for (char c : user.toCharArray()) {
                set.add(Character.toLowerCase(c));
            }
        }
        request.setAttribute("set", set); //si piazza nella request l'attributo set, per "salvare" il lavoro fatto finora nel codice java

        RequestDispatcher rd = request.getRequestDispatcher("/s10/checker.jsp"); //metodo che dice a tomcat di chiamare la risorsa per completare la gestione della request. 
        rd.forward(request, response); //che gli passa la request. 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
