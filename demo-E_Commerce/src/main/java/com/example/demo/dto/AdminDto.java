package com.example.demo.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
	
	@Size(min = 3, max = 10, message = "Invalid FirstName ! (3-10 characters)")
	private String firstName;
	
	@Size(min = 3, max = 10, message = "Invalid LastName ! (3-10 characters)")
	private String lastName;
	
	@Size(min = 3, max = 20, message = "Invalid username ! (3-20 characters)")
	private String username;
	
	private String password;
	
	private String repeatPassword;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRepeatPassword() {
		return repeatPassword;
	}

	public void setRepeatPassword(String repeatPassword) {
		this.repeatPassword = repeatPassword;
	}
	
	

}
