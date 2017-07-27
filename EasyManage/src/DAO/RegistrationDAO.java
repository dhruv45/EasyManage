package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import VO.PayrollVO;
import VO.RegistrationVO;

public class RegistrationDAO {

	public RegistrationDAO() {
		// TODO Auto-generated constructor stub
		
	}
	

	public String authentication(RegistrationVO reg) {
		// TODO Auto-generated method stub
		
		 try
		    {
		    	
			 String query = "SELECT * FROM registration";
		      Statement st =  dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		       		while (rs.next())
		      		{
		      			
		      		
		      			String username = reg.getUsername();
		      			System.out.println("username is : "+username);
		      			String password = rs.getString("password");
		      			//String firstname= rs.getString("firstname");
		      			String position= rs.getString("position");
		      			
		        	if(username.equals(rs.getString("username")))
		        	{
		        		System.out.println("username authenticated");
		        		
		        		return "true";
		        	}   
		        	
		        		
		        	}
		    }
		        	
		        	catch (Exception e)
		        	{
		        		System.err.println(e.getMessage());
		        	}
		        		return "false";
		
		      		}
		      		

	public void insert(RegistrationVO reg) {
		// TODO Auto-generated method stub
		

		try
		{
			System.out.println("into DAO");
			//Class.forName("com.mysql.jdbc.Driver");
			//Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/term?useSSL=true", "root", "root");
			
			 //String query = "SELECT * FROM registration";
		      //Statement st =  dbconnect.getConnection().createStatement();
		     // ResultSet rs = st.executeQuery();
			System.out.println("into insert Registration");
			
			String query ="insert into registration(firstname,lastname,phonenumber,email,username,password,position,address,status,managername,leavecount) values (?, ?, ?, ?, ? ,?, ?, ?, ?, ?,?)";
			PreparedStatement prepstate = (PreparedStatement)  dbconnect.getConnection().prepareStatement(query);
			System.out.println("into registration database");
			prepstate.setString(1,reg.getFirstname());
			prepstate.setString(2,reg.getLastname());
			prepstate.setString(3,reg.getPhonenumber() );
			prepstate.setString(4,reg.getEmail());
			prepstate.setString(5,reg.getUsername() );
			prepstate.setString(6,reg.getPassword());
			prepstate.setString(7,reg.getPosition());
			prepstate.setString(8,reg.getAddress());
			prepstate.setString(9, reg.getStatus());
			prepstate.setString(10,reg.getManagername());
			prepstate.setInt(11, reg.getLeavecount());
			
			prepstate.executeUpdate();
			
			System.out.println("data entry done");
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
		    
	
	
	public void changeToManager(RegistrationVO RegistrationVO){
		
		 try{
			 
			 //String query = "SELECT * FROM registration";
		      Statement st =  dbconnect.getConnection().createStatement();
		      //ResultSet rs = st.executeQuery(query);
		 //Statement st=conn.createStatement();
		 st.executeUpdate("update registration set position='manager', status ='active' where username='"+RegistrationVO.getUsername()+"'");
		 }
		 catch(Exception e){
			 System.out.println(e);
		 }
		 
	} 
		 
	 public void assignManager(RegistrationVO RegistrationVO){
				
			 try{
				// String query = "SELECT * FROM registration";
			      Statement st =  dbconnect.getConnection().createStatement();
			      
			      
			// Statement st=conn.createStatement();
			 System.out.println("My manager is "+RegistrationVO.getManagername());
			 System.out.println("My name is"+RegistrationVO.getUsername());
			 
			 st.executeUpdate("update registration set  status ='active', managername='"+RegistrationVO.getManagername()+"' where username='"+RegistrationVO.getUsername()+"'");
			 st.executeUpdate("update registration set  position='manager'  where username='"+RegistrationVO.getManagername()+"'");
			 
			 String query = "SELECT * FROM registration where username='"+RegistrationVO.getManagername()+"'";
			 ResultSet rs = st.executeQuery(query);
			 //st.executeQuery(query);
			 while(rs.next()){
			
			
			
			 String tree= rs.getString("tree");
			 System.out.println(tree);
			 String username= RegistrationVO.getUsername();
			 String finaltree=tree+"/"+username;
			 st.executeUpdate("update registration set tree= '"+finaltree+"' where username='"+RegistrationVO.getUsername()+"'");
	
			 }}
			 catch(Exception e){
				 System.out.println(e);
			 }
	}
			 
	 


	public String OrgProfile(RegistrationVO update) {
		
		String orgprofile=null;
		try{
		
		System.out.println("update org profile dao method");
			
			
		
		Statement st =  dbconnect.getConnection().createStatement();
		st.executeUpdate("update registration set divisionname='"+update.getDivisionname()+"', position='"+update.getPosition()+"',salary='"+update.getSalary()+"' where username='"+update.getUsername()+"'");
		
		   orgprofile="Profile Successfully Updated !";
		}
		 catch(Exception e){
			 System.out.println(e);
		 }
		return orgprofile;	}
	
	
public String getTree(RegistrationVO update) {
		
		String tree=null;
		try{
		
		
		Statement st =  dbconnect.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select tree from registration where username='"+update.getUsername()+"'");
		while(rs.next()){
			tree=rs.getString("tree");
		}
		  
		}
		 catch(Exception e){
			 System.out.println(e);
		 }
		return tree;	}
	
	public void addbonus(RegistrationVO bonus) {
		try{
			
		Statement st = dbconnect.getConnection().createStatement();
	    
		  String query = "SELECT * FROM registration";
	     System.out.println("inside addbonus payrollDAO");
	      ResultSet rs = st.executeQuery(query);
	      
	       		while (rs.next())
	      		{	
	       			st.executeUpdate("update registration set bonus ='"+bonus.getBonus()+"' where  username='"+bonus.getUsername()+"'");
	        	 }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		  
	    }


	public void insertpaymonth(RegistrationVO registrationVO) {
		// TODO Auto-generated method stub
		try{
		Statement st = dbconnect.getConnection().createStatement();
	    
		  String query = "SELECT * FROM registration";
	     System.out.println("inside paymonth payrollDAO");
	      ResultSet rs = st.executeQuery(query);
	      
	       		while (rs.next())
	      		{	
	       			st.executeUpdate("update registration set paymonth ='"+registrationVO.getPaymonth()+"'");
	        	 }
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}

		public List<RegistrationVO> showpay (RegistrationVO checkpay) {	
			List<RegistrationVO> getpay = new ArrayList<RegistrationVO>();
		// TODO Auto-generated method stub
		try{
			Statement st = dbconnect.getConnection().createStatement();
		    
			  String query = "SELECT * FROM registration where username='"+checkpay.getUsername()+"'";
		     System.out.println("inside paymonth payrollDAO");
		      ResultSet rs = st.executeQuery(query);
		      
		       		while (rs.next())
		      		{	
		       			RegistrationVO pay1=new RegistrationVO();
		       			
		      			pay1.setSalary(rs.getInt("salary"));
		      			pay1.setBonus(rs.getInt("bonus"));
		      			pay1.setPaymonth(rs.getInt("paymonth"));
		      			System.out.println(rs.getInt("salary")+" " +rs.getInt("bonus") +" "+rs.getInt("paymonth"));
		      			getpay.add(pay1);
		        	 }
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		return getpay;
	}

	}
