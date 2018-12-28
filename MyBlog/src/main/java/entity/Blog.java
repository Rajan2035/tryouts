package entity;

public class Blog {
	
	private long id;
	
	private String title;
	
	private String content;
	
	private User user;

	public Blog(long id, String title, String content, User user) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.user = user;
	}
	
	

}
