package Servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.PayrollDAO;
import DAO.RegistrationDAO;
import VO.PayrollVO;
import VO.RegistrationVO;

/**
 * Servlet implementation class Employee_Servlet
 */
@WebServlet("/Employee_Servlet")
public class Employee_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Employee_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String data = request.getParameter("data");
		
		HttpSession session=request.getSession();
		
		if (data.equals("leaverequest"))
				{
				response.sendRedirect("Employee/LeaveRequest.jsp");
				}
		
		if (data.equals("checkpay"))
		{
			String username=(String)session.getAttribute("username");
			
			RegistrationVO checkpay= new RegistrationVO();
			checkpay.setUsername(username);
			RegistrationDAO checkpayd= new RegistrationDAO();
			checkpayd.showpay(checkpay);
			
			
		}
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		String  leavedate= request.getParameter("date");
		String leavereason= request.getParameter("leavereason");
		int numberofdays = Integer.parseInt(request.getParameter("leavedays"));
		String username=(String) session.getAttribute("username");
		
		System.out.println(leavedate);
		PayrollVO payroll = new PayrollVO();
		payroll.setUsername(username);
		payroll.setLeavereason(leavereason);
		payroll.setDate(leavedate);
		payroll.setLeavedays(numberofdays);
		
		
		RegistrationVO RegistrationVO= new RegistrationVO();
		
		PayrollDAO payrolld= new PayrollDAO();
		String managername= payrolld.getmanager(RegistrationVO, username);
		
		//String managername=RegistrationVO.getManagername();
		payrolld.generatepay(payroll,managername);
		int leavedays= payrolld.authenticateleave(RegistrationVO, username);
		
		if(numberofdays>leavedays)
		{
			String msg="you dont have enough leave";
			session.setAttribute("leavemsg", msg);
			response.sendRedirect("Employee/LeaveRequest.jsp");
		}
		
		
	
	}

}
