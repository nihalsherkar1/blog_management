package com.blog.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDto {

	 
	private Long uId;
	
	@NotEmpty
	@Size(min = 4, message = "Username must be greater than 4 character!! ")
	private String name;
	
	@Email(message = "Email address is not valid!!")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max = 8, message = "Password must be greater than 3 and less than 8 character!!")
	private String password;
	
	@NotEmpty
	@Size(max =  1000,message = "About must contain minimum 1000 characters!!")
	private String about;

	public UserDto() {
		super();
		 
	}

	public UserDto(Long uId, String name, String email, String password, String about) {
		super();
		this.uId = uId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public Long getuId() {
		return uId;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

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

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}
	
	
	
	
	
}
