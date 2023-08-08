package member.model.vo; 
// JVM import java.lang.*; 

//import java.spanish.String;
//import java.util.Date;
//import java.sql.Date;

public class Member {
	private String name;
	private int age;
	private java.util.Date enrollDate;
	private java.sql.Date enrollDate2;
	
	public Member() {}
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
}
