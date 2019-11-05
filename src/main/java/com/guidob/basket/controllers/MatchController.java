package com.guidob.basket.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guidob.basket.beans.Match;
import com.guidob.basket.beans.Player;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.services.MatchService;
import com.guidob.basket.services.PlayerService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MatchController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private MatchService serviceMatch;

    //ver este metodo para que
    @RequestMapping("/matches")
    public Match match(@RequestParam(value="result", defaultValue="ASD") String result) {
        return new Match(counter.incrementAndGet(),
                            String.format(template, result),"");
    }
    
	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request    
    // este funciona ok, pero solo con el postman
    /*
    @PostMapping(path="/players") // 
	public @ResponseBody String addNewPlayer (@RequestParam String name
			, @RequestParam String email) {
		Player n = new Player(0, "");
		n.setName(name);
		n.setValue("");
		servicePlayer.save(n);
		return "Saved";
	} */  

    /* recibe data ok pero no graba
    @PostMapping("/players")
    Player newEmployee(@RequestBody Player newEmployee) {
      return playerRepository.save(newEmployee);
    }
    */
    @PostMapping("/matches")
    String newMatch(@RequestBody Match newMatch) {
    	serviceMatch.save(newMatch);
    	return "Savedd";
    }    
	
	@RequestMapping(value = "/matches", method = RequestMethod.GET)
	public @ResponseBody List<Match> listAllMatches() { 
	    return serviceMatch.findAllMatches();
	}	
	/*
	//metodo publico.
	@RequestMapping(value = "/matches/listMatches", method = RequestMethod.GET)
	public @ResponseBody List<Match> listMatches() {
		System.out.print("recupero equipos");
	    return serviceMatch.findAllMatches();
	}*/		
	
	@RequestMapping(value = "/matches/{id}", method = RequestMethod.PUT)
	public String updateMatch(@PathVariable Long id, @RequestBody Match match){
	   // return servicePlayer.update(id, player);
		 serviceMatch.save(match);
		 //return player;
		return "OK";
	 }	
	
	@RequestMapping(value = "/matches/{id}", method = RequestMethod.GET)
	public @ResponseBody Match obtenerMatch(@PathVariable Long id){
 
		Match match =  serviceMatch.find(id);
		return match;
 
	 }		
	 
	 @RequestMapping(value = "/matches/{id}", method = RequestMethod.DELETE)
	 public  @ResponseBody  void deleteMatch(@PathVariable Long id) {
		  serviceMatch.deleteById(id);
	  }
	  
}