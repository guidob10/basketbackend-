package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity 
@Table(name="news")
public class New {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String title;
	String thumb;
	String description;
   // String value;
   // String registrationNumber;    
    
    public New(){}
    
    public New(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;        
    }    
    
    public New(long id, String title, String description, String thumb) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.thumb = thumb;
      //  this.value = value;
       // this.registrationNumber = registrationNumber;
    }        
    
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumb() {
		return thumb;
	}

	public void setThumb(String thumb) {
		this.thumb = thumb;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
