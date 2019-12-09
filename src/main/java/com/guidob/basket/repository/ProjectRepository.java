package com.guidob.basket.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Project;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
 /*
public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
	Project findById(Long id);
	@Transactional
	void deleteById(Long id);
}
*/

public interface ProjectRepository extends PagingAndSortingRepository<Project, Integer> {
	 
	Project findById(Long id);
	@Transactional
	void deleteById(Long id);
	
 //   List<Project> findAllByPrice(double price, Pageable pageable);
	
}