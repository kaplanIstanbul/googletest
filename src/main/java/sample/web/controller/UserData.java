

package sample.web.controller;

import java.util.Calendar;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;


public class UserData {

//	@Id
//	private String id;
//
//	@NotEmpty(message = "Name is required.")
//	private String name;
//
//	@NotEmpty(message = "Surname is required.")
//	private String surname;

//	@NotEmpty(message = "Email is required.")
	private String email;
	
	@NotEmpty(message = "Password is required.")
	@Size(min=6, max=15)
	private String password;
	
//	private Calendar created = Calendar.getInstance();

//	public String getId() {
//		return id;
//	}
//
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getSurname() {
//		return surname;
//	}
//
//	public void setSurname(String surname) {
//		this.surname = surname;
//	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Calendar getCreated() {
//		return created;
//	}
//
//	public void setCreated(Calendar created) {
//		this.created = created;
//	}


}
