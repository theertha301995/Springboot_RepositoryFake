package com.example.demo.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserDetails;
import com.example.demo.Repository.UserRepository;
import com.example.demo.config.TokenGenerator;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.InvalidKeyException;
import io.jsonwebtoken.security.Keys;
@Service

public class JwtGenerator implements TokenGenerator {
	@Autowired
	private UserRepository userRepository;

	
	public JwtGenerator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	@Override
	public Map<String, String> generateToken(UserDetails userdata)throws InvalidKeyException {
		   Map<String, String> jwtTokenGen = new HashMap<>();
		Map<String, String> claims = new HashMap<>();
		claims.put("username", userdata.getUser_name());
		claims.put("name", userdata.getName());
		claims.put("email", userdata.getEmail());
		userdata.setCreatedAt(new Date());
       UserDetails savedUser = userRepository.save(userdata);
        
        Date expiration = new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30));
  		 String token = null;
  		//try {
				token = Jwts.builder().claims(claims).subject(userdata.getUser_id().toString()) // Use user ID instead of password
 
						.issuer("theertha")
						.signWith(getSigningKey())
						.issuedAt(new Date()).expiration(expiration)
						.compact();
			//} catch (InvalidKeyException e) {
				
		//	} catch (Exception e) {
			//	e.printStackTrace();
		//	}
  		jwtTokenGen.put("token", token);
  		jwtTokenGen.put("message","Token generated successfully");
	    return jwtTokenGen;
	  
	  }
	 private SecretKey getSigningKey() {
	  	  byte[] keyBytes = Decoders.BASE64.decode("5367566B59703373367639792F423F4528482B4D6251655468576D5A71347437");
	  	  return Keys.hmacShaKeyFor(keyBytes);
		}
}