package spring_security_with_jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService { 
	
	/**
	 * Here, since this is a basic application for the sole purpose of the
	 * demonstration of JWT authentication, we have resorted to a set of our user
	 * details, instead of using a database. We have given the username as
	 * “randomuser123” and encoded the password, which is “password” as
	 * “$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6” for our
	 * convenience.
	 */
	
   @Override 
   public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      if ("randomuser123".equals(username)) { 
         return new User("randomuser123", 
            "$2a$10$slYQmyNdGzTn7ZLBXBChFOC9f6kFjAqPhccnP6DxlWXx2lPk1C3G6", 
            new ArrayList<>()); 
      } else { 
         throw new UsernameNotFoundException("User not found with username: " + username); 
      } 
   } 
}