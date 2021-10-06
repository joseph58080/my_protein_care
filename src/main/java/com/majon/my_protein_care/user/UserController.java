package com.majon.my_protein_care.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@GetMapping("/signup_view")
	public String userSignUpView() {
		
		return "/user/signUp";
		
	}
	
}