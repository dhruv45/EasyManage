package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.DirectoriesDAO;
import DAO.FetchDirectoryDAO;
import DAO.FetchuserDAO;
import DAO.RegistrationDAO;
import VO.DirectoriesVO;
import VO.PayrollVO;
import VO.RegistrationVO;

/**
 * Servlet implementation class Directory_Servlet
 */
@WebServlet("/Directory_Servlet")
public class Directory_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Directory_Servlet() {
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
		System.out.println("directory controller value of data " + data);
		String username=request.getParameter("username");
		HttpSession session=request.getSession();
		
		if(data.equals("uploadfile"))
		{		
		List<DirectoriesVO> directorylist= new ArrayList<DirectoriesVO>() ;
		DirectoriesVO directory = new DirectoriesVO();
		directory.setUsername(username);
		
		
		FetchDirectoryDAO fetch =new FetchDirectoryDAO();
		directorylist=fetch.fetchdirectories(directorylist);
		
		
		session.setAttribute("directorylist", directorylist);
		System.out.println("directorylist is :"+session.getAttribute("directorylist"));
		System.out.println("username is ::"+session.getAttribute("username"));
		response.sendRedirect("Manager/Uploadfile.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
		HttpSession session=request.getSession();
		
		String directoryname=request.getParameter("Directoryname");
		String access=request.getParameter("access");
		String username1= (String) session.getAttribute("username");
		
		DirectoriesVO directory = new DirectoriesVO();
		directory.setUsername(username1);
		directory.setDirectoryname(directoryname);
		directory.setAccess(access);
		
		RegistrationVO RegistrationVO=new RegistrationVO();
		RegistrationVO.setUsername(username1);
		
		RegistrationDAO assign= new RegistrationDAO();
		String tree=assign.getTree(RegistrationVO);
		
		directory.setTree(tree);
		 
		DirectoriesDAO directoryd= new DirectoriesDAO();
		String authenticate=directoryd.authenticatedirectory(directory);
		directoryd.makedirectory(directory);
		System.out.println("Value of authenticate"+authenticate);
		
		if(authenticate.equals("true"))
		{
			String message="Please enter different directoryname";
			System.out.println("Value of authenticate in if value of str "+message);
			request.setAttribute("message", message);
			RequestDispatcher rd=request.getRequestDispatcher("Manager/MakeDirectory.jsp");
			rd.forward(request, response);
		}
		else
		{	
						
			directoryd.makedirectory(directory);
			String message="successfully created";
			request.setAttribute("message", message);
			RequestDispatcher rd=request.getRequestDispatcher("Manager/MakeDirectory.jsp");
			rd.forward(request, response);
		}
		
		
		//response.sendRedirect("Manager/ManagerDashboard.jsp");
		
		
		
		
	}
}
