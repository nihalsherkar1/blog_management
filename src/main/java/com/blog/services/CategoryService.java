package com.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.blog.payload.CategoryDto;


public interface CategoryService {

	//create 
	public CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	public CategoryDto updateCategory(Long cateogyId, CategoryDto categoryDto);
	
	
	
	//delete-by-id
	public void deleteCategory(Long categoryId);
	
	
	 
	//get-all
	public List<CategoryDto>getAllCategory();
	
	
	//get-by-id
	public CategoryDto getCategoryById(Long categoryId );
	
	
	
	
	
}
