package com.adminportal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adminportal.service.ClothService;



@RestController
public class ResourceController {

	@Autowired
	private ClothService clothService;
	
	@RequestMapping(value="/cloth/removeList", method=RequestMethod.POST)
	public String removeList(
			@RequestBody ArrayList<String> clothIdList, Model model
			){
		
		for (String id : clothIdList) {
			String clothId =id.substring(8);
			clothService.removeById(Long.parseLong(clothId));
		}
		
		return "delete success";
	}
}
