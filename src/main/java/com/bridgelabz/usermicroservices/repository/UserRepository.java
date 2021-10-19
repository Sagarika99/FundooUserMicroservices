package com.bridgelabz.usermicroservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//import com.bridgelabz.fundoonotes.dto.UserDTO;
//import com.bridgelabz.fundoonotes.entity.User;

import com.bridgelabz.usermicroservices.dto.*;
import com.bridgelabz.usermicroservices.entity.*;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

	public Optional<User> findByEmail(String email);
}
