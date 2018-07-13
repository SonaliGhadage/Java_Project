package MyProj.identity.mgmt.datamodel;
//import MyProj.identity.mgmt.services.IdentityDAO;
//import MyProj.identity.mgmt.datamodel.Identity; 
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
/*
 * This servlet acts as a page controller for the application, handling all the actions
 */
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;
   private IdentityDAO identityDAO;
    
   public void init() {
       String jdbcURL = getServletContext().getInitParameter("jdbcURL");
       String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
       String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
        identityDAO = new IdentityDAO(jdbcURL, jdbcUsername, jdbcPassword);
       
    }
 
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        
        try {
            switch (action) {
            case "/loginsuccess":
            	Loginsuccess(request, response);
            	System.out.println("===========loginsuccess");
                
                break;
            case "/new":
            	System.out.println("===========new2");
                newIdentityForm(request, response);
                break;
            case "/insert":
                insertIdentity(request, response);
                break;
            case "/delete":
                deleteIdentity(request, response);
                break;
            case "/edit":
            	System.out.println("===========edit");
                showEditForm(request, response);
                break;
            case "/update":
            	System.out.println("===========update");
                updateIdentity(request, response);
                break; 
            case "/list":
            	System.out.println("===========list");
            	listIdentity(request, response);
                break; 
            case "/searchID":
            	System.out.println("===========search");
                searchForm(request, response);
                break; 
                
            case "/search":
            	System.out.println("hello");
                
            	searchIdentity(request, response);
                break; 
                
            
            default:
            	System.out.println("===========login");
                Loginpage(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
 
    
    private void Loginpage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	  		RequestDispatcher dispatcher = request.getRequestDispatcher("LoginPage.jsp");
    	      dispatcher.forward(request, response);
    	       }
    private void Loginsuccess(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
    	 String uname = request.getParameter("un");
         String passw = request.getParameter("pw");
        Identity identityup = new Identity();
        identityup.setUsr_name(uname);
        identityup.setPass(passw);
        boolean isValisUser = identityDAO.loginIdentity(identityup);

        System.out.println("===========isValisUser : "+isValisUser);
        if(isValisUser) {
        	response.sendRedirect("list");
        }
        else {
        	RequestDispatcher dispatcher = request.getRequestDispatcher("LoginError.jsp");
            dispatcher.forward(request, response);
        }
        
           }
    		        
    		        
    	   
    private void listIdentity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Identity> listIdentity = identityDAO.listAllIdentites();
        request.setAttribute("listIdentity", listIdentity);
        System.out.println("===========listbook");
        RequestDispatcher dispatcher = request.getRequestDispatcher("IdentityList.jsp");
        dispatcher.forward(request, response);
    }
 
   private void newIdentityForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("IdentityForm.jsp");
        dispatcher.forward(request, response);
    }
 
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    //	System.out.println("===========showEditForm .."+request.getParameter("USER_ID"));
        int id = Integer.parseInt(request.getParameter("USER_ID"));

    //	System.out.println("===========showEditForm1 .."+id);
        Identity existingIdentity = identityDAO.getIdentity(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("IdentityForm.jsp");
        request.setAttribute("IDEN", existingIdentity);
        dispatcher.forward(request, response);
 
    }
 
    private void insertIdentity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
    	 int id = Integer.parseInt(request.getParameter("USER_ID"));
         String Name = request.getParameter("NAME");
        String Email_id = request.getParameter("EMAIL_ID");
       
        Identity newIdentity = new Identity(id, Name, Email_id);
        identityDAO.insertIdentity(newIdentity);
        response.sendRedirect("list");
    }
 
    private void updateIdentity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("USER_ID"));
        String Name = request.getParameter("NAME");
        String Email_id = request.getParameter("EMAIL_ID");
        
        Identity identityupdate = new Identity(id, Name, Email_id);
        identityDAO.updateIdentity(identityupdate);
        response.sendRedirect("list");
    }
 
    private void deleteIdentity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("USER_ID"));
 
        Identity identitydel = new Identity(id);
        identityDAO.deleteIdentity(identitydel);
        response.sendRedirect("list");
 
    }
    
    private void searchForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	
        RequestDispatcher dispatcher = request.getRequestDispatcher("SearchIden.jsp");
        dispatcher.forward(request, response);
        
        
    }
    
    private void searchIdentity(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
    	int id = Integer.parseInt(request.getParameter("USER_ID"));
    	// Identity identitysear = new Identity(id);
    	List<Identity> listIdentity = new ArrayList<>();
    	Identity searchedIdentity = identityDAO.searchIdentity(id);
    	listIdentity.add(searchedIdentity);
        request.setAttribute("listIdentity", listIdentity);
        System.out.println("===========listbook");
        RequestDispatcher dispatcher = request.getRequestDispatcher("IdentityList.jsp");
        dispatcher.forward(request, response);
        
        
        
          //response.sendRedirect("list");
    }
}