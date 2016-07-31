package com.chen.bean;

public class User 
{
	public User()
	{
		this.name = "陈";
		this.age = 18;
		this.sex = "男";
		this.nickname = "jack";
		this.array = new String []{"one","two","three"};
	}
	
	private String name;
	private String sex;
	private int age;
	private String nickname;
	private String 家乡;
	private String [] array;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String get家乡() {
		return 家乡;
	}
	public void set家乡(String 家乡) {
		this.家乡 = 家乡;
	}
	public String[] getArray() {
		return array;
	}
	public void setArray(String[] array) {
		this.array = array;
	}
	
}
