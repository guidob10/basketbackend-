package com.guidob.basket.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Match;
import com.guidob.basket.beans.New;
import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Team;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
 
public interface NewRepository extends PagingAndSortingRepository<New, Integer> {
	
	New findById(Long id);
	@Transactional
	void deleteById(Long id);
	
	Page<New> findAll(Pageable pageable);
	
}