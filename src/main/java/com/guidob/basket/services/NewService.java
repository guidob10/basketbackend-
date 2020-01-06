package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.Match;
import com.guidob.basket.beans.New;
import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Team;
import com.guidob.basket.repository.NewRepository;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.repository.TeamRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class NewService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private NewRepository newRepository;

	public List<New> findAllNews() {
		// TODO Auto-generated method stub
		return (List<New>) newRepository.findAll();
	}	
	
	public Page<New> findAllNewsPage(Pageable pageable) {		 
		Page<New> allNews = newRepository.findAll(pageable);
	
		return allNews;
	}		
	
	public New find(Long id) {
		// TODO Auto-generated method stub
	//	return (Optional<Player>)playerRepository.findById(id);
	//	return (Player)playerRepository.findById(id).get();	
		return (New)newRepository.findById(id);
	}		
	
	public void save(New n) {
		// TODO Auto-generated method stub
		newRepository.save(n);
	}	
	
	public void deleteById(Long id) {
		newRepository.deleteById(id);
	}

}
