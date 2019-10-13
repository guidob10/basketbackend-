package com.guidob.basket.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Match;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
 
public interface MatchRepository extends CrudRepository<Match, Integer> {
	
	Match findById(Long id);
	@Transactional
	void deleteById(Long id);
}