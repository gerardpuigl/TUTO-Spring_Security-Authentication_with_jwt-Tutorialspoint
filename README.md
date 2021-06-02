## Spring Security JWT Tutorial
This exercice is done following this tutorial: https://www.tutorialspoint.com/spring_security/spring_security_with_jwt.htm

### Description
The application handle basic user authentication and authorization with JWT’s. 

The use of JWT token for authorization is the most common of its applications. The token is usually generated in the server and sent to the client where it is stored in the session storage or local storage. To access a protected resource the client would send the JWT in the header as given above. We will see the JWT implementation in Spring Security.

Each class has added the explanation of each class & method inside.

The order to read & understand this repository is:

1) TokenManager.java
2) JwtUserDetailsService.java
3) JwtRequestModel.java
4) JwtResponseModel.java
5) JwtController.java.java
6) JwtFilter.java
7) JwtAuthenticationEntryPoint.java
8) WebSecurityConfig.java

