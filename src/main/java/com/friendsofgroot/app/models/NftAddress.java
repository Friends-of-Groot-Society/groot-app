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
@Table(name = "NFT_ADDRESS") /// ANGULAR's NFT.ts
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAddress extends BaseModel {

	private String address;  // VARCHAR(2550

	@Column(name = "native_token") // NUMBER (10,6)
	private Float nativeToken;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "nftAddress")
	@Column(name = "RAW_TOKEN")
	private List<RawToken> rawTokens;  //  "123.123456 BUSD  	// token name, token amount	@OneToOne

	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER, mappedBy = "nftAddress" )
	@Column(name = "NFT")
	private List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}



