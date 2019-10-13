package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity 
@Table(name="matches")
public class Match {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
	String result;
	//@JsonFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd")
    Date date;
   // String value;
   // String registrationNumber;    
    
    public Match(){}
    
    public Match(long id, String result) {
        this.id = id;
        this.result = result;
    }    
    
    public Match(long id, String result, Date date) {
        this.id = id;
        this.result = result;
        this.date = date;
      //  this.value = value;
       // this.registrationNumber = registrationNumber;
    }        
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getResult() {
		return result;
	}
	
	public void setResult(String result) {
		this.result = result;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}	
	
    public String getRegistrationNumber() {
    	return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
    	this.registrationNumber = registrationNumber;
    }	
*/
}
