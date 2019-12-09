package com.guidob.basket.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Project;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.repository.ProjectRepository;

// Registramos esta clase como un Bean en nuestro Root ApplicationContext.

@Service
public class ProjectService {

	// Inyectamos una instancia desde nuestro Root ApplicationContext.
    @Autowired
    private ProjectRepository projectRepository;

	public List<Project> findAllUsers() {
		// TODO Auto-generated method stub
		return (List<Project>) projectRepository.findAll();
	}	
	 
	public Page<Project> findAllProjectsPage(Pageable pageable) {
		 

		Page<Project> allProducts = projectRepository.findAll(pageable);
	
		return allProducts;
	}	
	
	public Project find(Long id) {
		// TODO Auto-generated method stub
	//	return (Optional<Player>)playerRepository.findById(id);
	//	return (Player)playerRepository.findById(id).get();	
		return (Project)projectRepository.findById(id); 
	}		
	
	public void save(Project n) {
		// TODO Auto-generated method stub
		projectRepository.save(n);
	}	
	
	public void deleteById(Long id) {
		projectRepository.deleteById(id);
	}

}
