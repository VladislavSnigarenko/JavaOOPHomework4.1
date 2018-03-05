package Task_4_1;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements Voenkom {

	private String name;
	private Student[] students = new Student[10];

	public Group(String name) {
		this.name = name;
	}

	public Group() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addInterActive() throws MyExceptionOverTenStudents {
		try {
			String firstName = getString("First Name");
			String lastName = getString("Last Name");
			Integer age = getInt("Age");
			String card = getString("Card");
			String sex = getString("Sex");
			Integer course = getInt("Course");
			add(new Student(firstName, lastName, age, card, sex, course));
		} catch (MyExceptionOverTenStudents | IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	private String getString(String title) {
		String result = JOptionPane.showInputDialog("Input : " + title);
		if (result == null) {
			throw new IllegalArgumentException("Cancel input studenet");
		}
		return result;
	}

	private Integer getInt(String title) {
		String result = JOptionPane.showInputDialog("Input : " + title);
		if (result == null) {
			throw new IllegalArgumentException("Cancel input studenet");
		}
		return Integer.parseInt(result);
	}

	public void add(Student student) throws MyExceptionOverTenStudents {
		if (student == null) {
			throw new IllegalArgumentException("Student not exist");
		}
		int freeIndex = getFreeIndex();
		try {
			students[freeIndex] = student;
		} catch (Exception e) {
			throw new MyExceptionOverTenStudents();
		}
	}

	private int getFreeIndex() {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null)
				return i;
		}
		return -1;
	}

	public void remove(Student student) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				students[i] = null;
				System.out.println(student + " remove from group : " + name);
				return;
			}
		}
		System.out.println("Not exist : " + student + " in group : " + name);
	}

	public void remove(String card) {
		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && card.equals(students[i].getCard())) {
				System.out.println(students[i] + " remove from group : " + name);
				students[i] = null;
				return;
			}
		}
		System.out.println("Not exist student with card : " + card + " in group : " + name);
	}

	public Student Search(String firstName) {
		if (firstName.isEmpty()) {
			return null;
		}

		for (int i = 0; i < students.length; i++) {
			if (students[i] != null && firstName.equals(students[i].getFirstName())) {
				return students[i];
			}
		}
		return null;
	}

	public void SortByFirstName() {
		Student temp;
		for (int i = 0; i < students.length; i++) {
			for (int j = i; j < students.length; j++) {
				if (getFlagSort(students[i], students[j]) > 0) {
					temp = students[i];
					students[i] = students[j];
					students[j] = temp;
				}
			}
		}
	}

	private int getFlagSort(Student studentFirst, Student studentSecond) {

		if (studentFirst == null && studentSecond == null) {
			return 0;
		}

		if (studentFirst == null) {
			return 1;
		}

		if (studentSecond == null) {
			return -1;
		}

		return studentFirst.getFirstName().compareTo(studentSecond.getFirstName());
	}

	public void SortByParameter() {
		SortByParameter(1, true);
	}

	public void SortByParameter(int i) {
		SortByParameter(i, true);
	}

	public void SortByParameter(int i, boolean forward) {
		Arrays.sort(students, new CompareTools(i, forward));
	}

	@Override
	public Student[] getÑonscripts() {

		if (getCountÑonscripts() == 0) {
			return null;
		}

		Student[] Ñonscripts = new Student[getCountÑonscripts()];
		int count = 0;
		for (Student student : students) {
			if (isStudentÑonscript(student)) {
				Ñonscripts[count] = student;
				count += 1;
			}
		}
		return Ñonscripts;
	}

	private int getCountÑonscripts() {
		int count = 0;
		for (Student student : students) {
			if (isStudentÑonscript(student)) {
				count += 1;
			}
		}
		return count;
	}

	private boolean isStudentÑonscript(Student student) {
		if ((student != null) && (student.getSex().equals(new String("M"))) && (student.getAge() > 18)) {
			return true;
		}
		return false;
	}

	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		for (Student student : students) {
			builder.append(student + "\n");
		}

		return builder.toString();
	}

}
