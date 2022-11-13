package xyz.cryptomaven.app.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import xyz.cryptomaven.app.models.ElectroLot;
import xyz.cryptomaven.app.models.Groups;
import xyz.cryptomaven.app.util.JDBCConnection;

public interface GroupsDao {

	public boolean addGroups(Groups u);
	public Groups getGroups(int id);
//	public Group getGroups(String username);
	public List<Groups> listGroups();
	public boolean updateGroups(Groups change);
	public boolean deleteGroups(int id);

}
