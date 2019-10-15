package com.guidob.basket.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Team;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
 
public interface TeamRepository extends CrudRepository<Team, Integer> {
	
	Team findById(Long id);
	@Transactional
	void deleteById(Long id);
}