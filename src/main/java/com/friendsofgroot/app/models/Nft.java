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
	int id;
	String name;
	int amount;
	@OneToOne
	@JoinColumn(name = "metadata_metaid")
	Metadata metadata;
	int nft_address_id;


}
