package com.blog.services;

 
import java.util.List;

import com.blog.entities.Users;
import com.blog.payload.UserDto;

public interface UserServices {

	
	public UserDto createUser(UserDto user);
	public  UserDto updateUser(UserDto user, Long id);
	
	public UserDto getUserById(Long id);
	
	public List<UserDto>getAllUsers();
	
	public void deleteUser(Long id);
	
}
