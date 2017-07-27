package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.FetchuserDAO;
import DAO.RegistrationDAO;
import VO.RegistrationVO;

/**
 * Servlet implementation class ManageOrgProfile_Servlet
 */
@WebServlet("/ManageOrgProfile_Servlet")
public class ManageOrgProfile_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageOrgProfile_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
				
		
		System.out.println("hii in manage profile");
		HttpSession session=request.getSession();
		String username= request.getParameter("username");
		String data= request.getParameter("data");
		
		if(data.equals("profile"))
		{
			String username1=request.getParameter("username");
			String firstname=request.getParameter("firstname");
			List<RegistrationVO> list= new ArrayList<RegistrationVO>() ;
			List<RegistrationVO> list2= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			user.setUsername(username1);
			user.setFirstname(firstname);
			FetchuserDAO fetch =new FetchuserDAO();
			list=fetch.displaymanager1(user);  
			list2=fetch.updateorgprofile1(user);
			session.setAttribute("list4", list);
			session.setAttribute("list2", list2);
			session.setAttribute("username", username);
			response.sendRedirect("Admin/ManageProfile.jsp");
		}
		
		else if(data.equals("updateprofile"))
		{
			System.out.println("profile update inside");
			String firstname=request.getParameter("firstname");
			 String updateusername=request.getParameter("username");
			 System.out.println(updateusername);
			 String updatedivision=request.getParameter("division");
			 System.out.println(updatedivision);
			 String updatemanagername=request.getParameter("listofmanager");
			 System.out.println(updatemanagername);
			 String updateposition=request.getParameter("position"); 
			 System.out.println(updateposition);
			 int updatesalary= Integer.parseInt(request.getParameter("salary")); 
			 
			 RegistrationVO update = new RegistrationVO();
			 update.setUsername(updateusername);
			 update.setDivisionname(updatedivision);
			 update.setManagername(updatemanagername);
			 update.setPosition(updateposition);
			 update.setSalary(updatesalary);
			 
			 RegistrationDAO updated = new RegistrationDAO();
			 updated.OrgProfile(update);
			 
			 // session.setAttribute("list1", list1);
				session.setAttribute("username", username);
				
				List<RegistrationVO> list2= new ArrayList<RegistrationVO>() ;
				
				RegistrationVO user = new RegistrationVO();
				//user.setFirstname("firstname");
				FetchuserDAO fetch =new FetchuserDAO();
				//list=fetch.displayinactive(user);
				list2=fetch.updateorgprofile(user);
				
				//session.setAttribute("list", list);
				session.setAttribute("list2", list2);
				String u=user.getUsername();
				//session.setAttribute("username", u);
				System.out.println("username is ::"+session.getAttribute("username"));
				//response.sendRedirect("Admin/AdminDashboard.jsp");
				System.out.println("into loginservlet if update done");
				response.sendRedirect("Admin/AdminDashboard.jsp");
				
				
				
				}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
