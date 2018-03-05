package Task_4_1;

import java.io.Reader;

public class Student extends Person {

	private String card;
	private Integer course;

	public Student() {
		super();
	}

	public Student(String firstName, String lasrName, Integer age, String card, String sex, Integer course) {
		super(firstName, lasrName, sex, age);
		this.card = card;
		this.course = course;
	}

	public Student(String card, Integer course) {
		super();
		this.card = card;
		this.course = course;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Student : first name = " + getFirstName() + ", last name = " + getLastName() + ", age = " + getAge() + ", [card=" + card + ", course="
				+ course + "]";
	}

}
