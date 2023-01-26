package com.friendsofgroot.app.models;

import com.friendsofgroot.app.dto.NftDto;
import lombok.Data;

import javax.persistence.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT_ADDRESS")
public class NftAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	int id;

	 String address;

	@Column(name="native")
	Double nativeToken;
	HashMap<String, Double> tokens; // token name, token amount	@OneToOne
	@OneToMany
	@Column(name = "nft_address_id")
	List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}
