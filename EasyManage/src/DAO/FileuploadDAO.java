package DAO;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import VO.FileuploadVO;


public class FileuploadDAO {

	public FileuploadDAO() {
		
	}

	public void fileupload(FileuploadVO upload) {
	
			 try
			    {
				 
			      String sql="INSERT INTO fileupload(username,directoryname, filename,file,access,tree,filetype) values(?,?,?,?,?,?,?)";
			      PreparedStatement st = dbconnect.getConnection().prepareStatement(sql);
			      
					st.setString(1, upload.getUsername());
					st.setString(2, upload.getDirectoryname());
					st.setString(3, upload.getFilename());
					st.setBlob(4, upload.getInputstream());
					st.setString(5, upload.getAccess());
					st.setString(6, upload.getTree());
					st.setString(7, upload.getFiletype());
					//st.setString(4, v1.getDes());
					
					int rs = st.executeUpdate();
			      
			      st.close();
			      }
			     
			 catch(Exception e)
			 {
				 
				 System.out.println(e);
			 }
			      
		}
		
	}


