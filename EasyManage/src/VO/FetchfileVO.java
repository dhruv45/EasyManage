package VO;

import com.mysql.jdbc.Blob;

public class FetchfileVO {
	private String tree;
	private Blob file;
	private String username;
	private String directoryname;
	private String filename;
	private String access;
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
	public Blob getFile() {
		return file;
	}
	/**
	 * @param file the file to set
	 */
	public void setFile(Blob file) {
		this.file = file;
	}
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
	public FetchfileVO() {
		
		
		/**
		 * @return the serial_no
		 */
		
	}

}
