package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Category;

public interface CategoryService {
	
	List<Category> findAll();
	Category save(Category category);
	Category getById(Long id);
	Category update(Category category);
	void deleteById(Long id);
	void enableById(Long id);

}
