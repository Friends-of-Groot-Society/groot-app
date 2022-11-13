package com.friendsofgroot.app.dao;

import java.util.List;

import com.friendsofgroot.app.models.Groups;

public interface GroupsDao {

	public boolean addGroups(Groups u);
	public Groups getGroups(int id);
//	public Group getGroups(String username);
	public List<Groups> listGroups();
	public boolean updateGroups(Groups change);
	public boolean deleteGroups(int id);

}
