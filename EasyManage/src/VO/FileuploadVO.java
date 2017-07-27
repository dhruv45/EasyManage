package VO;

import java.io.InputStream; 
import java.sql.Blob;

import javax.servlet.http.Part;

public class FileuploadVO {
	private int file_id;
	private String username;
	private String directoryname;
	private String filename;
	private String access;
	private String filetype;
	private Part file;
	private Blob getfile;
	/**
	 * @return the getfile
	 */
	
	public Blob getGetfile() {
		return getfile;
	}
	/**
	 * @return the filetype
	 */
	public String getFiletype() {
		return filetype;
	}
	/**
	 * @param filetype the filetype to set
	 */
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	/**
	 * @param getfile the getfile to set
	 */
	public void setGetfile(Blob getfile) {
		this.getfile = getfile;
	}
	/**
	 * @return the tree
	 */
	public String getTree() {
		return tree;
	}
	/**
	 * @param tree the tree to set
	 */
	public void setTree(String tree) {
		this.tree = tree;
	}
	/**
	 * @return the file
	 */
	public Part getFile() {
		return file;
	}
	private String tree;
	/**
	 * @return the inputstream
	 */
	public InputStream getInputstream() {
		return inputstream;
	}
	/**
	 * @param inputstream the inputstream to set
	 */
	public void setInputstream(InputStream inputstream) {
		this.inputstream = inputstream;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(Part file) {
		this.file = file;
	}
	private InputStream inputstream;
	
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the directoryname
	 */
	public String getDirectoryname() {
		return directoryname;
	}
	/**
	 * @param directoryname the directoryname to set
	 */
	public void setDirectoryname(String directoryname) {
		this.directoryname = directoryname;
	}
	/**
	 * @return the filename
	 */
	public String getFilename() {
		return filename;
	}
	/**
	 * @param filename the filename to set
	 */
	public void setFilename(String filename) {
		this.filename = filename;
	}
	/**
	 * @return the access
	 */
	public String getAccess() {
		return access;
	}
	/**
	 * @param access the access to set
	 */
	public void setAccess(String access) {
		this.access = access;
	}
	
	public FileuploadVO() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @return the file_id
	 */
	public int getFile_id() {
		return file_id;
	}
	/**
	 * @param file_id the file_id to set
	 */
	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}
	

}
