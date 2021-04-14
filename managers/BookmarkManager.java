package thrillio.managers;

import thrillio.Book;
import thrillio.Bookmark;
import thrillio.Movie;
import thrillio.User;
import thrillio.UserBookmark;
import thrillio.WebLink;
import thrillio.dao.BookmarkDao;

public class BookmarkManager {
	
	private static BookmarkDao dao = new BookmarkDao();

	private static BookmarkManager instance = new BookmarkManager();

	private BookmarkManager() {

	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {

		Movie movie = new Movie();

		movie.setId(id);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);
		movie.setTitle(title);
		movie.setReleaseYear(releaseYear);
		movie.setProfileUrl(profileUrl);

		return movie;

	}

	public Book createBook(int publicationYear, String publisher, String[] author, String genre, double amazonRating,
			long id, String title, String profileUrl) {
		
		Book book = new Book();

		book.setAmazonRating(amazonRating);
		book.setAuthor(author);
		book.setGenre(genre);
		book.setId(id);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setTitle(title);

		return book;
	}

	public WebLink createWebLink(long id, String title, String url, String host) {

		WebLink weblink = new WebLink();
		weblink.setHost(host);
		weblink.setId(id);
		weblink.setProfileUrl(url);
		weblink.setTitle(title);
		weblink.setUrl(url);
		
		return weblink;
		
	}
	
	public Bookmark[][] getBookmarks(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		UserBookmark userBookmark = new UserBookmark();
		userBookmark.setBookmark(bookmark);
		userBookmark.setUser(user);
		
		dao.saveUserBookmark(userBookmark);
	}

	public void setKidFriendlyStatus(User user, String kidFriendlyStatus, Bookmark bookmark) {
		// TODO Auto-generated method stub
		bookmark.setKidFriendlyStatus(kidFriendlyStatus);
		bookmark.setKidFriendlyMarkedBy(user);
		System.out.println("Kid Friendly Status : " + kidFriendlyStatus + ',' + bookmark + " marked by " + user.getEmail());
		
	}

	public void share(User user, Bookmark bookmark) {
		// TODO Auto-generated method stub
		
		bookmark.setSharedBy(user);
		System.out.println("data to be shared: ");
		
		if (bookmark instanceof Book) {
			System.out.println(((Book)bookmark).getItemData());
		}
		else if (bookmark instanceof WebLink)
		{
			System.out.println(((WebLink)bookmark).getItemData());

		}
		
	}
}
