package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import VO.DirectoriesVO;
import VO.RegistrationVO;

public class DirectoriesDAO {

	public DirectoriesDAO() {
		// TODO Auto-generated constructor stub
	}


	public void makedirectory(DirectoriesVO directory) {
		
		
		
		try {
			String query ="insert into directories(username,directoryname,access,tree) values (?, ?, ? ,?)";
			
			PreparedStatement prepstate;
			prepstate = (PreparedStatement)  dbconnect.getConnection().prepareStatement(query);
			
			System.out.println("into directories table");
			prepstate.setString(1,directory.getUsername());
			prepstate.setString(2,directory.getDirectoryname());
			prepstate.setString(3,directory.getAccess());
			prepstate.setString(4,directory.getTree());
			prepstate.executeUpdate();
			//prepstate.setString(4,reg.getEmail());
			System.out.println("directory made successfully !");
			} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public void maketree(RegistrationVO RegistrationVO){
		
		 try{
			 Statement st =  dbconnect.getConnection().createStatement();
		
			 String query = "SELECT * FROM registration where username='"+RegistrationVO.getManagername()+"'";
			 ResultSet rs = st.executeQuery(query);
		 
		 
		 }
		 
	
		 catch(Exception e){
			 System.out.println(e);
		 }
}


	public String authenticatedirectory(DirectoriesVO directory) {
		
			try
			    {
			    	
				 String query = "SELECT * FROM directories";
				 System.out.println("in authenticate dao");
			      Statement st =  dbconnect.getConnection().createStatement();
			      ResultSet rs = st.executeQuery(query);
			      
			       		while (rs.next())
			      		{     			
			      		
			      			String directoryname = directory.getDirectoryname();
			      			
			        	if(directoryname.equals(rs.getString("directoryname")))
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


	public String getpublicfile(DirectoriesVO publicdirectory) {
		// TODO Auto-generated method stub
		return null;
	}


	public String gettreeinfileupload(DirectoriesVO directory) {
		// TODO Auto-generated method stub
		
		String tree=null;
		try{
		
		
		Statement st =  dbconnect.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select tree from directories where directoryname='"+directory.getDirectoryname()+"'");
		while(rs.next())
		{
			tree=rs.getString("tree");
		}
		  
		}
		 catch(Exception e){
			 System.out.println(e);
		 }
		
		System.out.println("inside directories DAO" +tree);
		return tree;
}


	public String getaccessinfileupload(DirectoriesVO directory) {
		// TODO Auto-generated method stub
		
		String access=null;
		try{
		
		
		Statement st =  dbconnect.getConnection().createStatement();
		ResultSet rs=st.executeQuery("select access from directories where directoryname='"+directory.getDirectoryname()+"'");
		while(rs.next())
			{
			
			access=rs.getString("access");
			}
		  
		}
		 catch(Exception e){
			 System.out.println(e);
		 }
		System.out.println("inside directories DAO" +access);
		return access;
		
	}
		
		
	}
		 

