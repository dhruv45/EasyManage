package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.http.HttpSession;

import VO.LoginVO;
import VO.RegistrationVO;


public class LoginDAO {

	public String compare(LoginVO loginv) {
		String result = null;
		    try
		    {
		    	
		      
		      
		      String query = "SELECT * FROM registration";
		      Statement st =  dbconnect.getConnection().createStatement();
		      ResultSet rs = st.executeQuery(query);
		      
		      		while (rs.next())
		      		{
		      			
		      			String username = rs.getString("username");
		      			String password = rs.getString("password");
		      			//String firstname= rs.getString("firstname");
		      			String position= rs.getString("position");
		      			
		        	if(username.equals(loginv.getUsername()) && password.equals(loginv.getPassword()))
		        	{
		        		System.out.println("Your position is " +position);
		        		return position;
		        	}
		        
		        	else
		        	{
		        		result= "Invalid Username or Password !";
		      		}
		      		}
		      		
		    		}
		    
		    catch (Exception e)
		    {
		    	System.err.println(e.getMessage());
		    }
		    
		    return result;
		  }
		
	}

