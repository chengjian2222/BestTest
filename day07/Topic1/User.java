package day07.homework.Topic1;

//id, name, gender, score, address
public class User {
	private int id;
	private String name;
	private String gender;
	private int score;
	private String address;

	public User() {
		super();
	}

	public User(int id, String name, String gender, int score, String address) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.score = score;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", gender=" + gender + ", score=" + score + ", address=" + address
				+ "]";
	}

}
