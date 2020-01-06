package com.guidob.basket.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guidob.basket.beans.Match;
import com.guidob.basket.beans.New;
import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Team;
import com.guidob.basket.exceptions.UserErrorException;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.services.MatchService;
import com.guidob.basket.services.NewService;
import com.guidob.basket.services.PlayerService;
import com.guidob.basket.services.TeamService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewController {

	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private NewService serviceNew;

     @PostMapping("/news")
    String newNew(@RequestBody New newNew) {
    	serviceNew.save(newNew);
    	return "Savedd";
    }    
	/*
	@RequestMapping(value = "/news", method = RequestMethod.GET)
	public @ResponseBody List<New> listAllTeams() { 
	    return serviceNew.findAllNews();
	}*/	
	 
	//metodo publico.
	@RequestMapping(value = "/news/listNews", method = RequestMethod.GET)
	public @ResponseBody List<New> listNews() { 
	    return serviceNew.findAllNews();
	}	 
	
	 @RequestMapping(value = "/news", method = RequestMethod.GET)
	 @GetMapping(params = { "page", "size","sort_by" }) 
	 public ResponseEntity<?> getPaginatedMatches(
                   @RequestParam(defaultValue = "0") int page, 
                   @RequestParam(defaultValue = "10") int size,
                   @RequestParam(defaultValue = "id") String sort_by) 	{
		 
	 
		if (size > 10) {
			size = 10;
		}	
		
		Pageable firstPageWithTwoElements = PageRequest.of(page, size, Sort.by(sort_by).descending());		

		Page<New> resultPage = serviceNew.findAllNewsPage(firstPageWithTwoElements);
		
	     if (page > resultPage.getTotalPages()) {
	    	 throw new UserErrorException("Username '"+"Project Pagination "+"' error");
	     }
	     
	    return ResponseEntity.ok(resultPage);
	 } 	 	
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.PUT)
	public String updateNew(@PathVariable Long id, @RequestBody New neww){
	   // return servicePlayer.update(id, player);
		serviceNew.save(neww);
		 //return player;
		return "OK";
	 }	
	
	@RequestMapping(value = "/news/{id}", method = RequestMethod.GET)
	public @ResponseBody New obtenerNew(@PathVariable Long id){
 
		New neww =  serviceNew.find(id);
		return neww;
 
	 }		
	 
	 @RequestMapping(value = "/news/{id}", method = RequestMethod.DELETE)
	 public  @ResponseBody  void deleteTeam(@PathVariable Long id) {
		 serviceNew.deleteById(id);
	  }
	  
}