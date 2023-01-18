package com.friendsofgroot.app.models;

import lombok.Data;

import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Entity
@Table(name = "NFT")
public class Nft {

	@Id
	int id;
	int name;
	int amount;
	@OneToOne
	@JoinColumn(name = "metadata_metaid")
	Metadata metadata;

	int nft_address_id;



}
