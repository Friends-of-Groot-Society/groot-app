package com.friendsofgroot.app.models;

import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "BOOKMARKS")
public class Bookmark implements Serializable {

	static final long serialVersionUID = 1L;
 	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String title;

	@Column(name="profileurl")
	private String profileUrl;


	@ManyToOne
	@JoinColumn(name = "shared_by_userid")
	private User sharedBy;

	@Column(name="owneremail")
	private String ownerEmail;
}
