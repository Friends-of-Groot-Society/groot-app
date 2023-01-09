package com.friendsofgroot.app.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "offers")
public class Offer {

	@Id
//	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "offerid", nullable = false)
	int offerID;
//	int userID;

	@Column(name = "username")
	String userName;
	@Column(name = "coinid")
	int coinId;
	@Column(name = "offeramt")
	double offerAmt;
	@Column(name = "offermos")
	int offerMos;
	@Column(name = "offerstatus")
	String offerStatus; // PENDING, APPROVED, REJECTED

	public Offer(String userName, int coinId, double offerAmt, int offerMos, String offerStatus) {
		this.userName = userName;
		this.coinId = coinId;
		this.offerAmt = offerAmt;
		this.offerMos = offerMos;
		this.offerStatus = offerStatus;
	}

	public String getUserName() {
		return userName;
	}

}
