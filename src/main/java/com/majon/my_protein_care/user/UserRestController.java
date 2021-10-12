package com.majon.my_protein_care.user;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.majon.my_protein_care.user.bo.UserBO;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserBO userBO;

	@PostMapping("/sign_up")
	public Map<String,String>signUp(
			@RequestParam("loginId") String loginId
			,@RequestParam("name") String name
			,@RequestParam("password") String password
			,@RequestParam("email") String email
			,@RequestParam("nickname") String nickname
			,@RequestParam("height") double height
			,@RequestParam("weight") double weight
			,@RequestParam("activityLevel") String activityLevel
			,@RequestParam("gender") String gender){

		int count = userBO.addUser(loginId, name, password, email, nickname, height, weight, activityLevel, gender);

		Map<String,String>resultMap = new HashMap<>();

		if(count==1) {
			resultMap.put("result", "success");
		}else {
			resultMap.put("result", "fail");
		}
		return resultMap;
	}
	@GetMapping("/isDuplicate")
	public Map<String,Boolean>isDuplicateId(@RequestParam("loginId") String loginId){

		Boolean isDuplicate = userBO.checkDuplicateId(loginId);

		Map<String,Boolean>resultMap = new HashMap<>();

		if(isDuplicate) {
			resultMap.put("isDuplicate",true);
		}else {
			resultMap.put("isDuplicate", false);
		}
		return resultMap;
	}
}
