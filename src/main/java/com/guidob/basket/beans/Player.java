package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity 
@Table(name="players")
public class Player {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String name;
	//@JsonFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd")
    Date dayBirth;
    String position;
    String registrationNumber;   
    String defaultImg;
    
    public Player(){}
    
    public Player(long id, String name) {
        this.id = id;
        this.name = name;
    }    
    
    public Player(long id, String name, Date dayBirth, String position, String registrationNumber, String defaultImg) {
        this.id = id;
        this.name = name;
        this.dayBirth = dayBirth;
        this.position = position;
        this.registrationNumber = registrationNumber;
        this.defaultImg = defaultImg;        
    }        
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Date getDayBirth() {
		return dayBirth;
	}
	public void setDayBirth(Date dayBirth) {
		this.dayBirth = dayBirth;
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}	
	
    public String getRegistrationNumber() {
    	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
    	this.registrationNumber = registrationNumber;
    }	
    
	public String getDefaultImg() {
		return defaultImg;
	}
	
	public void setDefaultImg(String defaultImg) {
		this.defaultImg = defaultImg;
	}
}
