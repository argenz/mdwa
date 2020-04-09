package esercizi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dd.Coder;
import s23.DaoCoder;

//import dd.Document;
//import dd.User;

@WebServlet("/esercizi/login")  //specifica l'action del servelt
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(LoginServlet.class);
   
    @Resource(name = "jdbc/me") //Chiama la risorsa!!
    private DataSource ds;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        logger.trace("called");
        
      String username = request.getParameter("username");
      String password = request.getParameter("password");
       
      String admin = this.getServletContext().getInitParameter("admin");  
      String passwordVer = this.getServletContext().getInitParameter("password");
  
        
        if (username.equals(admin) && password.equals(passwordVer)) {
        	
        	//setAttribute (lista di bean Coder first_name, last_name, coder_id) 3+
        	// passare al jsp la lista ed inserirla in una table
        	
        	
//        	List<Coder> coders = new ArrayList<Coder>();
//        	coders.add(0, new Coder(1, "Julie", "Stewart"));
//        	coders.add(1, new Coder(2, "Anne", "Doe"));
//        	coders.add(2, new Coder(3, "Caroline", "White"));
//        	
        	DaoCoder dao = new DaoCoder(ds);
            request.setAttribute("coders", dao.getAll());
        	
   //     	request.setAttribute("coders", coders);
        	request.setAttribute("username", username);     // Parameter != Attribute, parameter cannot be called with JSP Expression Language. 
        													// Attributes are set in the servlet, before setting them there are none. 
        													// While paramters are passed but the request. 
        	
        	RequestDispatcher rd = request.getRequestDispatcher("/esercizi/welcome.jsp");
            rd.forward(request, response);
            
        }else if (username.equals(admin)){
        	RequestDispatcher rd = request.getRequestDispatcher("wrongPassword.jsp");
            rd.forward(request, response);
            
        }else if (password.equals(passwordVer)) {
        	RequestDispatcher rd = request.getRequestDispatcher("wrongUsername.jsp");
            rd.forward(request, response);
           
        }else {
        	RequestDispatcher rd = request.getRequestDispatcher("wrong.jsp");
            rd.forward(request, response);
        }
    }
    
    /* -- Metodo da programmatore C
     * 
     * boolean correct = false;
     * if(name.equals("name in database") && password.equals('password)){
     * correct = true;
     * }
     * 
     * RequestDispatcher rd = request.getRequestDispatcher(correct ? welcome.jsp : "wrong.jsp").forward(request, response);
     *  
     *  
     *  -- Aggiungi il controllo per i null altirmenti ti lancia un'eccezione:
     *  
     *  if(nam e== null || password == null) || password != "password" ){
     *  
     *  RequestDispatcher rd = request.getRequestDispatcher("wrong.jsp").forward(request, response);
     *  
     *  }
     *  
     *  Per evitare di dover fare il controllo sul null, si possono anche ribaltare i controlli: 
     *  
     *  if "Tom".equals(name) etc. così il null viene gestito naturalmente.
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}