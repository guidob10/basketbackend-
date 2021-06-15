package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guidob.basket.basket.dto.DataPlayerDTO;
import com.guidob.basket.beans.Player;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.rest.ApiPlayerPhoto;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class PlayerService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
 	private ApiPlayerPhoto ApiPlayerPhoto;
    
	public List<Player> findAllUsers() {		
		ApiPlayerPhoto.setApi("");
		DataPlayerDTO playerDTO = ApiPlayerPhoto.getDataPlayer();
		System.out.println(playerDTO.getUrl());
		List<Player> listPlayers = (List<Player>) playerRepository.findAll();
		//Si no tiene foto, asigno la que busque de la API Gateway de amazon. 
		for (Player player : listPlayers) {
		    if (player.getDefaultImg() == null) {
		    	player.setDefaultImg(playerDTO.getUrl());
		    }
		}
		
		return listPlayers;
	}	
	
	public Player find(Long id) {
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
