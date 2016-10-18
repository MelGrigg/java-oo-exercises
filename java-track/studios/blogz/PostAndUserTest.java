package blogz;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.TestCase;

public class PostAndUserTest extends TestCase {
	
	String username1 = "Mel";
	String password1 = "password";
	
	String username2 = "Timmy";
	String password2 = "abc";
	
	String body1 = "body";
	String title1 = "title";

	@Test
	public void testUserInit() {
		User u1 = new User(username1, password1);
		assertEquals(username1, u1.getUsername());
		
		User u2 = new User(username2, password2);
		assertEquals(username2, u2.getUsername());
	}
	
	@Test
	public void testIsValidPassword() {
		User u1 = new User(username1, password1);
		assertEquals(true, u1.isValidPassword(password1));
		
		User u2 = new User(username2, password2);
		assertEquals(true, u2.isValidPassword(password2));
	}
	
	@Test
	public void testIsValidUsername() {
		assertEquals(true, User.isValidUsername("abcdefg"));
		assertEquals(true, User.isValidUsername("gfedcba"));
		assertEquals(true, User.isValidUsername("abc_k-efz"));
		assertEquals(false, User.isValidUsername("@%*#$@%*dfkjl"));
		assertEquals(false, User.isValidUsername("abc^"));
	}
	
	@Test
	public void testUsersList() {		
		assertEquals("Username 1 does not match", username1, (User.getUsers()).get(0).getUsername());
		assertEquals("Password 1 does not match", password1, (User.getUsers()).get(0).getPassword());
		
		assertEquals("Username 2 does not match", username2, (User.getUsers()).get(1).getUsername());
		assertEquals("Password 2 does not match", password2, (User.getUsers()).get(1).getPassword());
	}
	
	@Test
	public void testPostInit() {
		User u1 = new User("TestPerson", "cba");
		Post p1 = new Post(body1, title1, u1);
		assertEquals("Body not set properly", body1, p1.getBody());
		assertEquals("Title not set properly", title1, p1.getTitle());
		assertEquals("Username doesn't match", u1.getUsername(), p1.getAuthor().getUsername());
	}
	
	@Test
	public void testPostModified() {
		User u1 = new User("TestPerson2", "fedcba");
		Post p1 = new Post(body1, title1, u1);
		assertEquals("Created and modified don't match at creation", p1.getCreated().getTime(),
				p1.getModified().getTime());
		p1.setBody("alskjdf");
		p1.setTitle("ajlskdflkasj");
		p1.setBody("testingbody");
		p1.setTitle("testingtitle");
		assertEquals("Modified not working properly", false,
				(p1.getCreated().getTime() == p1.getModified().getTime()));
	}

}
