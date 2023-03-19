package com.friendsofgroot.app.dataLoader;

import com.friendsofgroot.app.dao.BookmarkDaoImpl;
import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.User;
import com.friendsofgroot.app.dto.UserBookmark;
import com.friendsofgroot.app.models.Weblink;
import com.friendsofgroot.app.util.DownloadSequential;
import com.friendsofgroot.app.util.ReadWriteFile;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	public static BookmarkDaoImpl bookmarkDaoImpl = new  BookmarkDaoImpl();
	
	private BookmarkManager() {}
	
	public static BookmarkManager getInstance() {
		return instance;
	}

 
	public Weblink createWeblink( long id, String url, String host ) {

		Weblink weblink = new Weblink();
		weblink.setId(id); 
		weblink.setUrl(url);
		weblink.setHost(host);
	return weblink;
	}


	public List<Bookmark> getLocalUserBookmarksByUser(User user) {
		return bookmarkDaoImpl.getLocalUserBookmarksByUser(user);
	}


	public static void saveLocalUserBookmark(User user, Bookmark bookmark) {
	    UserBookmark userBookmark = new UserBookmark();
	    userBookmark.setUser(user);
	    userBookmark.setBookmark(bookmark);
		bookmarkDaoImpl.saveLocalUserBookmark(userBookmark);   // JOIN TABLE

		if(bookmark instanceof Weblink) {
			try {
				String url = ((Weblink) bookmark).getUrl();
				if(!url.endsWith(".pdf")) {
					String website = DownloadSequential.downloadFromUrl(((Weblink) bookmark).getUrl());
					if(website != null) {
						ReadWriteFile.writeWebpage(website, bookmark.getId());
					}
				}
			} catch (IOException e) {
				throw new RuntimeException(e);
			} catch (URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
	    
	}


	public void share(User user, Bookmark bookmark) {
		bookmark.setSharedBy(user);
	System.out.println("Data to be shared by" + user + " : "+bookmark);
      if (bookmark instanceof Weblink) {
		System.out.println(((Weblink) bookmark).getItemData());

	}
}


}
