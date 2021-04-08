package com.springboot.web;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoder {
	public static void main(String [] args) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		String rawpassword="nam2020";
		String encodePassword=encoder.encode(rawpassword);
	
System.out.print(encodePassword);	
}

}
