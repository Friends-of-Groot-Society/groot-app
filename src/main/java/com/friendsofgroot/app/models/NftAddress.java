package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.friendsofgroot.app.dto.NftDto;
import lombok.*;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT_ADDRESS") /// ANGULAR's NFT.ts
@JsonIgnoreProperties(ignoreUnknown = true)
public class NftAddress extends BaseModel {
	private static final long serialVersionUID = 1L;
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
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.MERGE, mappedBy = "nftAddress" )
	@Column(name = "nfts")
	private List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}



