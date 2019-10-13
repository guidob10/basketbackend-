package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity 
@Table(name="projects")
public class Project {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String projectName;
	String description;
    long projectIdentifier;
	Date startDate;    
    
    public Project(){}
    
    public Project(long id, String description) {
        this.id = id;
        this.description = description;        
    }    
    
    public Project(long id, String projectName,String description, long projectIdentifier, Date startDate) {
        this.id = id;
        this.projectName = projectName;
        this.projectIdentifier = projectIdentifier;
        this.description = description;
        this.startDate = startDate;

    }        
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getProjectName() {
		return projectName;
	}
	
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

	public long getProjectIdentifier() {
		return projectIdentifier;
	}
	
	public void setProjectIdentifier(long projectIdentifier) {
		this.projectIdentifier = projectIdentifier;
	}
	 
	public Date getStartDate() {
		return startDate;
	}
	
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}	

}
