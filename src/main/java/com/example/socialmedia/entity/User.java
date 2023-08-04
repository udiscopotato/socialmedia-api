package com.example.socialmedia.entity;



import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Nonnull
	private String userid;
	
	private String username;
	private String fullname;
	private int age;
	private String profilepic;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int id, String userid, String username, String fullname, int age, String profilepic) {
		super();
		this.id = id;
		this.userid = userid;
		this.username = username;
		this.fullname = fullname;
		this.age = age;
		this.profilepic = profilepic;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfilepic() {
		return profilepic;
	}
	public void setProfilepic(String profilepic) {
		this.profilepic = profilepic;
	}
	
	
}
