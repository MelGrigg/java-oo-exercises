package blogz;

import java.time.Instant;
import java.util.Date;

public class Post {
	
	private String body, title;
	private User author;
	private final Date created;
	private Date modified;
	
	public Post(String body, String title, User author) {
		this.body = body;
		this.title = title;
		this.author = author;
		this.created = Date.from(Instant.now());
		this.modified = this.created;
	}
	
	public String getBody() {
		return this.body;
	}
	
	public void setBody(String s) {
		this.body = s;
		this.modified = Date.from(Instant.now());
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public void setTitle(String s) {
		this.title = s;
		this.modified = Date.from(Instant.now());
	}
	
	public User getAuthor() {
		return this.author;
	}
	
	public Date getCreated() {
		return this.created;
	}
	
	public Date getModified() {
		return this.modified;
	}

}
