package com.guidob.basket.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.guidob.basket.domain.User;
import com.guidob.basket.exceptions.UserErrorException;
import com.guidob.basket.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser (User newUser){

        try{
            newUser.setPassword(bCryptPasswordEncoder.encode(newUser.getPassword()));
            //Username has to be unique (exception)
            newUser.setUsername(newUser.getUsername());
            // Make sure that password and confirmPassword match
            // We don't persist or show the confirmPassword
            newUser.setConfirmPassword("");
            return userRepository.save(newUser);

        }catch (Exception e){
           // throw new UsernameAlreadyExistsException("Username '"+newUser.getUsername()+"' already exists");
         //	System.out.println("Error user service");
        //	return newUser;
            throw new UserErrorException("Username '"+newUser.getUsername()+"' error");
        	
        	
        }
		

    }
}   