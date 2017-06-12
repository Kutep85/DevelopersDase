package model;

public class Developer implements Comparable<Developer> {
	private int id;
	private String firstName;
	private String lastName;
	private int experience;
	private String specialty;
	private int salary;
	
	public Developer() {
	}
	
	public Developer(String firstName, String lastName, String specialty, int experience, int salary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.specialty = specialty;
		this.experience = experience;
		this.salary = salary;
	}
	
	public String getSpecialty() {
		return specialty;
	}
	public void setSpecialty(String specialty) {
		this.specialty = specialty;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return "" + id + ", " + firstName + ", " + lastName + ", " + specialty + ", " + experience + ", " + salary + "\n";
	}

	@Override
	public int compareTo(Developer dev) {
		return (Integer.compare(this.id, dev.id));
	}
}
