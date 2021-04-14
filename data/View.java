package thrillio.data;

import thrillio.Bookmark;
import thrillio.User;
import thrillio.constants.KidFriendlyStatus;
import thrillio.constants.UserType;
import thrillio.controller.BookmarkController;
import thrillio.partner.Shareable;

public class View {

	public static void browse(User user, Bookmark[][] bookmarks) {

		System.out.println("\n" + user.getEmail() + " is browsing the items");

		int bookmarkCount = 0;

		for (Bookmark[] bookmarkList : bookmarks) {
			for (Bookmark bookmark : bookmarkList) {
				// Bookmarking
				if (bookmarkCount < DataStore.USER_BOOKMARK_COUNT) {
					boolean isBookmarked = getBookmarkDecision(bookmark);
					if (isBookmarked) {
						bookmarkCount++;

						BookmarkController.getInstance().saveUserBookmark(user, bookmark);

						System.out.println("New item bookmarked" + bookmark);
					}
				}

				// Mark as KidFriendly

				if (user.getUserType().equals(UserType.EDITOR) || user.getUserType().equals(UserType.CHIEF_EDITOR)) {

					if (bookmark.isKidFriendlyEligible()
							&& bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
						String kidFriendlyStatus = getKidFriendlyStatusDecision(bookmark);
						
						if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN))
							
						{
							BookmarkController.getInstance().setKidFriendlyStatus(user, kidFriendlyStatus, bookmark);
							
						}
					}
					
					//sharing stuff
					if (bookmark.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED) && bookmark instanceof Shareable) {
						
						boolean isShared = getShareDecision();
						if (isShared) {
							BookmarkController.getInstance().share(user, bookmark);
						}
					}
				}
			}
		}

	}

	private static boolean getShareDecision() {
		// TODO Auto-generated method stub
		return Math.random() < 0.5 ? true : false;
		
	}

	private static String getKidFriendlyStatusDecision(Bookmark bookmark) {

		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8 ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN);
		// TODO Auto-generated method stub

	}

	private static boolean getBookmarkDecision(Bookmark bookmark) {
		// TODO Auto-generated method stub

		return Math.random() < 0.5 ? true : false;
	}

	/*
	 * public static void bookmark(User user, Bookmark[][] bookmarks) {
	 * System.out.println("\n" + user.getEmail() + " is bookmarking");
	 * 
	 * for(int i = 0; i < DataStore.USER_BOOKMARK_COUNT ; i++) { int typeOffset =
	 * (int) (Math.random() * DataStore.BOOKMARK_TYPE_COUNT); int bookmarkOffset =
	 * (int) (Math.random() * DataStore.BOOKMARK_COUNT_PER_TYPE);
	 * 
	 * Bookmark bookmark = bookmarks[typeOffset][bookmarkOffset];
	 * 
	 * BookmarkController.getInstance().saveUserBookmark(user, bookmark);
	 * 
	 * System.out.println(bookmark);
	 * 
	 * }
	 * 
	 * }
	 */

}
