package com.friendsofgroot.app.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter @Setter @ToString
@Table(name = "offers")
public class Offer {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
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

//
//	public Offer(int offerID, String userName, int coinId, double offerAmt, int offerMos, String offerStatus) {
////		super();
//		this.offerID = offerID;
//		this.userName = userName;
//		this.coinId = coinId;
//		this.offerAmt = offerAmt;
//		this.offerMos = offerMos;
//		this.offerStatus = offerStatus;
//	}
 
	// userName integer not string passed
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

//
//
//	public int getOfferID() {
//		return offerID;
//	}
//
//	public void setOfferID(int offerID) {
//		this.offerID = offerID;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public int getCoinId() {
//		return coinId;
//	}
//
//	public void setCoinId(int coinId) {
//		this.coinId = coinId;
//	}
//
//	public double getOfferAmt() {
//		return offerAmt;
//	}
//
//	public void setOfferAmt(double offerAmt) {
//		this.offerAmt = offerAmt;
//	}
//
//	public int getOfferMos() {
//		return offerMos;
//	}
//
//	public void setOfferMos(int offerMos) {
//		this.offerMos = offerMos;
//	}
//
//	public String getOfferStatus() {
//		return offerStatus;
//	}
//
//	public void setOfferStatus(String offerStatus) {
//		this.offerStatus = offerStatus;
//	}
//
//	@Override
//	public String toString() {
//		return "\nOffer: #" + offerID + ", Offer Status=" + offerStatus + ", Offer by: *" + userName + "*, \n   Coin: #"
//				+ coinId + ", Offer: $" + offerAmt + " over " + offerMos + " months\n"
//						+ "---------------------------";
//	}

}
