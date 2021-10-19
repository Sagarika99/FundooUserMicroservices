package com.bridgelabz.usermicroservices.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

//import com.bridgelabz.fundoonotes.dto.LoginDTO;
//import com.bridgelabz.fundoonotes.dto.UpdatePasswordDTO;
//import com.bridgelabz.fundoonotes.dto.UserDTO;
//import com.bridgelabz.fundoonotes.entity.User;

import com.bridgelabz.usermicroservices.dto.*;
import com.bridgelabz.usermicroservices.entity.*;

public interface IUserService {

	public User register(UserDTO userDTO);
	public String login(LoginDTO loginDTO);
	public void verifyEmail(String token);
//	public void forgotPassword(String email);
//	public void resetPassword(String token,String password);
//	public List<User> getAllUsers();
//	public void updatePassword(String token,UpdatePasswordDTO updatePasswordDTO );
//	public String uploadProfilePic(String token,MultipartFile file);
	public boolean getuser(String token);
	
	
	
}
