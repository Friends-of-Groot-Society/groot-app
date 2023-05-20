package app.mapl.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_accounts")
public class UserAccount extends BaseModel {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="user_accounts_seq")
	@Column(name = "user_id")
	private int userId;

	@Column(name = "username")
	private String username;

	private String email;

	private String password;

	private boolean enabled = true;

}
