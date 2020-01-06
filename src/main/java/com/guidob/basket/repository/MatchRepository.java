package com.guidob.basket.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import com.guidob.basket.beans.Match;


 public interface MatchRepository extends  PagingAndSortingRepository<Match, Integer> {
	
	Match findById(Long id);
	@Transactional
	void deleteById(Long id);
	
	Page<Match> findAll(Pageable pageable);

}