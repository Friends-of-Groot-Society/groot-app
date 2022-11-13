package xyz.cryptomaven.app.dao;

import xyz.cryptomaven.app.dataLoader.TestDataStore;
import xyz.cryptomaven.app.models.Nft;
import xyz.cryptomaven.app.models.UserNftbuy;
import xyz.cryptomaven.app.util.JDBCConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NftDAOimpl  implements NftDAO {

	public static Connection conn = JDBCConnection.getConnection();

///////////      CREATE     ///////////////
	public boolean createNft(Nft c) {
//		DB.nfts.put(c.getNftID(), c);
//		return true;

		String sql = "CALL add_new_nft(?,?,?,?)"; 
 
		try { 
			PreparedStatement cs = conn.prepareStatement(sql); 
			cs.setString(1, c.getNftMake());
			cs.setString(2, c.getNftModel()); 
			cs.setString(3, Double.toString(c.getPriceTotal())); 
			cs.setString(4, Integer.toString(c.isPurchased()));  
			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double-check DB connection on creating nfts");
			e.printStackTrace();
		}
		return false;
	}

//////////////  GET(ID)  ///////////////////
	public Nft getNft(int id) {
//		return DB.nfts.get(id);
		try {
			String sql = "SELECT * FROM nfttable WHERE nftid=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new Nft(rs.getInt("nftID"), rs.getString("nftMake"), rs.getString("nftModel"),
						rs.getDouble("priceTotal"), rs.getInt("purchased"));
			}
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-id");
			e.printStackTrace();
		}
		return null;
	}

	public List<Nft> getAllNftsIOwn(String username) { 
String sql = "SELECT o.username,  o.nftid,  o.offerstatus,  o.offermos, c.nftid, c.nftmake, c.nftmodel, c.pricetotal FROM offertable o JOIN nfttable c ON c.nftid = o.nftid WHERE o.offerstatus = 'APPROVED' AND o.username = ?";
	List<Nft> nft = new ArrayList<Nft>();
	try {
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, username);    //
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			nft.add(new Nft(rs.getInt("nftID"), rs.getString("nftMake"), rs.getString("nftModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
		}
		return nft;
	} catch (SQLException e) {
		System.out.println("Double-check DB connection on get-all-owned...");
		e.printStackTrace();
	}
	return null; 
	} 

////////////// GET OFFLINE CARS AND OFFERS ///////////////////
	@Override
	public List<Nft> getNfts() {
		return  TestDataStore.getNfts();
	}

////////////// GETALL (ADMIN VIEW)  ///////////////////
	public List<Nft> getAllNfts() {   // *Admin View of *all* nfts in NftLot (also purchased nfts).
//		List<Nft> nftList = new ArrayList<Nft>();
//		Set<Integer> keys = DB.nfts.keySet();
//		for(Integer k: keys)
//			nftList.add(DB.nfts.get(k));
//		return nftList;
		String sql = "SELECT * FROM nfttable";
		List<Nft> nft = new ArrayList<Nft>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nft.add(new Nft(rs.getInt("nftID"), rs.getString("nftMake"), rs.getString("nftModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
			}
			return nft;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on get-alls");
			e.printStackTrace();
		}
		return null;
	} 

//////////////GETALL (CUSTOMER VIEW)  ///////////////////
	public List<Nft> getAllNftsCust() {    // *Customer View of NftLot (Only unpurchased nfts).
		String sql = "SELECT * FROM nfttable WHERE purchased=?";
		List<Nft> nft = new ArrayList<Nft>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, 0);    //
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				nft.add(new Nft(rs.getInt("nftID"), rs.getString("nftMake"), rs.getString("nftModel"), rs.getDouble("priceTotal"), rs.getInt("purchased")));		
			}
			return nft;
		} catch (SQLException e) {
			System.out.println("Double-check DB connection on gets");
			e.printStackTrace();
		}
		return null;
	}

////////////// UPDATE  ///////////////////
	public boolean updateNft(Nft change) {
//		DB.nfts.replace(change.getNftID(), change); // (T t, String[] params); 
//		return true;
		String sql = "UPDATE nfttable SET nftMake=?, nftModel=?, priceTotal=?, purchased=? WHERE nftID = ?";
	
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, change.getNftMake());
			ps.setString(2, change.getNftModel()); 
			ps.setString(3, Double.toString(change.getPriceTotal())); 
			ps.setString(4, Integer.toString(change.isPurchased())); 
			ps.setString(5, Integer.toString(change.getNftId())); 
			ps.executeQuery();
			return true;
		} catch (SQLException e) {
			System.out.println("Double-check DB foreign-keys on updates");
			e.printStackTrace();
		}
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
		TestDataStore.add(userNftbuy);
	}


	 
}
