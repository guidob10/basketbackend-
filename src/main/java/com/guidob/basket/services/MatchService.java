package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.Match;
import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Project;
import com.guidob.basket.repository.MatchRepository;
import com.guidob.basket.repository.PlayerRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class MatchService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private MatchRepository matchRepository;

	public List<Match> findAllMatches() {
		// TODO Auto-generated method stub
		return (List<Match>) matchRepository.findAll();
	}	
	
	public Match find(Long id) {
		// TODO Auto-generated method stub
	//	return (Optional<Player>)playerRepository.findById(id);
	//	return (Player)playerRepository.findById(id).get();	
		return (Match)matchRepository.findById(id);
	}		
	
	public Page<Match> findAllMatchesPage(Pageable pageable) {		 
		Page<Match> allProducts = matchRepository.findAll(pageable);
	
		return allProducts;
	}	
	
	public void save(Match n) {
		// TODO Auto-generated method stub
		 matchRepository.save(n);
	}	
	
	public void deleteById(Long id) {
		matchRepository.deleteById(id);
	}

}
