package model;

public class User {
	private String userId;
	private String name;
	private String gender;
	private int age;
	private String emaile;
	private String password;
	private String location;
	
	public User() { }
	
	public User(String userID, String name, String gender, int age, String emaile, String password, String location) {
		this.userId = userID;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.emaile = emaile;
		this.password = password;
		this.location = location;
	}

	public String getUserID() {
		return userId;
	}

	public void setUserID(String userID) {
		userId = userID;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmaile() {
		return emaile;
	}

	public void setEmaile(String emaile) {
		this.emaile = emaile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public boolean matchPassword(String password) {
		if (password == null) {
			return false;
		}
		return this.password.equals(password);
	}
	
	public boolean isSameUser(String userid) {
        return this.userId.equals(userid);
    }

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", gender=" + gender + ", age=" + age + ", emaile="
				+ emaile + ", password=" + password + ", location=" + location + "]";
	}

}
