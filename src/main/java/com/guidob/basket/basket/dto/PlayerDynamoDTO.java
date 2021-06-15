package com.guidob.basket.basket.dto;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

//import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;


//@DynamoDbBean 
public class PlayerDynamoDTO {

 	String name;
    String position;
 
 
    public PlayerDynamoDTO(){}
    
    
    public PlayerDynamoDTO( String name, String position) {
        this.name = name;
        this.position = position;
    }        
    
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	

}
