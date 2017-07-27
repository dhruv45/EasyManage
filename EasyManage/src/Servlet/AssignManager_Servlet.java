package Servlet;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.DirectoriesDAO;
import DAO.RegistrationDAO;
import VO.DirectoriesVO;
import VO.RegistrationVO;

/**
 * Servlet implementation class AssignManager_Servlet
 */
@WebServlet("/AssignManager_Servlet")
public class AssignManager_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignManager_Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String employee = request.getParameter("inactiveemployee");
		String manager = request.getParameter("listofmanager");
		
		RegistrationVO RegistrationVO= new RegistrationVO();
		RegistrationVO.setManagername(manager);
		RegistrationVO.setUsername(employee);
		
		RegistrationDAO assign= new RegistrationDAO();
		assign.assignManager(RegistrationVO);
		//assign.tree(RegistrationVO);
		
		
		RequestDispatcher rd=request.getRequestDispatcher("Admin/AssignManager.jsp");
		rd.forward(request, response);
	}
	
	

}
