package com.blog.controller;

import java.util.List;

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

import com.blog.payload.ApiResponse;
import com.blog.payload.CategoryDto;
import com.blog.services.CategoryService;

import jakarta.validation.Valid;

// Testing 
@RestController
@RequestMapping("/category-api")
public class CategoryController {

	
	@Autowired
	private CategoryService categoryService;
	
	
	@PostMapping("/create")
	public ResponseEntity<CategoryDto> createCategory(@Valid  @RequestBody CategoryDto categoryDto){
		CategoryDto data= categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(data,HttpStatus.CREATED);
	}
	
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto>updateCategory(@Valid  @RequestBody CategoryDto categoryDto ,@PathVariable(name = "categoryId") Long  categoryId   ){
		
		CategoryDto data=categoryService.updateCategory(categoryId, categoryDto);
		return new ResponseEntity<CategoryDto>(data,HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse>deleteCategoryById(@PathVariable Long categoryId){
		
		CategoryDto data= categoryService.getCategoryById(categoryId);
		
		if(data.equals(null)) {
			return new ResponseEntity<ApiResponse>(new ApiResponse("Something went wrong given category doesn't deleted!! ", true),HttpStatus.NO_CONTENT);
		}
		else {
			categoryService.deleteCategory(categoryId);
			return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully ", true),HttpStatus.OK);
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoryDto>getCategoryById(@PathVariable Long id )
	{
		CategoryDto dto=categoryService.getCategoryById(id);
		return new ResponseEntity<CategoryDto>(dto,HttpStatus.OK);
	}
	
	
	@GetMapping("/get-all")
	public ResponseEntity<List<CategoryDto>>getAllCategories(){
		List<CategoryDto> dto=categoryService.getAllCategory();
		
		return new ResponseEntity<List<CategoryDto>>(dto,HttpStatus.OK);
	}
	
}
