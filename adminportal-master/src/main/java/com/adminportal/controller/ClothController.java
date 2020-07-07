package com.adminportal.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminportal.domain.Cloth;
import com.adminportal.service.ClothService;

@Controller
@RequestMapping("/cloth")
public class ClothController {

	@Autowired
	private ClothService clothService;

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addCloth(Model model) {
		Cloth cloth = new Cloth();
		model.addAttribute("cloth", cloth);
		return "addcloth";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addClothPost(@ModelAttribute("cloth") Cloth cloth, HttpServletRequest request) {

		clothService.save(cloth);

		MultipartFile clothImage = cloth.getClothImage();

		try {
			byte[] bytes = clothImage.getBytes();
			String name = cloth.getId() + ".png";
			BufferedOutputStream stream = new BufferedOutputStream(
					new FileOutputStream(new File("src/main/resources/static/images/cloth/" + name)));
			stream.write(bytes);
			stream.close();

		} catch (Exception e) {
			e.printStackTrace();

		}

		return "redirect:clothList";
	}

	@RequestMapping("/clothList")
	public String clothList(Model model) {
		List<Cloth> clothList = clothService.findAll();
		model.addAttribute("clothList", clothList);
		return "clothList";
	}

	@RequestMapping("/clothInfo")
	public String clothInfo(@RequestParam("id") Long id, Model model) {

		Optional<Cloth> cloth = clothService.findById(id);
		clothService.findById(id).ifPresent(o -> model.addAttribute("cloth", o));
		return "clothInfo";
	}

	@RequestMapping("/updateCloth")
	public String updateCloth(@RequestParam("id") Long id, Model model) {
		Optional<Cloth> cloth = clothService.findById(id);
		clothService.findById(id).ifPresent(o -> model.addAttribute("cloth", o));
		return "updateCloth";

	}

	@RequestMapping(value = "/updateCloth", method = RequestMethod.POST)
	public String updateClothPost(@ModelAttribute("cloth") Cloth cloth, HttpServletRequest request) {
		clothService.save(cloth);

		MultipartFile clothImage = cloth.getClothImage();

		if (!clothImage.isEmpty()) {
			try {
				byte[] bytes = clothImage.getBytes();
				String name = cloth.getId() + ".png";
				
				Files.delete(Paths.get("src/main/resources/static/images/cloth/"+name));
				
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(new File("src/main/resources/static/images/cloth/" + name)));
				stream.write(bytes);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		return "redirect:/cloth/clothInfo?id="+cloth.getId();

	}
	
	@RequestMapping(value="/remove", method=RequestMethod.POST)
	public String remove(
			@ModelAttribute("id") String id, Model model
			) {
		clothService.removeById(Long.parseLong(id.substring(9)));
		List<Cloth> clothList = clothService.findAll();
		model.addAttribute("clothList", clothList);
		
		return "redirect:/cloth/clothList";
	}

}
