package VO;

import java.io.Serializable;

public class RegistrationVO implements Serializable {
	

		private String firstname;
		private String lastname;
		private String phonenumber;
		private String email;
		private String username;
		private String password;
		private String position;
		private String address;
		private String status;
		private String managername;
		private String divisionname;
		private int leavecount;
		private int salary;
		private int bonus;
		private int paymonth;
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

		/**
		 * @return the salary
		 */
		public int getSalary() {
			return salary;
		}

		/**
		 * @return the paymonth
		 */
		public int getPaymonth() {
			return paymonth;
		}

		/**
		 * @param paymonth the paymonth to set
		 */
		public void setPaymonth(int paymonth) {
			this.paymonth = paymonth;
		}

		/**
		 * @param salary the salary to set
		 */
		public void setSalary(int salary) {
			this.salary = salary;
		}

		/**
		 * @return the bonus
		 */
		public int getBonus() {
			return bonus;
		}

		/**
		 * @param bonusamount the bonus to set
		 */
		public void setBonus(int bonusamount) {
			this.bonus = bonusamount;
		}

		
		
		public int getLeavecount() {
			return leavecount;
		}

		/**
		 * @param leavecount the leavecount to set
		 */
		public void setLeavecount(int leavecount) {
			this.leavecount = leavecount;
		}

		/**
		 * @return the divisionname
		 */
		public String getDivisionname() {
			return divisionname;
		}

		/**
		 * @param divisionname the divisionname to set
		 */
		public void setDivisionname(String divisionname) {
			this.divisionname = divisionname;
		}

		/**
		 * @return the managername
		 */
		public String getManagername() {
			return managername;
		}

		/**
		 * @param managername the managername to set
		 */
		public void setManagername(String managername) {
			this.managername = managername;
		}

		/**
		 * @return the status
		 */
		public String getStatus() {
			return status;
		}

		/**
		 * @param status the status to set
		 */
		public void setStatus(String status) {
			this.status = status;
		}

		/**
		 * @return the address
		 */
		public String getAddress() {
			return address;
		}

		/**
		 * @param address the address to set
		 */
		public void setAddress(String address) {
			this.address = address;
		}

		/**
		 * @return the firstname
		 */
		public String getFirstname() {
			return firstname;
		}

		/**
		 * @param firstname the firstname to set
		 */
		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		/**
		 * @return the lastname
		 */
		public String getLastname() {
			return lastname;
		}

		/**
		 * @param lastname the lastname to set
		 */
		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		/**
		 * @return the phonenumber
		 */
		public String getPhonenumber() {
			return phonenumber;
		}

		/**
		 * @param phonenumber the phonenumber to set
		 */
		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		/**
		 * @return the email
		 */
		public String getEmail() {
			return email;
		}

		/**
		 * @param email the email to set
		 */
		public void setEmail(String email) {
			this.email = email;
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
		 * @return the password
		 */
		public String getPassword() {
			return password;
		}

		/**
		 * @param password the password to set
		 */
		public void setPassword(String password) {
			this.password = password;
		}

		
		
		public RegistrationVO() {
			// TODO Auto-generated constructor stub
		}

		/**
		 * @return the position
		 */
		public String getPosition() {
			return position;
		}

		/**
		 * @param position the position to set
		 */
		public void setPosition(String position) {
			this.position = position;
		}

	}



