package com.adminportal.service;

import java.util.List;
import java.util.Optional;

import com.adminportal.domain.Cloth;

public interface ClothService {

		Cloth save(Cloth cloth);
		
		List<Cloth> findAll();
		
		Optional<Cloth> findById(Long id);
		
		void removeById(long id);
		
}
