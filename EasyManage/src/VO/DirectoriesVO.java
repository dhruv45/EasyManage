package VO;

import java.io.Serializable;

import com.mysql.jdbc.Blob;

public class DirectoriesVO implements Serializable {

	private String username;
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

	

	/**
	 * @return the tree
	 */
	


	private String directoryname;
	private String filename;
	private String access;
	private String tree;
	
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

	public DirectoriesVO() {
		// TODO Auto-generated constructor stub
	}

}
