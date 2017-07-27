package DAO;
import DAO.dbconnect;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import VO.PayrollVO;
import VO.RegistrationVO;
import VO.UserVO;

public class FetchuserDAO {

	
	public FetchuserDAO() {
		// TODO Auto-generated constructor stub
	}

	public List<RegistrationVO> displayinactive(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into start fech dao");
		      
		      
		      String query = "SELECT * FROM registration where position = 'employee' and status='inactive'";
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername("managername");
		      			RegistrationVO2.setPosition("position");
		      			RegistrationVO2.setDivisionname("divisionname");
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      	
		    }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	
	public List<RegistrationVO> displaymanager(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into start active user fech dao");
		      
		      
		      String query = "SELECT * FROM registration where position!= 'admin' and status='active'" ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	public List<RegistrationVO> displaymanager1(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into start active user fech dao");
		      
		      
		      String query = "SELECT * FROM registration where username='"+RegistrationVO.getUsername()+"'" ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	public List<RegistrationVO> updateorgprofile(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into start active user fech dao");
		      
		      
		      String query = "SELECT * FROM registration where position!= 'admin' and firstname!= '"+RegistrationVO.getFirstname()+"'  and status='active'" ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			RegistrationVO2.setSalary(rs.getInt("salary"));
		      			
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	
	public List<RegistrationVO> updateorgprofile1(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into start active user fech dao");
		      
		      
		      String query = "SELECT * FROM registration where position!= 'admin' and firstname!= '"+RegistrationVO.getFirstname()+"'  and status='active'" ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	
	public List<RegistrationVO> employeeunderme(RegistrationVO RegistrationVO) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into employee under me  fech dao");
		      
		      
		      String query = "SELECT * FROM registration where position!= 'admin' and firstname!= '"+RegistrationVO.getFirstname()+"'  and status='active'" ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			RegistrationVO2.setEmail(rs.getString("email"));
		      			RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	
	
	public List<PayrollVO>employeeleave(PayrollVO userleaves) {	
		List<PayrollVO> fetchUser = new ArrayList<PayrollVO>();
		 try
		    {
			 System.out.println("into pending leave  fech dao");
		     	      
		      String query = "SELECT * FROM payroll where managerid= '"+userleaves.getManagerid()+"' and status='pending' " ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			PayrollVO employee_leave=new PayrollVO();
		      			
		      			employee_leave.setUsername(rs.getString("username"));
		      			employee_leave.setManagerid(rs.getString("managerid"));
		      			//employee_leave.setLeavecount(rs.getInt("leavecount"));
		      			employee_leave.setLeavereason(rs.getString("leavereason"));
		      			employee_leave.setDate(rs.getString("date"));
		      			employee_leave.setLeavedays(rs.getInt("leavedays"));
		      			employee_leave.setLeaveid(rs.getInt("leaveid"));
		      			
		      			fetchUser.add(employee_leave);
		      			
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}

	public List<RegistrationVO> myemployee(RegistrationVO user) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into myemployee fech dao");
		      
		      
		      String query = "SELECT * FROM registration where managername= '"+user.getManagername()+"'  " ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			//RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			//RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			//RegistrationVO2.setEmail(rs.getString("email"));
		      			//RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			//RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			System.out.println("fetch done got my employee");
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
	
	public List<RegistrationVO> myemployeebonus(RegistrationVO user) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into myemployee fech dao");
		      
		      
		      String query = "SELECT * FROM registration where username= '"+user.getUsername()+"'  " ;
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			RegistrationVO RegistrationVO2=new RegistrationVO();
		      			
		      			RegistrationVO2.setFirstname(rs.getString("firstname"));
		      			RegistrationVO2.setLastname(rs.getString("lastname"));
		      			//RegistrationVO2.setPhonenumber(rs.getString("phonenumber"));
		      			//RegistrationVO2.setAddress(rs.getString("address"));
		      			RegistrationVO2.setUsername(rs.getString("username"));
		      			//RegistrationVO2.setEmail(rs.getString("email"));
		      			//RegistrationVO2.setStatus(rs.getString("status"));
		      			RegistrationVO2.setManagername(rs.getString("managername"));
		      			RegistrationVO2.setPosition(rs.getString("position"));
		      			//RegistrationVO2.setDivisionname(rs.getString("divisionname"));
		      			fetchUser.add(RegistrationVO2);
		      			System.out.println("fetch done got my employee");
		      		}
		      }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser;
		
	}
}
