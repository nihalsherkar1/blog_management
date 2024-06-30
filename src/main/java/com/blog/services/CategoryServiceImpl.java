package com.blog.services;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.entities.Category;
import com.blog.exception.ResourceNotFoundException;
import com.blog.payload.CategoryDto;
import com.blog.repository.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		   
		// ! dto is converted to category
		 Category category=this.dtoToCategory(categoryDto);

		 //* then after added dto it save in db using repo */
		 Category data=categoryRepo.save(category);

		 //*  Now it converted categoty to dto */
		return categoryToDto(data);
	}

	@Override
	public CategoryDto updateCategory(Long cateogyId, CategoryDto categoryDto) {
        
		Category data= categoryRepo.findById(cateogyId).orElseThrow( ()-> new ResourceNotFoundException("Category"," id ", cateogyId) );
		data.setCategoryTitle(categoryDto.getCategoryTitle());
		data.setCategoryDescription(categoryDto.getCategoryDescription());

		Category updatedCategory=this.categoryRepo.save(data);
		return categoryToDto(updatedCategory);
	}

	@Override
	public void deleteCategory(Long categoryId) {
		 Category data= categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category"," id ", categoryId));
		 categoryRepo.delete(data);
		
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		 List<Category> data=categoryRepo.findAll();
		 List<CategoryDto> categoryDtoList= data.stream().map(user-> categoryToDto(user)).collect(Collectors.toList());
		return categoryDtoList;
	}

	@Override
	public CategoryDto getCategoryById(Long categoryId) {
		 Category data= categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category"," id ", categoryId));
		return categoryToDto(data);
	}
	
	
	public Category dtoToCategory(CategoryDto categoryDto) {
		
		Category category=this.modelMapper.map(categoryDto, Category.class);
		return category;		
	}
	
	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto=this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}
	
	
	
	
	
	
}
