package spring_security_with_jwt.security.jwtutils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring_security_with_jwt.service.JwtUserDetailsService;

/**
 * Controller for authentication
 *
 */
@RestController
@CrossOrigin
public class JwtController {

	/**
	 * We have autowired three dependencies: JwtUserDetailsService,
	 * AuthenticationManager and TokenManager.
	 * (the authentication manager bean is one we shall be creating in our WebSecurityConfig class.)
	 */
	@Autowired
	private JwtUserDetailsService userDetailsService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenManager tokenManager;

	
	@PostMapping("/login")
	public ResponseEntity<JwtResponseModel> createToken(@RequestBody JwtRequestModel request) throws Exception {

		/**
		 * AuthenticationManager class will take care of our authentication. We shall be
		 * using the UsernamePasswordAuthenticationToken model for authentication of the
		 * request. If authentication succeeds we shall generate a JWT for the user,
		 * which can be sent in the Authorization header of the subsequent requests to
		 * get any resource.
		 */
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
		
		/**
		 * As we can see, we are using the loadUserByUsername() method of our
		 * JwtUserDetailsService class and the generateJwtToken() from TokenManager
		 * class.
		 */
		final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
		
		/**
		 * This generated JWT is sent to the user as a response on successful
		 * authentication as mentioned above.
		 */
		final String jwtToken = tokenManager.generateJwtToken(userDetails);
		
		return ResponseEntity.ok(new JwtResponseModel(jwtToken));
	}
}