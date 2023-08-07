package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import jakarta.persistence.*;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFTADDRESS") /// ANGULAR's NFT.ts
public class NftAddress extends BaseModel {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_MAKER")
	@SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
	@Column(name = "id" )
	private Integer id;

	@Column(name = "address", unique = true) // VARCHAR(255)
	private String address;  // VARCHAR(2550

	@Column(name = "native_token") // NUMBER (10,6)
	private Float nativeToken;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nftAddress")
	@Column(name = "raw_token")
	private List<RawToken> rawTokens;  //  "123.123456 BUSD  	// token name, token amount	@OneToOne

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "nftAddress" )
	@Column(name = "nft")
	private List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}
