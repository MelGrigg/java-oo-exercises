package blogz;

import java.util.ArrayList;
import java.util.regex.Pattern;

public class User extends Entity {
	
	private String username, password;
	private static ArrayList<User> users = new ArrayList<User>();
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = User.hashPassword(password);
		User.users.add(this);
	}
	
	private static String hashPassword(String pass) {
		return pass;
	}
	
	public boolean isValidPassword(String pass) {
		if (User.hashPassword(pass) == this.password)
			return true;
		return false;
	}
	
	public static boolean isValidUsername(String username) {
		return Pattern.matches("[a-zA-Z][a-zA-Z0-9_-]{4,11}", username);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public static ArrayList<User> getUsers() {
		return User.users;
	}

}
