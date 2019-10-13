package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.Player;
import com.guidob.basket.repository.PlayerRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class PlayerService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private PlayerRepository playerRepository;

	public List<Player> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<Player>) playerRepository.findAll();
	}	
	
	public Player find(Long id) {
		// TODO Auto-generated method stub
	//	return (Optional<Player>)playerRepository.findById(id);
	//	return (Player)playerRepository.findById(id).get();	
		return (Player)playerRepository.findById(id);
	}		
	
	public void save(Player n) {
		// TODO Auto-generated method stub
		 playerRepository.save(n);
	}	
	
	public void deleteById(Long id) {
		playerRepository.deleteById(id);
	}

}
