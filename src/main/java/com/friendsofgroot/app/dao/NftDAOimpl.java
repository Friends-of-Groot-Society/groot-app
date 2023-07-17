package com.friendsofgroot.app.dao;

import com.friendsofgroot.app.dataLoader.FileDataStore;
import com.friendsofgroot.app.models.Nft;
import com.friendsofgroot.app.models.dto.UserNftbuy;
import com.friendsofgroot.app.config.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class NftDAOimpl  implements NftDAO {

	public static Connection conn = JDBCConnection.getConnection();

///////////      CREATE     ///////////////
	public boolean createNft(Nft c) {

		return false;
	}

//////////////  GET(ID)  ///////////////////
	public Nft getNft(int id) {

		return null;
	}

	public List<Nft> getAllNftsIOwn(String username) {

	return null;
	}

////////////// GET OFFLINE CARS AND OFFERS ///////////////////
	@Override
	public List<Nft> getNfts() {
		return  FileDataStore.getNfts();
	}

////////////// GETALL (ADMIN VIEW)  ///////////////////
	public List<Nft> getAllNfts() {   // *Admin View of *all* nfts in NftLot (also purchased nfts).

		return null;
	}

//////////////GETALL (CUSTOMER VIEW)  ///////////////////
	public List<Nft> getAllNftsCust() {    // *User View of NftLot (Only unpurchased nfts).

		return null;
	}

////////////// UPDATE  ///////////////////
	public boolean updateNft(Nft change) {

		return false;

	}

////////////// DELETE ///////////////////  *Not to be used in order to preserve records.
	public boolean deleteNft(int id) {
//		DB.nfts.remove(id);
//		return true;
		String sql = "DELETE nfttable WHERE nftid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			System.out.println("Double-check DB foreign-keys on deletions");
			e.printStackTrace();
		}
		return false;
	}

	public void saveUserNftbuy(UserNftbuy userNftbuy) {
		FileDataStore.add(userNftbuy);
	}



}
