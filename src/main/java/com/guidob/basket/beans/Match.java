package com.guidob.basket.beans;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity 
@Table(name="matches")
public class Match {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

	//@JsonFormat(pattern="dd-MM-yyyy")
	@JsonFormat(pattern="yyyy-MM-dd")
    Date date;
    @ManyToOne
    @JoinColumn(name = "idTeamLocal")
	Team teamLocal;
    
    @ManyToOne
    @JoinColumn(name = "idTeamAway")
	Team teamAway;
	String resultLocal;
	String resultAway;	 
    
    public Match(){}
    
    public Match(long id, String resultLocal, String resultAway) {
        this.id = id;
        this.resultLocal = resultLocal;
        this.resultAway = resultAway;
    }    
    
    public Match(long id, Date date, String resultLocal, String resultAway, Team teamLocal, Team teamAway) {
        this.id = id;
        this.resultLocal = resultLocal;
        this.resultAway = resultAway;   
        this.teamLocal = teamLocal;
        this.teamAway = teamAway;
        this.date = date;
    }        
    
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getResultLocal() {
		return resultLocal;
	}
	
	public Team getTeamLocal() {
		return teamLocal;
	}

	public void setTeamLocal(Team teamLocal) {
		this.teamLocal = teamLocal;
	}

	public Team getTeamAway() {
		return teamAway;
	}

	public void setTeamAway(Team teamAway) {
		this.teamAway = teamAway;
	}

	public String getResultAway() {
		return resultAway;
	}

	public void setResultAway(String resultAway) {
		this.resultAway = resultAway;
	}

	public void setResultLocal(String resultLocal) {
		this.resultLocal = resultLocal;
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
