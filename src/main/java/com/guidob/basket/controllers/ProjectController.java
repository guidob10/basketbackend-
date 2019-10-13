package com.guidob.basket.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.guidob.basket.beans.Player;
import com.guidob.basket.beans.Project;
import com.guidob.basket.services.PlayerService;
import com.guidob.basket.services.ProjectService;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
public class ProjectController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
	// Inyectamos una instancia desde nuestro Root ApplicationContext
    @Autowired
 	private ProjectService serviceProject;	

    //ver este metodo para que
    @RequestMapping("/projects")
    public Player player(@RequestParam(value="name", defaultValue="ASD") String name) {
        return new Player(counter.incrementAndGet(),
                            String.format(template, name));
    }
    
	// @ResponseBody means the returned String is the response, not a view name
	// @RequestParam means it is a parameter from the GET or POST request        
    @PostMapping(path="/projects") // 
    public ResponseEntity<?> createNewProject(@RequestBody Project project, BindingResult result){    
	
    	if ((project.getProjectName() == null) || (project.getProjectName() == "")){
    	
    		Map<String,String> errorMap = new HashMap<String,String>();
    		errorMap.put("projectName","Nombre no informado");
  	
            return new ResponseEntity<>(errorMap,   HttpStatus.INTERNAL_SERVER_ERROR);    	
    	
    	}
    	
    	Project n = new Project(0, "");
		n.setProjectName(project.getProjectName());
		n.setDescription(project.getDescription());
		n.setProjectIdentifier(project.getProjectIdentifier());
		n.setStartDate(project.getStartDate());
		serviceProject.save(n);
		//return "Saved";
        return new ResponseEntity<Project>(n, HttpStatus.CREATED);		
	}    
	
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public @ResponseBody List<Project> listAllUsers() { 
	    return serviceProject.findAllUsers();
	}	
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.PUT)
	public String updateProject(@PathVariable Long id, @RequestBody Project project){
	   // return servicePlayer.update(id, player);
		serviceProject.save(project);
		 //return player;
		return "OK";
	 }	
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public @ResponseBody Project obtenerProject(@PathVariable Long id){
		 return  serviceProject.find(id); 
	 }		
	 
	 @RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
	 public  @ResponseBody  void deleteProject(@PathVariable Long id) {
		 serviceProject.deleteById(id);
	  }
	  
}