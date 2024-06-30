package com.blog.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.entities.Users;
import com.blog.payload.ApiResponse;
import com.blog.payload.UserDto;
import com.blog.services.UserServices;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user-api")
public class UserController {
	
	@Autowired
	private UserServices services;
	
//	Create
	@PostMapping("/create")
	public ResponseEntity<UserDto>createUser(@Valid   @RequestBody UserDto users){
		UserDto data=services.createUser(users);
		
		return new ResponseEntity< >(data, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/get-all-users")
	public ResponseEntity<List<UserDto>>getAllUsers(){
		
		List<UserDto> data= services.getAllUsers();
		
		return new ResponseEntity<>(data,HttpStatus.OK);
		
	}
	
	
	
	
	
//	Update
	@PutMapping("/{id}")
	public ResponseEntity<UserDto>updateUser( @RequestBody UserDto users,   @PathVariable(name = "id") Long id  ){
		UserDto data=services.updateUser(users, id);
		
		return new ResponseEntity<UserDto>(data, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity< UserDto>getUserById(@PathVariable Long id){
		
		UserDto data=services.getUserById(id);
		
		return new ResponseEntity<UserDto>(data,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse>deleteUserById(@PathVariable Long id){
		
		//check first it present in db or not
		UserDto uId=services.getUserById(id);
		System.out.println("User with Id :"+uId+ " is present in database....");
		
        if(uId.equals(null)) {
        	return new ResponseEntity<>(new ApiResponse("User is not Present ..", true),HttpStatus.NO_CONTENT);
        }
        else {
        	services.deleteUser(id);
        	return new ResponseEntity<>(new ApiResponse("User Deleted Successfully....", true),HttpStatus.OK);
        }
		
		
	}
	
	
	

}
