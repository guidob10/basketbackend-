package com.guidob.basket.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Player;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
 
public interface PlayerRepository extends CrudRepository<Player, Integer> {
	
	Player findById(Long id);
	@Transactional
	void deleteById(Long id);
}