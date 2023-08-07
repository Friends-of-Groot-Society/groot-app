package com.friendsofgroot.app.models;

import lombok.*;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT")
public class Nft implements Serializable {
	@Serial
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MAKER")
	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@Column(name = "id" )
	private Integer id;



	private String name;
	private Double amount; // TODO needs DOUBLE PRCISION
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Metadata metadata_id; // metadata_id

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "NFTADDRESS_id")
	private NftAddress nftAddress;

}
