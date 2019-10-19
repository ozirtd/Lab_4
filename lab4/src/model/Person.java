package model;

public class Person implements Comparable<Person>{
	public static final String FEMALE = "Female";
	public static final String MALE = "Male";
	
	private String id;
	private String first_name;
	private String last_name;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	
	private Person right;
	private Person left;
	private Person prev;
	private Person next;
	

	public Person(String id, String first_name, String last_name, String email, String gender, String country,
			String photo, String birthday) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
	}

	@Override
	public int compareTo(Person otherPerson) {
		return id.compareTo(otherPerson.id);
	}

	
	@Override
	public String toString() {
		return "id= " + id + "\n" +  "first_name=" + first_name + "\n" + "last_name=" + last_name + "\n" + "email=" + email
				+ "\n"+ "gender=" + gender + "\n" + "country=" + country + "\n" + "birthday=" + birthday;
	}

	
	public Person getRight() {
		return right;
	}

	
	public void setRight(Person right) {
		this.right = right;
	}

	public Person getLeft() {
		return left;
	}


	public void setLeft(Person left) {
		this.left = left;
	}

	
	public Person getPrev() {
		return prev;
	}

	
	public void setPrev(Person prev) {
		this.prev = prev;
	}

	
	public Person getNext() {
		return next;
	}

	
	public void setNext(Person next) {
		this.next = next;
	}

	
	public String getId() {
		return id;
	}
	
	
	public String getPhoto() {
		return photo;
	}

	
	public String getFirst_name() {
		return first_name;
	}

	
	public String getLast_name() {
		return last_name;
	}

	
	public String getCountry() {
		return country;
	}
	
	
	
}

