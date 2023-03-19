package com.friendsofgroot.app.dto;

import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.User;

public class UserBookmark {
	private User user;
	private Bookmark bookmark;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Bookmark getBookmark() {
		return bookmark;
	}
	public void setBookmark(Bookmark bookmark) {
		this.bookmark = bookmark;
	}
	
	
}
