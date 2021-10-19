package com.bridgelabz.usermicroservices.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String firstName;
	
	private String lastName;
	
	@Column(nullable=false,unique=true)
	private String mobileNumber;
	
	
	@Column(nullable=false,unique=true)
	private String email;
	
	
	@Column(nullable=false,unique=true)
	private String password;
	
	private Boolean isEmailVerified;
	
	private String profileURL;
	
	@CreationTimestamp
	private LocalDateTime createdTimeStamp;
	
	@UpdateTimestamp
	private LocalDateTime updatedTimeStamp;
//	
//	@OneToMany(targetEntity=Note.class)
//	@JoinColumn(name="user_id")
//	private List<Note> notes;
//	
//	
//	@OneToMany(targetEntity=Label.class)
//	@JoinColumn(name="user_id")
//	private List<Label> labels;  
	
	
}
