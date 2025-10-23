# TODO: Implement Spring Security with JWT

## Completed Tasks
- [x] Created SecurityConfig.java - Spring Security configuration
- [x] Created CustomUserDetailsService.java - User details service for authentication
- [x] Updated UsuarioCrudRepository.java - Added findByCorreo method
- [x] Created JwtUtil.java - JWT token generation and validation utility
- [x] Created JwtAuthenticationFilter.java - JWT authentication filter
- [x] Created AuthController.java - Authentication endpoint with console logging

## Pending Tasks
- [ ] Add Spring Security and JWT dependencies to pom.xml
- [ ] Test the implementation

## Dependencies to Add to pom.xml

Add the following dependencies inside the `<dependencies>` section of your pom.xml:

```xml
<!-- Spring Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT Dependencies -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.11.5</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.11.5</version>
    <scope>runtime</scope>
</dependency>
```

## Testing the Implementation

1. Start the application
2. Use POST /auth/login with JSON body: `{"username": "user@example.com", "password": "password"}`
3. Check console for logged credentials
4. Use the returned JWT token in Authorization header for protected endpoints

## Notes
- Passwords should be hashed using BCrypt (implemented in SecurityConfig)
- JWT tokens expire after 24 hours
- All endpoints except /auth/** are now protected
