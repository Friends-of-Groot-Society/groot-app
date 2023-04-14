package com.friendsofgroot.app.models;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.persistence.*;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "NFT")
public class Nft extends BaseModel {
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	private String name;
	private int amount; // TODO needs DOUBLE PRCISION
	@OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	private Metadata metadata_id; // metadata_id

	@ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST})
	@JoinColumn(name = "nft_address_id")
	private NftAddress nftAddress;

}
