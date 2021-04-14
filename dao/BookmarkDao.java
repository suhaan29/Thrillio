package thrillio.dao;

import thrillio.Bookmark;
import thrillio.UserBookmark;
import thrillio.data.DataStore;

public class BookmarkDao {
	
	public Bookmark[][] getBookmarks() {
		
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userBookmark) {
		// TODO Auto-generated method stub
		
		DataStore.add(userBookmark);
		
		
	}
	

}
