package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.FetchuserDAO;
import DAO.LoginDAO;
import DAO.RegistrationDAO;
import VO.LoginVO;
import VO.RegistrationVO;
import VO.UserVO;



/**
 * Servlet implementation class Login_Servlet
 */
@WebServlet("/Login_Servlet")
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session=request.getSession();
		String username= request.getParameter("username");
		String data = request.getParameter("data");
		String u=(String)session.getAttribute("username");
		
		if(data.equals("logout")){
			System.out.println("into loginservlet if logout");
			session.invalidate();
			response.sendRedirect("Login.jsp");
		}
		
		else if(data.equals("assign") )
		{	
			System.out.println("into loginservlet else if assign");
			List<RegistrationVO> list1= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			FetchuserDAO fetch1 =new FetchuserDAO();
			list1=fetch1.displaymanager(user);
			session.setAttribute("list1", list1);
			session.setAttribute("username", u);
			System.out.println("into loginservlet else if assign done");
			response.sendRedirect("Admin/AssignManager.jsp");
			}
		
		else if(data.equals("assign"))
		{
			
			List<RegistrationVO> list= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			FetchuserDAO fetch =new FetchuserDAO();
			list=fetch.displayinactive(user);
			session.setAttribute("list", list);
			session.setAttribute("username", u);
			
						
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username= request.getParameter("username");
		String password= request.getParameter("password");
		/*String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		*/
		System.out.println("into loginservlet");
		
		int flag = 0;
		
		
	 if(username.isEmpty() || password.isEmpty())
		{
			
			flag=1;
			session.setAttribute("error", "Please enter both username and passsword");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		
		else 
		{
			
				LoginVO loginv = new LoginVO();
				loginv.setUsername(username);
				loginv.setPassword(password);
			
				LoginDAO logind= new LoginDAO();
				String compare=logind.compare(loginv);
				
							
				if(compare.equals("invalid Username and password")){
					request.setAttribute("error", compare);
					RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
					rd.include(request, response);
				}	
				else if(compare.equals("employee"))
				{
					
					session.setAttribute("username", username);
					String u = (String) session.getAttribute("username");
					System.out.println("your username is : "+u);
					response.sendRedirect("Employee/EmployeeDashboard.jsp");
				}
				
				else if(compare.equals("manager"))
				{
					session.setAttribute("username", username);
					response.sendRedirect("Manager/ManagerDashboard.jsp");
				}
				
				else if(compare.equals("admin"))
				{
					
					List<RegistrationVO> list= new ArrayList<RegistrationVO>() ;
					List<RegistrationVO> list1= new ArrayList<RegistrationVO>() ;
					List<RegistrationVO> list2= new ArrayList<RegistrationVO>() ;
					
					
					RegistrationVO user = new RegistrationVO();
					
					FetchuserDAO fetch =new FetchuserDAO();
					list=fetch.displayinactive(user);
					list1=fetch.displaymanager(user);
					list2=fetch.updateorgprofile(user);
					
					session.setAttribute("list", list);
					session.setAttribute("list1", list1);
					session.setAttribute("list2", list2);
					String u=loginv.getUsername();
					session.setAttribute("username", u);
					System.out.println("username is ::"+session.getAttribute("username"));
					response.sendRedirect("Admin/AdminDashboard.jsp");
								
				}
				
				
		}
		
	 	
		
	}

}
