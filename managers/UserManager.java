package thrillio.managers;

import thrillio.User;
import thrillio.dao.UserDao;

//we will be applying the singleton login behind this which
//means only one object should be created 

public class UserManager {
	
	private static UserDao dao = new UserDao();

	private static UserManager instance = new UserManager();

	private UserManager() {
	} // wont create an instance so to create a singleton

	public static UserManager getInstance() {
		return instance;
	} // creating a singleton

	public User createUser(long id, String email, String password, String firstName, String lastName, int gender,
			String userType) {

		User user = new User();
		user.setId(id);
		user.setEmail(email);
		user.setPassword(password);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setGender(gender);
		user.setUserType(userType);
		
		return user;
	}
	
	public User[] getUsers() {
		return dao.getUsers();
	}

}
