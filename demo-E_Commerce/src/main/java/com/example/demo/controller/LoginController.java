package com.example.demo.controller;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.AdminDto;
import com.example.demo.model.Admin;
import com.example.demo.service.impl.AdminServiceImpl;


@Controller
public class LoginController {

	@Autowired
	private AdminServiceImpl adminServiceImpl;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@GetMapping("/login")
	public String loginForm(Model model) {
		model.addAttribute("title", "Login");
		return "login";
	}
	
	@RequestMapping("/index")
	public String home(Model model) {
		model.addAttribute("title", "Home Page");
		return "index";
	}

	@GetMapping("/register")
	public String register(Model model) {
		model.addAttribute("title", "Register");
		model.addAttribute("adminDto", new AdminDto());
		return "register";
	}

	@GetMapping("/forgot-password")
	public String forgotPassword(Model model) {
		model.addAttribute("title", "Forgot Password");
		return "forgot-password";
	}

	@PostMapping("/register-new")
	public String addNewAdmin(@Valid @ModelAttribute("adminDto") AdminDto adminDto, BindingResult result, Model model,
			RedirectAttributes redirectAttributes) {

		try {

			if (result.hasErrors()) {
				model.addAttribute("adminDto", adminDto);
				result.toString();
				return "register";
			}

			String username = adminDto.getUsername();
			Admin admin = adminServiceImpl.findByUsername(username);

			if (admin != null) {
				model.addAttribute("adminDto", adminDto);
				model.addAttribute("emailError", "Your email has been registered!");
				return "register";
			}
			
			if(adminDto.getPassword().equals(adminDto.getRepeatPassword())) {
				adminDto.setPassword(passwordEncoder.encode(adminDto.getPassword()));
				adminServiceImpl.save(adminDto);
				model.addAttribute("success","Registered Successfully!");
				model.addAttribute("adminDto",adminDto);
			} else {
				model.addAttribute("adminDto", adminDto);
				model.addAttribute("passwordError","Your password may be wrong. Check again!");
				return "register";
			}

		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("errors","The server Errors!");
		}
		return "register";
	}

}
