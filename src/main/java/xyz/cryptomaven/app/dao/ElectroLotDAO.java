package xyz.cryptomaven.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import xyz.cryptomaven.app.dataLoader.TestDataStore;
import xyz.cryptomaven.app.models.Bookmark;
import xyz.cryptomaven.app.models.ElectroLot;
import xyz.cryptomaven.app.models.UserBookmark;
import xyz.cryptomaven.app.models.Weblink;
import xyz.cryptomaven.app.util.JDBCConnection;

public interface ElectroLotDAO {
	
	// CRUD operations for model 
	public boolean addElectroLot(ElectroLot el);
	public ElectroLot getElectroLot(int id);
	public ElectroLot getElectroLot(String username); // for calling db with username!!
	public List<ElectroLot> getAllElectroLot();
	public List<ElectroLot> getAllElectroLot(String username);
	public boolean updateElectroLot(ElectroLot change);
	public boolean deleteElectroLot(int id);


}
