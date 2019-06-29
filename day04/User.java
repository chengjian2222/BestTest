package day04.homework;
/*
 * id, name, gender, score, address
 * */
public class User {
	private String id;
	private String name;
	private String gender;
	private Integer score;
	private String address;
	
	public User(String id, String name, String gender, Integer score, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.address = address;
	}
	
	public String toString() {
		return "id = "+ this.id + ",name = " + this.name + ",gender = " + this.gender + ",score = " + this.score + ",address = " + this.address;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
