package com.friendsofgroot.app.dao;

import com.friendsofgroot.app.models.Bookmark;
import com.friendsofgroot.app.models.Weblink;

import java.util.List;
 
public interface BookmarkDAO {

    public boolean createBookmark(Bookmark bookmark); // void
    public Bookmark getBookmark(int id);
    public List<Bookmark> getBookmarks();
    public boolean updateBookmark(Bookmark change); // void
    public boolean deleteBookmark(int id); // void 

    public List<List<Bookmark>> getBookmarksArray();
    public List<Weblink> getAllWebLinks();
    public List<Weblink> getWebLinks(Weblink.DownloadStatus downloadStatus);

}