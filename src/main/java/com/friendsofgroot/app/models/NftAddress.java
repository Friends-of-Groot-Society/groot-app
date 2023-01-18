package com.friendsofgroot.app.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT_ADDRESS")
public class NftAddress {
	@Id
	int id;
	String address;
	Double nativeToken;
	HashMap<String, Double> tokens; // token name, token amount
//	List<Nft> nfts; // nft id, nft name,  nft amount, metadata_id
}
