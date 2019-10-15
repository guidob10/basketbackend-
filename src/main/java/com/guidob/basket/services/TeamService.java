package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Team;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.repository.TeamRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class TeamService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private TeamRepository teamRepository;

	public List<Team> findAllTeams() {
		// TODO Auto-generated method stub
		return (List<Team>) teamRepository.findAll();
	}	
	
	public Team find(Long id) {
		// TODO Auto-generated method stub
	//	return (Optional<Player>)playerRepository.findById(id);
	//	return (Player)playerRepository.findById(id).get();	
		return (Team)teamRepository.findById(id);
	}		
	
	public void save(Team n) {
		// TODO Auto-generated method stub
		 teamRepository.save(n);
	}	
	
	public void deleteById(Long id) {
		teamRepository.deleteById(id);
	}

}
