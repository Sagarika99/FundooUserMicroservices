package com.bridgelabz.usermicroservices.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
//import com.bridgelabz.fundoonotes.dto.LoginDTO;
//import com.bridgelabz.fundoonotes.dto.UserDTO;
//import com.bridgelabz.fundoonotes.entity.User;
//import com.bridgelabz.fundoonotes.exception.FundooException;
//import com.bridgelabz.fundoonotes.response.Response;

//import com.bridgelabz.fundoonotes.service.IUserService;
import com.bridgelabz.usermicroservices.dto.*;
import com.bridgelabz.usermicroservices.response.*;
import com.bridgelabz.usermicroservices.entity.*;
import com.bridgelabz.usermicroservices.exception.*;
import com.bridgelabz.usermicroservices.service.*;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<Response> register(@Valid @RequestBody UserDTO userDTO,BindingResult result){
		if(result.hasErrors())
		{
			throw new FundooException(HttpStatus.UNPROCESSABLE_ENTITY.value(),result.getAllErrors().get(0).getDefaultMessage());
		}
		User user=userService.register(userDTO);
		return new ResponseEntity<Response>(new Response(HttpStatus.CREATED.value(),"User Registered Successfully",user), HttpStatus.CREATED);
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<Response> login(@RequestBody LoginDTO loginDTO){
		String token=userService.login(loginDTO);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"User login Successfully",token), HttpStatus.OK );
		
	}
	
	@GetMapping("/verify-email/{token}")
	public ResponseEntity<Response> verifyEmail(@PathVariable String token)
	{
		userService.verifyEmail(token);
		return new ResponseEntity<Response>(new Response(HttpStatus.OK.value(),"User Email verified Sucessfully",token),HttpStatus.OK);
	}
	
	@GetMapping("/isuserpresent/{token}")
	public boolean isuserpresent(@PathVariable(value="token") String token)
	{
		return userService.getuser(token);
	}
	
}
