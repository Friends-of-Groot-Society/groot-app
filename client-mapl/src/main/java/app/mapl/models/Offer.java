package app.mapl.models;

import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@RequiredArgsConstructor
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
	String username;
	@Column(name = "coinid")
	int coinId;
	@Column(name = "offeramt")
	double offerAmt;
	@Column(name = "offermos")
	int offerMos;
	@Column(name = "offerstatus")
	@Size(min=2, message="Enter at least 2 characters")
	String offerStatus; // PENDING, APPROVED, REJECTED;
	private String description;
	private LocalDate targetDate;
	private boolean done;

	public Offer(String username, int coinId, double offerAmt, int offerMos, String offerStatus) {
		this.username = username;
		this.coinId = coinId;
		this.offerAmt = offerAmt;
		this.offerMos = offerMos;
		this.offerStatus = offerStatus;
	}


	public String getUsername() {
		return username;
	}

}
