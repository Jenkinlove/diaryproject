package com.company.domain;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {
	private int uid;
	private String username;
	private String password;
	private String email;

	@Override
	public String toString() {
		return "User{" +
				"uid='" + uid + '\'' +
				", username='" + username + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
