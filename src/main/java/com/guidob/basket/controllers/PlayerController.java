package com.guidob.basket.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.guidob.basket.beans.Player;
import com.guidob.basket.repository.PlayerRepository;
import com.guidob.basket.services.PlayerService;


//@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class PlayerController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
  //  private static String UPLOADED_FOLDER = "D://temp//";
    private static String UPLOADED_FOLDER = "C://Users//guido//workspacedev//basketbackend//src//main//webapp//";
    
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private PlayerService servicePlayer;

    //ver este metodo para que
    @RequestMapping("/players")
    public Player player(@RequestParam(value="name", defaultValue="ASD") String name) {
        return new Player(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
    @PostMapping("/players")
    public String newPlayer(@RequestParam("defaultImg") MultipartFile defaultImg, @RequestParam("name") 
		String name , @RequestParam("position")String position,@RequestParam("registrationNumber") String registrationNumber
		,@RequestParam("dayBirth") String dayBirth) throws IOException  {
    	
		// // ver q no llega como date.
    	Player nPlayer = new Player(0, "");
		  nPlayer.setName(name);
		  nPlayer.setRegistrationNumber(registrationNumber);		  
		  nPlayer.setPosition(position);
		 // nPlayer.setDayBirth(dayBirth); transformar string a date, viene yyyy-mm-dd
		  nPlayer.setDayBirth(new Date());
		  nPlayer.setDefaultImg(defaultImg.getOriginalFilename());
		  servicePlayer.save(nPlayer);
		  
    	  byte[] bytes;
//mejor crear una clase private StorageService storageService;
          if (!defaultImg.isEmpty()) {
               bytes = defaultImg.getBytes();
              //store file in storage
               saveUploadedFiles(Arrays.asList(defaultImg));
          }

          System.out.println(String.format("receive %s from %s", defaultImg.getOriginalFilename(), name));
      	  return "Savedd";
    } 
	
    
    private void saveUploadedFiles(List<MultipartFile> files) throws IOException {

    	try {
	        for (MultipartFile file : files) {
	
	            if (file.isEmpty()) {
	                continue; //next pls
	            }
	
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            /*
	             *            Files.copy(is, Paths.get(path + fileName),
	                    StandardCopyOption.REPLACE_EXISTING);
	             */
	            Files.write(path, bytes);
	        }
	    }  catch (IOException e) {
	         e.printStackTrace();          
        }

    }
    
	@RequestMapping(value = "/players/listPlayers", method = RequestMethod.GET)
	public @ResponseBody List<Player> listPlayers() { 
	    return servicePlayer.findAllUsers();
	}	
	
	@RequestMapping(value = "/players", method = RequestMethod.GET)
	public @ResponseBody List<Player> listAllUsers() { 
	    return servicePlayer.findAllUsers();
	}	
	
	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
	public String updatePlayer(@PathVariable Long id, @RequestBody Player player){
	   // return servicePlayer.update(id, player);
		 servicePlayer.save(player);
		 //return player;
		return "OK";
	 }	
	
	/*
	@RequestMapping(value = "/players/{id}", method = RequestMethod.PUT)
	public String updatePlayer(@RequestParam("defaultImg") MultipartFile defaultImg, @PathVariable Long id, @RequestParam("name") 
	String name , @RequestParam("position")String position,@RequestParam("registrationNumber") String registrationNumber
	,@RequestParam("dayBirth") String dayBirth) throws IOException{
		Player onePlayer = this.obtenerPlayer(id);
		onePlayer.setName(name);
	//	onePlayer.setDayBirth(dayBirth);
		onePlayer.setPosition(position);
		onePlayer.setRegistrationNumber(registrationNumber);		
		//guardar file como en add
		onePlayer.setDefaultImg(defaultImg.getOriginalFilename());
	    servicePlayer.save(onePlayer);
		// servicePlayer.save(player);
		 //return player;
		return "OK";
	 }	
	 */
	
	@RequestMapping(value = "/players/{id}", method = RequestMethod.GET)
	public @ResponseBody Player obtenerPlayer(@PathVariable Long id){
 
		Player player =  servicePlayer.find(id);
		return player;
 
	 }	
	 	
	 
	 @RequestMapping(value = "/players/{id}", method = RequestMethod.DELETE)
	 public  @ResponseBody  ResponseEntity<String>  deleteEmployee(@PathVariable Long id) {
		  servicePlayer.deleteById(id);
		  return ResponseEntity
				       .status(HttpStatus.NO_CONTENT)
				       .body("");		  
	  }
	  
}