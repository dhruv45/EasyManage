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
import DAO.RegistrationDAO;

import VO.RegistrationVO;

/**
 * Servlet implementation class Registration_Servlet
 */
@WebServlet("/Registration_Servlet")
public class Registration_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Registration_Servlet() {
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
		String data=request.getParameter("data");
		if(data.equals("changeManager")){
			
			String username=request.getParameter("username");
			
			RegistrationVO RegistrationVO=new RegistrationVO();
			RegistrationVO.setUsername(username);
			
			RegistrationDAO RegistrationDAO=new RegistrationDAO();
			RegistrationDAO.changeToManager(RegistrationVO);
			
			List<RegistrationVO> list= new ArrayList<RegistrationVO>() ;
			RegistrationVO user = new RegistrationVO();
			
			FetchuserDAO fetch =new FetchuserDAO();
			list=fetch.displayinactive(user);
			session.setAttribute("list", list);
			session.setAttribute("username", username);
			System.out.println("inside fetchuser registration servlet" +session.getAttribute(username));
			response.sendRedirect("Admin/AdminDashboard.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String phoneNumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String position = request.getParameter("position");
		String address= request.getParameter("address");
		String status= request.getParameter("status");
		String managername= request.getParameter("managername");
		int leavecount= 4;
		RegistrationVO reg=new RegistrationVO();
		
		reg.setFirstname(firstName);
		reg.setLastname(lastName);
		reg.setPhonenumber(phoneNumber);
		reg.setEmail(email);
		reg.setUsername(username);
		reg.setPassword(password);
		reg.setPosition(position);
		reg.setAddress(address);
		reg.setStatus(status);
		reg.setManagername(managername);
		reg.setLeavecount(leavecount);
		
		
		
		int flag = 0;

		Pattern pattern, pattern1 ,pattern2;
		Matcher matcher, matcher1 ,matcher2;

		String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		String ID_PATTERN = "[0-9]+";
		String S_PATTERN = "[a-zA-Z]+";
		//pattern = Pattern.compile(ID_PATTERN);
		//matcher = pattern.matcher(username);
	    pattern1= Pattern.compile(EMAIL_PATTERN);
		matcher1 = pattern1.matcher(email);
		pattern2 = Pattern.compile(ID_PATTERN);
		matcher2 = pattern2.matcher(phoneNumber);	
		
		 System.out.println("hi");
		if (firstName.isEmpty() || lastName.isEmpty() || firstName.trim().length()<=0 || lastName.trim().length()<=0) {
			flag = 1;
			request.setAttribute("error", "please provide your all details");
		}
	    else if (phoneNumber.isEmpty()) {
				flag = 1;
				request.setAttribute("error", "phone number is mandatory");
			}
	    else if (!matcher2.matches()) {
			flag = 1;
			request.setAttribute("error", "phonenumber must be numeric");
		}
		
	    else if (email.isEmpty()) {
			flag = 1;
			request.setAttribute("error", "email id number is mandatory");
		}
		
	    else if (!matcher1.matches()) {
	    	flag = 1;
	    	request.setAttribute("error", "email id must be proper form");
	    }
       else if (username.isEmpty()) {
			flag = 1;
			request.setAttribute("error", "username is mandatory");
		}
		
       else if (password.isEmpty()) {
			flag = 1;
			request.setAttribute("error", "password is manadatory");
		}
		
		if (flag == 1) {
		
			RequestDispatcher rd = request.getRequestDispatcher("Registration.jsp");
			rd.include(request, response);
		} 
		
		
		else {
			System.out.println("complete REG");
			request.setAttribute("firstname", firstName);
			request.setAttribute("lastname", lastName);
			request.setAttribute("username", username);
			System.out.println("registration servlet "+ request.getAttribute(username)); 
			RegistrationDAO regd = new RegistrationDAO();
			String authentication=regd.authentication(reg);
			if(authentication.equals("true"))
			{
				String message="Username has already been taken,Please enter different username";
				request.setAttribute("message", message);
				RequestDispatcher rd=request.getRequestDispatcher("Registration.jsp");
				rd.forward(request, response);
			}
			
			if(authentication.equals("false"))
			{
			
				
				
				regd.insert(reg);
				RequestDispatcher rd=request.getRequestDispatcher("Login.jsp");
				rd.forward(request, response);
			}
			
			}
			
					}
			

	}


