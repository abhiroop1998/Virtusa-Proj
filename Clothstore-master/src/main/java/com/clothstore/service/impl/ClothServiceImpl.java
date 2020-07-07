package com.clothstore.service.impl;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clothstore.domain.Cloth;
import com.clothstore.repository.ClothRepository;
import com.clothstore.service.ClothService;

@Service
public class ClothServiceImpl implements ClothService {

	@Autowired
	private ClothRepository clothRepository;

	public List<Cloth> findAll() {
		List<Cloth> clothList = (List<Cloth>) clothRepository.findAll();
		List<Cloth> activeClothList = new ArrayList<>();
		
		for (Cloth cloth : clothList) {
			if (cloth.isActive()) {
				activeClothList.add(cloth);
			}
		}
		return activeClothList;
		
	}

	@Override
	public Cloth findById(Long id) {
		// TODO Auto-generated method stub
//		return clothRepository.findById(id);

		Optional<Cloth> optionalCloth = clothRepository.findById(id);
		Cloth cloth = optionalCloth.get();
		return cloth;
	}

	@Override
	public List<Cloth> findByType(String type) {
		// TODO Auto-generated method stub
		List<Cloth> clothList = clothRepository.findByType(type);

		List<Cloth> activeClothList = new ArrayList<>();

		for (Cloth cloth : clothList) {
			if (cloth.isActive()) {
				activeClothList.add(cloth);
			}
		}

		return activeClothList;
	}

	@Override
	public List<Cloth> blurrySearch(String name) {
		// TODO Auto-generated method stub
		List<Cloth> clothList = clothRepository.findByNameContaining(name);
		List<Cloth> activeClothList = new ArrayList<>();
				
				for (Cloth cloth: clothList) {
					if(cloth.isActive()) {
						activeClothList.add(cloth);
					}
				}
				
				return activeClothList;
	}

	@Override
	public List<Cloth> findByGender(String gender) {
		// TODO Auto-generated method stub
		List<Cloth> clothList = clothRepository.findByGender(gender);

		List<Cloth> activeClothList = new ArrayList<>();

		for (Cloth cloth : clothList) {
			if (cloth.isActive()) {
				activeClothList.add(cloth);
			}
		}

		return activeClothList;
	}

}
