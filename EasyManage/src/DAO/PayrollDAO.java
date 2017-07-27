package DAO;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import com.mysql.jdbc.PreparedStatement;

import VO.PayrollVO;
import VO.RegistrationVO;

public class PayrollDAO {

	public PayrollDAO() {
		// TODO Auto-generated constructor stub
	}
	public void generatepay(PayrollVO payroll, String managername) {
		
		try
		{
			System.out.println("into Payroll DAO");
			
			String query ="insert into payroll(username,managerid,leavereason,date,leavedays) values (?, '"+managername+"', ?, ?, ? )";
			PreparedStatement prepstate = (PreparedStatement)  dbconnect.getConnection().prepareStatement(query);
			System.out.println("into payroll database");
			prepstate.setString(1,payroll.getUsername());
		//	prepstate.setString(2,payroll.getManagerid());
			//prepstate.setInt(2,payroll.getLeavecount() );
			prepstate.setString(2, payroll.getLeavereason());
			prepstate.setString(3, payroll.getDate() );
			prepstate.setInt(4,payroll.getLeavedays());
			
			prepstate.executeUpdate();
			
			System.out.println("data entry done");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public String getmanager (RegistrationVO RegistrationVO, String username) {	
	//	String managername=null;
		 try
		    {
			 System.out.println("into get manager dao");
		      		      
		      String query = "SELECT * FROM registration where username='"+username+"'";
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			String managername= rs.getString("managername");
		      			System.out.println(managername);
		      			return managername;
		      		}
		      	
		    }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return "not found" ;
		
		
	}
		
	public String showleave(RegistrationVO RegistrationVO, String username) {	
		//	String managername=null;
			 try
			    {
				 System.out.println("into show leave payroll dao");
			      		      
			      String query = "SELECT * FROM registration where username='"+username+"'";
			      Statement st = dbconnect.getConnection().createStatement();
			      ResultSet rs = st.executeQuery(query);
			      
			      		while (rs.next())
			      		{
			      			String managername= rs.getString("managername");
			      			System.out.println(managername);
			      			return managername;
			      		}
			      	
			    }
			    
			    catch (Exception e)
			    {
			    	System.err.println(e.getMessage());
			    }
			return "not found" ;
		}
	
	
	public int  authenticateleave(RegistrationVO RegistrationVO,  String username) {	
		
		 try
		    {
			 System.out.println("into show leave payroll dao");
		      		      
		      String query = "SELECT * FROM registration where username='"+username+"'";
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			int leavecount= rs.getInt("leavecount");
		      			
		      			return leavecount;
		      		}
		      	
		    }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return 0 ;
	}
	
	public List<RegistrationVO>  authenticateleave1(RegistrationVO RegistrationVO,  String username) {	
		List<RegistrationVO> fetchUser = new ArrayList<RegistrationVO>();
		 try
		    {
			 System.out.println("into show leave payroll dao");
		      		      
		      String query = "SELECT * FROM registration ";
		      Statement st = dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			
		      			RegistrationVO assigncarry = new RegistrationVO();
		      			
		      			assigncarry.setLeavecount(rs.getInt("leavecount"));
		      			fetchUser.add(assigncarry);
		      			
		      		}
		      	
		    }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return fetchUser ;
	}
	
	public void  carryforward() {	
		
		 try
		    {
			 System.out.println("into show leave payroll dao");
		      	      
		      String query = "update registration set leavecount = leavecount +4";
		      Statement st = dbconnect.getConnection().createStatement();
		      st.executeUpdate(query);
		      
		    }
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		
	}
	
	
	public int  getleave(PayrollVO approve) {
		// TODO Auto-generated method stub
		int leaveid=0;
		
		String leaveidsession;
		 try
		    {
			 System.out.println("into show leave payroll dao");    
		     Statement st = dbconnect.getConnection().createStatement();
		    
		      System.out.println("inside if check leave id ");
			  st.executeUpdate("update payroll set status ='approve' where leaveid='"+approve.getLeaveid()+"'");
			  
			  String query = "SELECT * FROM registration where username='"+approve.getUsername()+"'";
			  
		      //Statement st =  dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		       		while (rs.next())
		      		{	
		       		
		       		int newcount= rs.getInt("leavecount")- approve.getLeavedays();
		        		
		       		 st.executeUpdate("update registration set leavecount ='"+newcount+"' where username='"+approve.getUsername()+"'");
		        	  
		      		}
			  System.out.println("updated as per "+leaveid);
			  
		    } 	
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		return 0 ;
		
	}
	
	public List<PayrollVO>employeeleave1(PayrollVO userleaves) {	
		List<PayrollVO> fetchUser = new ArrayList<PayrollVO>();
		 try
		    {
			 System.out.println("into pending leave  fech dao");
		     	      
		      String query = "SELECT * FROM payroll where managerid= '"+userleaves.getManagerid()+"' and status!='approve' " ;
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
	
	
	}
	
	