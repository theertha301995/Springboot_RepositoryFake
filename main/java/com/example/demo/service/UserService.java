package com.example.demo.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.UserDetails;
import com.example.demo.Repository.UserRepository;

import io.jsonwebtoken.security.InvalidKeyException;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private JwtGenerator jwtGenerators;

	public UserService() {
		this.userRepository = userRepository;
	}

	public Map<String, String> signupUser(UserDetails userdata) throws Exception {
	    Long userId = userdata.getUser_id();
	   
	    String email = userdata.getEmail();
	    String name=userdata.getName();
	    validateEmailAndName(email,name);
	    String hashedPassword = hashPassword(userdata.getPassword());
	    userdata.setPassword(hashedPassword);
	  

	    Map<String, String> tokenmap = jwtGenerators.generateToken(userdata);
	    return tokenmap;
	  }
	

	private void validateEmailAndName(String email,String name)throws Exception {
		 if (email == null && name == null) {
		      throw new Exception("Email and name cannot be null or empty");
		    }
		 
		
	}

	private String hashPassword(String password) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] hashBytes = md.digest(password.getBytes());
		BigInteger number = new BigInteger(1, hashBytes);
		StringBuilder hexString = new StringBuilder(number.toString(16));
//        while (hexString.length() < 32) {
//            hexString.insert(0, '0');
//        }
		return hexString.toString();
	}

	public Map<String, String> loginUser(String email, String password) throws Exception {
		UserDetails user = userRepository.findByEmail(email);
		String hashedPassword = hashPassword(password);

		if (user != null && user.getPassword().equals(hashedPassword)) {

			Map<String, String> tokenMap = jwtGenerators.generateToken(user);
			return tokenMap;
		} else {
			throw new IllegalArgumentException("Invalid email or password");
		}
	}

}