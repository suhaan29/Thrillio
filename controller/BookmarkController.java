package thrillio.controller;

import thrillio.Bookmark;
import thrillio.User;
import thrillio.managers.BookmarkManager;

public class BookmarkController {

	private BookmarkController() {}
	
	private static BookmarkController instance = new BookmarkController();
	
	public static BookmarkController getInstance() {
		return instance; 
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		
		BookmarkManager.getInstance().saveUserBookmark(user, bookmark);
		
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		
		//relaying into manager since we do not want business logic
		
		BookmarkManager.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
		
	}

	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		
		BookmarkManager.getInstance().share(user, bookmark);
		
	}
}
