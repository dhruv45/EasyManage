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
import VO.RegistrationVO;

/**
 * Servlet implementation class Payroll_Servlet
 */
@WebServlet("/Payroll_Servlet")
public class Payroll_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payroll_Servlet() {
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

		if(data.equals("checkpay"))
		{
			System.out.println("into check pay payroll servlet");
			List<RegistrationVO> pay= new ArrayList<RegistrationVO>() ;
			String username=(String) session.getAttribute("username");
			
			RegistrationVO user = new RegistrationVO();
			user.setUsername(username);
			
			RegistrationDAO payd =new RegistrationDAO();
			pay=payd.showpay(user);
			session.setAttribute("pay", pay);
			response.sendRedirect("Employee/Checkpay.jsp");
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
		
		if(data.equals("runpayroll"))
		{				
		//String username= request.getParameter("username");
		String username=(String)session.getAttribute("username");
		int paymonth= Integer.parseInt(request.getParameter("paymonth"));
		RegistrationVO RegistrationVO= new RegistrationVO();
		RegistrationVO.setPaymonth(paymonth);
		RegistrationVO.setUsername(username);
		
		RegistrationDAO month= new RegistrationDAO();
		month.insertpaymonth(RegistrationVO);
		
		
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		PayrollDAO carrycount= new PayrollDAO();
		//fetchUser = carrycount.authenticateleave1(RegistrationVO, username);
		carrycount.carryforward();
			
		String msg="pay released !";
		session.setAttribute("msg", msg);
		response.sendRedirect("Admin/AdminDashboard.jsp");
		}
		
		
		}
		
	}


