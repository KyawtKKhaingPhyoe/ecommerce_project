package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;

@Service
public interface AdminService {
	
	Admin findByUsername(String username);
	
	Admin save(AdminDto adminDto);

}
