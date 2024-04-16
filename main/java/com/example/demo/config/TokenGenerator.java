package com.example.demo.config;

import java.util.Map;

import com.example.demo.Model.UserDetails;

public interface TokenGenerator {
Map<String,String>generateToken(UserDetails user);

}
