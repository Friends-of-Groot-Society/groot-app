package xyz.cryptomaven.app.models;

import java.util.HashMap;
import java.util.Map;

public class Nft {

	int nftId;
	String name;
	int amount;
	double priceTotal;
	int metadata;


	class nftmetadata {
		int metaid;
		String name;
		String description;
		String image;
		int attributes;
	}

	class nftattributes {
		int attrid;
		String value;
		String trait_type;
		Map<String, String> attrs = new HashMap<>();
		int attrsId;
	}
}
