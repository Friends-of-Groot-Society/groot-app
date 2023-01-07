package net.ourdailytech.rest.webservice.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class PostEntity {
	
	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "DID")
	private String did;

	@Column(name = "DATE_")
	private String date;
	
	@Column(name = "AUTHOR")
	private String author;
	
	@Column(name = "MONTH_ORDER")
	private String monthOrder;
	
	@Column(name = "CAT3")
	private String cat3;
	
	@Column(name = "TITLE")
	private String title;
	
	@Column(name = "POST")
	private String post;
	
	@Column(name = "BLOGCITE")
	private String blogcite;	
	
	@Column(name = "USERNAME")
	private String username;
	 
	
	protected PostEntity() {
		
	}
	
	public PostEntity(Long id, String did, String date, String author, String monthOrder, String cat3, String title, String post,
			String blogcite, String username) {
		super();
		this.id = id;
		this.did = did;
		this.date = date;
		this.author = author;
		this.monthOrder = monthOrder;
		this.cat3 = cat3;
		this.title = title;
		this.post = post;
		this.blogcite = blogcite;
		this.username = username;
	}
 
 
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDid() {
		return did;
	}

	public void setDid(String did) {
		this.did = did;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getMonthOrder() {
		return monthOrder;
	}


	public void setMonthOrder(String monthOrder) {
		this.monthOrder = monthOrder;
	}
	public String getCat3() {
		return cat3;
	}

	public void setCat3(String cat3) {
		this.cat3 = cat3;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getBlogcite() {
		return blogcite;
	}

	public void setBlogcite(String blogcite) {
		this.blogcite = blogcite;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) { 
		this.username = username;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", did=" + did + ", date=" + date + ", author=" + author + ", monthOrder="
				+ monthOrder + ", cat3=" + cat3 + ", title=" + title + ", post=" + post + ", blogcite=" + blogcite
				+ ", username=" + username + "]";
	}

	 
	
}
