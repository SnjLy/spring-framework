package com.snjly.spring.demo.model;

/**
 * @author : LiuYong at 2019-10-18
 * @package: com.snjly.spring.demo.model
 */

public class UserModel {

	private Integer id;
	private String userId;
	private String userName;
	private String nick;
	private Integer age;
	private Integer general;
	private String description;

	@Override
	public String toString() {
		return "UserModel{" +
				"id=" + id +
				", userId='" + userId + '\'' +
				", userName='" + userName + '\'' +
				", nick='" + nick + '\'' +
				", age=" + age +
				", general=" + general +
				", description='" + description + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getGeneral() {
		return general;
	}

	public void setGeneral(Integer general) {
		this.general = general;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
