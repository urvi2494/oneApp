package com.cognizant.gateway.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.cognizant.gateway.model.User;
import com.cognizant.gateway.repository.UserRepository;


@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
    private UserRepository users;
   
	private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);
    
    public CustomUserDetailsService(UserRepository users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    	logger.info("inside loadUserByUsername-> username: "+username );
        Optional<User> userEntity=users.findById(username);
        logger.info("userEntity: "+userEntity.isPresent());
        if(!userEntity.isPresent())
        {
        	throw new UsernameNotFoundException("user not found exception");
        }
        
        else {
        	User user=userEntity.get();
       
        	logger.info("user: "+user.getUserId()+" role: "+user.getRole().getRoleName());
            Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
            grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
             return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
        }
         
    }
}