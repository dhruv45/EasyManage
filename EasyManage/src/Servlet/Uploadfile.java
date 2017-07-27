package Servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import javax.swing.text.html.HTML;

import DAO.DirectoriesDAO;
import DAO.FetchDirectoryDAO;
import DAO.FileuploadDAO;
import VO.DirectoriesVO;
import VO.FileuploadVO;

/**
 * Servlet implementation class Uploadfile
 */
@WebServlet("/Uploadfile")
@MultipartConfig(maxFileSize=1024*1024*5)
public class Uploadfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Uploadfile() {
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
		String username= (String) session.getAttribute("username");
		
		if(data.equals("public"))
		{
			System.out.println("trying to fetch public directories!");
			
			List<DirectoriesVO> publiclist= new ArrayList<DirectoriesVO>() ;
			FileuploadVO publicfile = new FileuploadVO();
			publicfile.setUsername(username);
			
			
			
			FetchDirectoryDAO fetch =new FetchDirectoryDAO();
			List publicfetch=fetch.fetchpublic();
			
			
			session.setAttribute("publicfetch", publicfetch);
			System.out.println("directorylist is in post if:"+session.getAttribute("publicfetch"));
			System.out.println("username is ::"+session.getAttribute("username"));
			response.sendRedirect("Viewdirectories.jsp");
			
			
			
		}
		
	/*	
		if(data.equals("private"))
		{
			System.out.println("trying to fetch private directories!");
			//List<DirectoriesVO> privatelist= new ArrayList<DirectoriesVO>() ;
			FileuploadVO privatefile = new FileuploadVO();
			privatefile.setUsername(username);
			
			DirectoriesVO privatedirectory= new DirectoriesVO();
			privatedirectory.setUsername(username);
			
			
			DirectoriesDAO privatefiled= new DirectoriesDAO();
		//	String file=privatefiled.getprivatefile(privatedirectory);
		//	privatefile.setAccess(file);
			
		}
		
		
		if(data.equals("protected"))
		{
			System.out.println("trying to fetch protected directories!");
			//List<DirectoriesVO> protectedlist= new ArrayList<DirectoriesVO>() ;
			FileuploadVO protectedfile = new FileuploadVO();
			protectedfile.setUsername(username);
			
			
			DirectoriesVO protecteddirectory = new DirectoriesVO();
			protecteddirectory.getUsername();
			
			
			DirectoriesDAO protectedfiled= new DirectoriesDAO();
			//String file=protectedfiled.getprotectedfile(protecteddirectory);
			//protectedfile.setAccess(file);
			
		}
		
		
		if(data.equals("default"))
		{
			System.out.println("trying to fetch default directories!");
			//List<DirectoriesVO> defaultlist= new ArrayList<DirectoriesVO>() ;
			FileuploadVO defaultfile = new FileuploadVO();
			defaultfile.setUsername(username);
			
			
			DirectoriesVO defaultdirectories= new DirectoriesVO();
			defaultdirectories.setUsername(username);
			
			DirectoriesDAO defaultfiled= new DirectoriesDAO();
		//	String file=protectedfiled.grtdefault(defaultdirectories);
			//defaultfile.setAccess(file);
			
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session=request.getSession();
		String username=(String) session.getAttribute("username");
		 String filename= request.getParameter("filename");
		 String directoryname=request.getParameter("directorylist");
		 System.out.println("directory name is "+directoryname);
		 Part filePart = request.getPart("file");
			//String file_name=filePart.getSubmittedFileName();
			String file_type=filePart.getContentType();
			InputStream inputStream = null;
			if (filePart != null) {
	            inputStream = filePart.getInputStream();
			}
			System.out.println("all values got in servlet successfully");
			FileuploadVO upload= new FileuploadVO();
			upload.setFilename(filename);
			upload.setDirectoryname(directoryname);
			upload.setUsername(username);
			upload.setInputstream(inputStream);
			upload.setFile(filePart);
			upload.setFiletype(file_type);
			
			DirectoriesVO directory = new DirectoriesVO();
			directory.setDirectoryname(directoryname);
			
			DirectoriesDAO directoryd= new DirectoriesDAO();
			String tree= directoryd.gettreeinfileupload(directory);
			System.out.println(tree);
			String access= directoryd.getaccessinfileupload(directory);
			System.out.println(access);
			
			upload.setTree(tree);
			upload.setAccess(access);
			
			
			
			
			FileuploadDAO uploadd= new FileuploadDAO();
			uploadd.fileupload(upload);
			
			RequestDispatcher rd=request.getRequestDispatcher("Manager/ManagerDashboard.jsp");
			rd.forward(request, response);
	}

}
