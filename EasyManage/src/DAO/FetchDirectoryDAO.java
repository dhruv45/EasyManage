package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Part;

import com.mysql.jdbc.Blob;

import Servlet.Uploadfile;
import VO.DirectoriesVO;
import VO.FileuploadVO;
import VO.RegistrationVO;


public class FetchDirectoryDAO {

	
	public FetchDirectoryDAO() {
		// TODO Auto-generated constructor stub
	}
	public List<DirectoriesVO> fetchdirectories(List<DirectoriesVO> directorylist) {
		// TODO Auto-generated method stub
		
		List<DirectoriesVO> fetch = new ArrayList<DirectoriesVO>();
		try{
		 String query = "SELECT * FROM directories " ;
	      Statement st = dbconnect.getConnection().createStatement();
	      ResultSet rs = st.executeQuery(query);
	      
	      while (rs.next())
    		{
    			DirectoriesVO DirectoriesVO=new DirectoriesVO();
    			
    			DirectoriesVO.setDirectoryname(rs.getString("directoryname"));
    			fetch.add(DirectoriesVO);
    		}
		}
		 catch (Exception e)
	    {
	    	System.err.println(e.getMessage());
	    }
		return fetch;
	}
	
	public List<DirectoriesVO> fetchpublicdirectories(List<DirectoriesVO> directorylist) {
		// TODO Auto-generated method stub
		
		List<DirectoriesVO> fetch = new ArrayList<DirectoriesVO>();
		try{
		 String query = "SELECT * FROM directories where  " ;
	      Statement st = dbconnect.getConnection().createStatement();
	      ResultSet rs = st.executeQuery(query);
	      
	      while (rs.next())
    		{
    			DirectoriesVO DirectoriesVO=new DirectoriesVO();
    			
    			DirectoriesVO.setDirectoryname(rs.getString("directoryname"));
    			fetch.add(DirectoriesVO);
    		}
		}
		 catch (Exception e)
	    {
	    	System.err.println(e.getMessage());
	    }
		return fetch;
	}
	public static FileuploadVO Media(int viewid) throws ClassNotFoundException, SQLException {
		FileuploadVO mediainfo = new FileuploadVO();
		
		Statement st=dbconnect.getConnection().createStatement();
		ResultSet rs = st.executeQuery("select * from fileupload where fileid ='"+viewid+"'");

		while(rs.next()){
			mediainfo.setFile_id(rs.getInt("fileid"));
			mediainfo.setGetfile(rs.getBlob("file"));
			mediainfo.setFiletype(rs.getString("filetype"));
		/*mediainfo.setSerial_no(rs.getInt("serial_no"));
		mediainfo.setFile((Blob) rs.getBlob("file"));
		mediainfo.setFilename(rs.getString("filename"));
		mediainfo.setFiletype(rs.getString("filetype"));
		mediainfo.setDes(rs.getString("des"));
		mediainfo.setUser_name(rs.getString("user_name"));
		*/
		}
		st.close();
		
		return mediainfo;

		}
	public List<FileuploadVO> fetchpublic() {
		
		List<FileuploadVO> fetch = new ArrayList<FileuploadVO>();
		try{
		 String query = "SELECT * FROM fileupload where access='public'" ;
	      Statement st = dbconnect.getConnection().createStatement();
	      ResultSet rs = st.executeQuery(query);
	      
	      while (rs.next())
    		{
	    	  System.out.println("In dao from if in while fetch public");
	    	  FileuploadVO FileuploadVO=new FileuploadVO();
	    	  FileuploadVO.setFile_id(rs.getInt("fileid"));
	    	  FileuploadVO.setDirectoryname(rs.getString("directoryname"));
	    	  FileuploadVO.setFilename(rs.getString("filename"));
	    	  FileuploadVO.setGetfile(rs.getBlob("file"));

	    	  FileuploadVO.setAccess(rs.getString("access"));
	    	  fetch.add(FileuploadVO);
    		}
		}
		 catch (Exception e)
	    {
	    	System.err.println("hello"+e.getMessage());
	    	e.printStackTrace();
	    }
		System.out.println(fetch);
		return fetch;
	}

}
