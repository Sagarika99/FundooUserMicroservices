 package com.bridgelabz.usermicroservices.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePasswordDTO {

	private String oldPassword;
	private String newPassword;
}
