package com.clothstore.controller;

import java.awt.print.Book;
import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.clothstore.domain.Cloth;
import com.clothstore.domain.User;
import com.clothstore.service.ClothService;
import com.clothstore.service.UserService;

@Controller
public class SearchController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ClothService clothService;
	
	@RequestMapping("/searchByType")
	public String searchByType(
			@RequestParam("type") String type,
			Model model, Principal principal
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveType = "active"+type;
		classActiveType = classActiveType.replaceAll("\\s+", "");
		classActiveType = classActiveType.replaceAll("&", "");
		model.addAttribute(classActiveType, true);
		
		List<Cloth> clothList = clothService.findByType(type);
		
		if (clothList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "clothshelf";
		}
		
		model.addAttribute("clothList", clothList);
		
		return "clothshelf";
	}
	
	@RequestMapping("/searchByGender")
	public String searchByGender(
			@RequestParam("gender") String gender,
			Model model, Principal principal
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveType = "active"+gender;
		classActiveType = classActiveType.replaceAll("\\s+", "");
		classActiveType = classActiveType.replaceAll("&", "");
		model.addAttribute(classActiveType, true);
		
		List<Cloth> clothList = clothService.findByGender(gender);
		
		if (clothList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "clothshelf";
		}
		
		model.addAttribute("clothList", clothList);
		
		return "clothshelf";
	}
	
	@RequestMapping("/searchCloth")
	public String searchCloth(
			@ModelAttribute("keyword") String keyword,
			Principal principal, Model model
			) {
		if(principal!=null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		List<Cloth> clothList = clothService.blurrySearch(keyword);
		
		if (clothList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "clothshelf";
		}
		
		model.addAttribute("clothList", clothList);
		
		return "clothshelf";
	}

}
