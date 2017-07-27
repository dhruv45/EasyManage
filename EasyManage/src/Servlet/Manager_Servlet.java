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
import DAO.PayrollDAO;
import DAO.RegistrationDAO;
import VO.PayrollVO;
import VO.RegistrationVO;

/**
 * Servlet implementation class Manager_Servlet
 */
@WebServlet("/Manager_Servlet")
public class Manager_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Manager_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String data= request.getParameter("data");
		HttpSession session=request.getSession();
		//String username= request.getParameter("username");
		String u=(String)session.getAttribute("username");
		
		if(data.equals("leavemanage"))
		{
					
			System.out.println("into Manager servlet");
			List<PayrollVO> listofleave= new ArrayList<PayrollVO>() ;
			PayrollVO userleaves = new PayrollVO();
			userleaves.setManagerid(u);
			
			FetchuserDAO pendingleave =new FetchuserDAO();
			listofleave=pendingleave.employeeleave(userleaves);
			session.setAttribute("listofleave", listofleave);
			System.out.println("list size is " +listofleave.size());
	
			System.out.println("into Manager Servlet approve request");
			
			response.sendRedirect("Manager/ApproveRequest.jsp");
		}
		
		if(data.equals("approverequest"))
		{
			
			String username=request.getParameter("username");
			int leaveid = Integer.parseInt(request.getParameter("leaveid"));
			int leavedays = Integer.parseInt(request.getParameter("leavedays"));
			session.setAttribute("leaveidsession", leaveid);
			System.out.println(leaveid);
			
			PayrollVO approve = new PayrollVO();
			approve.setLeaveid(leaveid);
			approve.setUsername(username);
			approve.setLeavedays(leavedays);
			
			PayrollDAO approved= new PayrollDAO();
			int leaveId=approved.getleave(approve);
			
			List<PayrollVO> listofleave= new ArrayList<PayrollVO>() ;
			listofleave=approved.employeeleave1(approve);
			session.setAttribute("listofleave", listofleave);
			
								
			response.sendRedirect("Manager/ApproveRequest.jsp");
		}
				
		if(data.equals("declinerequest"))
		{	
			
			System.out.println("requesrt decline");
			response.sendRedirect("Manager/ApproveRequest.jsp");
		}
		
		if(data.equals("bonus"))
		{	
			System.out.println("inside Bonus assignment");
			
			String username1=(String)session.getAttribute("username");
			List<RegistrationVO> listemployeeunderme= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			user.setManagername(username1);
			
			System.out.println("printing setter value:"+ user.getManagername());
			
			FetchuserDAO fetch =new FetchuserDAO();
			listemployeeunderme=fetch.myemployee(user);
			//listemployeeunderme=fetch.employeeunderme(user);
			
			
			session.setAttribute("listemployeeunderme", listemployeeunderme);
			
			//session.setAttribute("username", u);
				
			System.out.println("Bonus assignment");
			
			response.sendRedirect("Manager/Bonus.jsp");
		}
		
		if(data.equals("addbonus"))
		{	
			System.out.println("inside addBonus assignment");
			
			String username1=(String)session.getAttribute("username");
			List<RegistrationVO> listemployeeunderme= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			user.setUsername(username1);
			
			System.out.println("printing setter value:"+ user.getManagername());
			FetchuserDAO fetch =new FetchuserDAO();
			listemployeeunderme=fetch.myemployeebonus(user);
			//listemployeeunderme=fetch.employeeunderme(user);
					
			session.setAttribute("listemployeeunderme", listemployeeunderme);
			
			//session.setAttribute("username", u);
				
			System.out.println("Bonus assignment");
			
			response.sendRedirect("Manager/AddBonus.jsp");
		}
		
		
		
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		String data= request.getParameter("data");
		HttpSession session=request.getSession();
		//String username= request.getParameter("username");
		String username=(String)session.getAttribute("username");
		
		if(data.equals("bonusdone"))
		{	
			System.out.println("inside addBonus assignment");
			int bonusamount= Integer.parseInt(request.getParameter("bonus"));
			
		//	String username2= request.getParameter(username);
			RegistrationVO bonus= new RegistrationVO();
			bonus.setBonus(bonusamount);
			//bonus.setManagername(managername);
			bonus.setUsername(username);
			
			RegistrationDAO bonusd= new RegistrationDAO ();
			bonusd.addbonus(bonus);
			response.sendRedirect("Manager/AddBonus.jsp");
		}
		
	}

}
