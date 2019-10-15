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
import com.guidob.basket.beans.Team;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.services.MatchService;
import com.guidob.basket.services.PlayerService;
import com.guidob.basket.services.TeamService;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class TeamController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private TeamService serviceTeam;

    //ver este metodo para que
    @RequestMapping("/teams")
    public Team team(@RequestParam(value="result", defaultValue="ASD") String result) {
        return new Team(counter.incrementAndGet(),
                            String.format(template, result));
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
    @PostMapping("/teams")
    String newTeam(@RequestBody Team newMatch) {
    	serviceTeam.save(newMatch);
    	return "Savedd";
    }    
	
	@RequestMapping(value = "/teams", method = RequestMethod.GET)
	public @ResponseBody List<Team> listAllTeams() { 
	    return serviceTeam.findAllTeams();
	}	
	
	//metodo publico.
	@RequestMapping(value = "/teams/listTeams", method = RequestMethod.GET)
	public @ResponseBody List<Team> listTeams() { 
	    return serviceTeam.findAllTeams();
	}		
	
	@RequestMapping(value = "/teams/{id}", method = RequestMethod.PUT)
	public String updateTeam(@PathVariable Long id, @RequestBody Team team){
	   // return servicePlayer.update(id, player);
		 serviceTeam.save(team);
		 //return player;
		return "OK";
	 }	
	
	@RequestMapping(value = "/teams/{id}", method = RequestMethod.GET)
	public @ResponseBody Team obtenerTeam(@PathVariable Long id){
 
		Team team =  serviceTeam.find(id);
		return team;
 
	 }		
	 
	 @RequestMapping(value = "/teams/{id}", method = RequestMethod.DELETE)
	 public  @ResponseBody  void deleteTeam(@PathVariable Long id) {
		  serviceTeam.deleteById(id);
	  }
	  
}