package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity 
@Table(name="teams")
public class Team {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String name;
	String thumb;
	String stadium;
   // String value;
   // String registrationNumber;    
    
    public Team(){}
    
    public Team(long id, String name) {
        this.id = id;
        this.name = name;
    }    
    
    public Team(long id, String name, String stadium, String thumb) {
        this.id = id;
        this.name = name;
        this.stadium = stadium;
        this.thumb = thumb;
      //  this.value = value;
       // this.registrationNumber = registrationNumber;
    }        
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getStadium() {
		return stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
 
}
