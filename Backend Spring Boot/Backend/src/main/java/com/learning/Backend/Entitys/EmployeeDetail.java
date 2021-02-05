package com.learning.Backend.Entitys;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeedetail")
public class EmployeeDetail
{
		// List of field which we will try to store in the database for learning
	
		// This entity will generate auto increase primary key with id filed name in database
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private int id;		
		
		@Column(name="first_name")
		private String first_name;		
		
		@Column(name="last_name")
		private String last_name;
		
		@Column(name="email")
		private String email;		
		
		// Default constructor
		public EmployeeDetail() {
			// TODO Auto-generated constructor stub
		}
		
		// Getter and Setter method for fields initialization
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getFirst_name() {
			return first_name;
		}
		public void setFirst_name(String first_name) {
			this.first_name = first_name;
		}
		public String getLast_name() {
			return last_name;
		}
		public void setLast_name(String last_name) {
			this.last_name = last_name;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
		// Parameterize constructor 
		public EmployeeDetail(String first_name, String last_name, String email){
			super();
			this.first_name = first_name;
			this.last_name = last_name;
			this.email = email;
		}
		
		// toString of EmployeeDeatail 
		@Override
		public String toString() {
			return "Employree [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name + ", email="
					+ email + "]";
		}	
		
		
}
