package com.friendsofgroot.app.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@ToString
@Entity
public class UserAccount extends User {

	@Column( unique = true )
	private String username;

	@Column( unique = true )
	private String email;

	private String password;

	private int isActive = 1;


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
		UserAccount that = (UserAccount) o;
		return false;
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
}
