package com.blog.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
 
import com.blog.entities.Users;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.UserDto;
import com.blog.repository.UserRepo;

@Service
public class UserServiceImpl implements UserServices {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public UserDto createUser(UserDto userDto) {
		Users user=this.dtoToUser(userDto);
		 
		Users data=userRepo.save(user);
		return userToDto(data);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		Users data=userRepo.findById(id).orElseThrow(()->  new ResourceNotFoundException("User"," Id ",id));
      data.setName(userDto.getName());
      data.setEmail(userDto.getEmail());
      data.setPassword(userDto.getPassword());
      data.setAbout(userDto.getAbout());
      Users updatedData= userRepo.save(data);
		return userToDto(updatedData);
	}

	@Override
	public UserDto getUserById(Long id) {
		Users data=userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User"," Id ", id));		
		return userToDto(data);
	}
	

	@Override
	public List<UserDto> getAllUsers() {
		List<Users> data= userRepo.findAll();
		List<UserDto> userDtoList= data.stream().map(user-> userToDto(user)).collect(Collectors.toList());
		return userDtoList ;
	}

	@Override
	public void deleteUser(Long id) {
		Users user= userRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User"," Id ", id));
		userRepo.delete(user);
	}
	
	
	public Users dtoToUser(UserDto userDto) {
		Users user= this.modelMapper.map(userDto, Users.class);
		return user;	
	}
	
	
	public UserDto userToDto(Users users) {
		UserDto userDto=this.modelMapper.map(users, UserDto.class);
		return userDto;
	}
	
	
}

