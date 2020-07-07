package com.clothstore.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.clothstore.domain.Cloth;

public interface ClothRepository extends CrudRepository<Cloth,Long>{
	
	List<Cloth> findByType(String type);
	
	List<Cloth> findByNameContaining(String name);
	
	List<Cloth> findByGender(String gender);

	

}
