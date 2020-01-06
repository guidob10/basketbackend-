package com.guidob.basket.controllers;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
//import org.springframework.data.web.PagedResourcesAssembler;
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
import com.guidob.basket.exceptions.UserErrorException;
import com.guidob.basket.services.MatchService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class MatchController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
 //   @Autowired
 //   private PagedResourcesAssembler<Match> pagedAssembler;
        
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private MatchService serviceMatch;

    @RequestMapping("/matches")
    public Match match(@RequestParam(value="result", defaultValue="test") String result) {
        return new Match(counter.incrementAndGet(),
                            String.format(template, result),"");
    }
    
    @PostMapping("/matches")
    String newMatch(@RequestBody Match newMatch) {
    	serviceMatch.save(newMatch);
    	return "Savedd";
    }    
	
    /* se reemplaza este metodo con el de paginado.
	@RequestMapping(value = "/matches", method = RequestMethod.GET)
	public @ResponseBody List<Match> listAllMatches() { 
	    return serviceMatch.findAllMatches();
	}	
	*/
    
	 
	@RequestMapping(value = "/matches/{id}", method = RequestMethod.PUT)
	public String updateMatch(@PathVariable Long id, @RequestBody Match match){
		 serviceMatch.save(match);

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
	 
	 @RequestMapping(value = "/matches", method = RequestMethod.GET)
	 @GetMapping(params = { "page", "size","sort_by" }) 
	 public ResponseEntity<?> getPaginatedMatches(
                    @RequestParam(defaultValue = "0") int page, 
                    @RequestParam(defaultValue = "10") int size,
                    @RequestParam(defaultValue = "id") String sort_by) 	{
		 
	 
		if (size > 10) {
			size = 10;
		}	
		
		Pageable firstPageWithTwoElements = PageRequest.of(page, size, Sort.by(sort_by).descending());		

		Page<Match> resultPage = serviceMatch.findAllMatchesPage(firstPageWithTwoElements);
		
	     if (page > resultPage.getTotalPages()) {
	    	 throw new UserErrorException("Username '"+"Project Pagination "+"' error");
	     }
	     
	    return ResponseEntity.ok(resultPage);
	 } 	 
}