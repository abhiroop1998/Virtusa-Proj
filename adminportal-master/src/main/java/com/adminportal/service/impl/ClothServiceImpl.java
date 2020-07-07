package com.adminportal.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adminportal.domain.Cloth;
import com.adminportal.repository.ClothRepository;
import com.adminportal.service.ClothService;

@Service
public class ClothServiceImpl implements ClothService{
	
	@Autowired
	private ClothRepository clothRepository;
	
	public Cloth save(Cloth cloth) {
		return clothRepository.save(cloth);
	}
	
	public List<Cloth> findAll(){
		return (List<Cloth>)clothRepository.findAll();
	}

	@Override
	public Optional<Cloth> findById(Long id) {
		return clothRepository.findById(id);
	}

	@Override
	public void removeById(long id) {
		// TODO Auto-generated method stub
		clothRepository.deleteById(id);
		
	}
}
