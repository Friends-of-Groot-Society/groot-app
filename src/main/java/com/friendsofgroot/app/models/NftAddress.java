package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.friendsofgroot.app.dto.NftDto;
import lombok.Data;

import jakarta.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT_ADDRESS") /// ANGULAR's NFT.ts
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id" )
	private int id;

	private String address;

	@Column(name = "native_token")
	private Double nativeToken;

	@Column(name = "native")
	private Double nativeTokenAmount;
	@Column(name = "tokens")
	private Float tokensAmount;
	// token name, token amount	@OneToOne
	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "nftAddress" )
	@Column(name = "nfts")
	private List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}



