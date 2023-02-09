package db;

import java.sql.Timestamp;

public class MemberDTO {
	// 데이터를 담아서 다른 클래스 전달 
	//멤버변수 => 데이터 은닉 => 캡슐화
	private String id;
	private String pass;
	private String name;
	private Timestamp date;
	
	// set get 메서드
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
}
