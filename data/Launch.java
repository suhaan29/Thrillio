package thrillio.data;
import thrillio.*;
import thrillio.managers.BookmarkManager;
import thrillio.managers.UserManager;

public class Launch {
	
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {
		// TODO Auto-generated method stub
		System.out.println("1. Loading data...");
		DataStore.loadData();
		
		users = UserManager.getInstance().getUsers();
		bookmarks = BookmarkManager.getInstance().getBookmarks();
		
		System.out.println("Printing data...");
		printUserDate();
		printBookmarkDate();
		
	}

	private static void printBookmarkDate() {
		// TODO Auto-generated method stub
		for(Bookmark[] bookmarkList : bookmarks) //this is how you traverse a 2d array 
		{
			for(Bookmark bookmark : bookmarkList)
			{
				System.out.println(bookmark);
			}
		}
		
	}

	private static void printUserDate() {
		// TODO Auto-generated method stub
		
		for(User user : users)
		{
			System.out.println(user);
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		loadData();
		startBookmarking();

	}

	private static void startBookmarking() {
		// TODO Auto-generated method stub
		System.out.println("2. Loading data(bookmarking)");
		for(User user : users)
		{
			View.bookmark(user, bookmarks);
		}
		
	}

	

}
