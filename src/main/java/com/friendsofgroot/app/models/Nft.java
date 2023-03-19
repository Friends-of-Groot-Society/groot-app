package com.friendsofgroot.app.models;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT")
public class Nft {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private int amount;
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Metadata metadata_id; // metadata_id
//	@OneToOne //(orphanRemoval = true)
//	private NftRef nftRef;

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "nft_address_id")
	private NftAddress nftAddress;

}
