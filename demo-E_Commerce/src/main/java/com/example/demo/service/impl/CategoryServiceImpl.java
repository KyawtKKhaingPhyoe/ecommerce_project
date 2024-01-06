package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;

public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category save(Category category) {
		try {
			Category category2 = new Category(category.getName());
			return categoryRepository.save(category2);
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public Category getById(Long id) {
		return categoryRepository.getById(id);
	}

	@Override
	public Category update(Category category) {
		Category category2=new Category();
		category2.setName(category.getName());
		category2.set_activated(category.is_activated());
		category2.set_deleted(category.is_deleted());
		return categoryRepository.save(category2);
	}

	@Override
	public void deleteById(Long id) {
		@SuppressWarnings("deprecation")
		Category category = categoryRepository.getById(id);
		category.set_activated(false);
		category.set_deleted(true);
		categoryRepository.save(category);
	}

	@SuppressWarnings("deprecation")
	@Override
	public void enableById(Long id) {
		Category category = categoryRepository.getById(id);
		category.set_activated(true);
		category.set_deleted(false);
		categoryRepository.save(category);
	}

}
