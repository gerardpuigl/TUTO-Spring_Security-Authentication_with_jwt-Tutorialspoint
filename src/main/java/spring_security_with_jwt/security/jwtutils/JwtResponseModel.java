package spring_security_with_jwt.security.jwtutils;

import java.io.Serializable;

public class JwtResponseModel implements Serializable {
	/**
	 * Below is the code for response model on successful authentication. As we can
	 * see, we will be sending the token back to the user on successful
	 * authentication.
	 */
	
	private static final long serialVersionUID = 1L;
	private final String token;

	public JwtResponseModel(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}
}
