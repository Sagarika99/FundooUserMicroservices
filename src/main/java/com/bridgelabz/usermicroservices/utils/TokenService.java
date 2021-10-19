package com.bridgelabz.usermicroservices.utils;

import java.util.Date;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.bridgelabz.usermicroservices.exception.*;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//import lombok.Value;

@Component
public class TokenService {

	@Value("${secret.token}")
	public String key;
	
	public String createToken(Long id) {
		SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
		JwtBuilder builder=Jwts.builder().setId(String.valueOf(id))
			.signWith(signatureAlgorithm, DatatypeConverter.parseString(key));
		return builder.compact();
	}
	
	public String createToken(Long id,Date expireTime) {
		SignatureAlgorithm signatureAlgorithm=SignatureAlgorithm.HS256;
		JwtBuilder builder=Jwts.builder().setId(String.valueOf(id))
				.setExpiration(expireTime)
			.signWith(signatureAlgorithm, DatatypeConverter.parseString(key));
		return builder.compact();
	}


public Long decodeToken(String token) {
	try {
		Claims claim=Jwts.parser().setSigningKey(DatatypeConverter.parseString(key)).parseClaimsJws(token)
				.getBody();
		return Long.parseLong(claim.getId());
	} catch (Exception e) {
		throw new FundooException(HttpStatus.BAD_REQUEST.value(),"Error while decoding token");
		// TODO: handle exception
	}
}
}
