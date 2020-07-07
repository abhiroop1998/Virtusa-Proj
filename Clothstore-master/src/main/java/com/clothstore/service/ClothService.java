package com.clothstore.service;

import java.util.List;
import java.util.Optional;

import com.clothstore.domain.Cloth;

public interface ClothService{
	 List<Cloth> findAll();
	 
	 Cloth findById(Long id);

	List<Cloth> findByType(String type);
	
	List<Cloth> findByGender(String gender);

	List<Cloth> blurrySearch(String keyword);

	
}
