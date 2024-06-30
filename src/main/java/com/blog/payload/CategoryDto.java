package com.blog.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CategoryDto {

	
	 
	private Long categoryId;
	
	
	@NotEmpty
	@Size( min = 3,   max = 1000,message = "Title must contain minimum 3 to maximum 1000 character")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10,    max = 2000,message ="Description must contain minimum 10 to maximum 2000 character" )
	private String categoryDescription;

	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CategoryDto(Long categoryId,
			@NotEmpty @Size(max = 1000, message = "Title must contain maximum 1000 character") String categoryTitle,
			@NotEmpty @Size(max = 2000, message = "Description must contain maximum 2000 character") String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}

	@Override
	public String toString() {
		return "CategoryDto [categoryId=" + categoryId + ", categoryTitle=" + categoryTitle + ", categoryDescription="
				+ categoryDescription + "]";
	}

	 
	 
	 
}
