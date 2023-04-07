package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "user_accounts")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_accounts_seq")
	@Column(name = "user_id")
	private long userId;

	@Column(name = "username")
	private String username;

	private String email;

	private String password;

	private boolean enabled = true;

}
