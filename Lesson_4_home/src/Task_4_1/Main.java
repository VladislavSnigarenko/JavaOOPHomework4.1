package Task_4_1;

public class Main {

	public static void main(String[] args) throws MyExceptionOverTenStudents {

		// create new group
		Group group = new Group("Math_2016_2A");
		System.out.println(group); // group is empty

		// create students
		Student student1 = new Student("Belov", "Petr", 19, "KT-256879", "M", 4);
		Student student2 = new Student("Kuzminov", "Vladimir", 20, "KT-256015", "M", 1);
		Student student3 = new Student("Belov", "Andrey", 17, "KB-250241", "M", 2);
		Student student4 = new Student("Nikitin", "Oleg", 17, "KA-250240", "M", 3);
		Student student5 = new Student("Volkov", "Gleb", 17, "KA-250001", "M", 2);
		Student student6 = new Student("Belov", "Stac", 18, "KT-290244", "M", 4);
		Student student7 = new Student("Samsonov", "Vlad", 20, "KT-300841", "M", 2);
		Student student8 = new Student("Steblova", "Irina", 25, "KB-110091", "W", 5);
		Student student9 = new Student("Elexina", "Tatyana", 20, "EE-120111", "W", 2);
		Student student10 = new Student("Nituzova", "Olga", 22, "TT-220201", "W", 1);
		Student student11 = new Student("Sharuta", "Andre", 21, "KB-280123", "W", 2);
		Student student12 = new Student("Tomofeev", "Alex", 22, "LT-300152", "M", 2);

		// add student in group
		try {
			group.add(student1);
			group.add(student2);
			group.add(student3);
			group.add(student4);
			group.add(student5);
			group.add(student6);

			group.addInterActive();

			// output students from group
			System.out.println(group); // output 6 students

			group.add(student7);
			group.add(student8);
			group.add(student9);
			group.add(student10);
			group.add(student11); // Error - 11 student - not add
		} catch (MyExceptionOverTenStudents e) {
			System.out.println(e.getMessage());
		}

		// output students from group
		System.out.println(group); // output all students (10)

		// delete student from group
		group.remove(student5); // good - student exist in group
		group.remove("KA-250240"); // good - student exist in group / Nikitin, Oleg

		// delete student from group
		group.remove(student12); // bad - student not exist in group

		// output students from group
		System.out.println(group); // output all students (8)

		// search students
		System.out.println("Search : " + group.Search("")); // not found
		System.out.println("Search : " + group.Search("Titov")); // not found
		System.out.println("Search : " + group.Search("Steblova")); // found Steblova, Irina, 25, "KB-110091", 5

		// sort by first name
		System.out.println("");
		System.out.println("After sort by first name");
		group.SortByFirstName();
		System.out.println(group); // output all students (8)

		System.out.println("After sort by parametr default : first name");
		group.SortByParameter(); // default first name ASC
		System.out.println(group); // output all students (8)

		System.out.println("After sort by parametr age : DESC");
		group.SortByParameter(3, false); // Age DESC
		System.out.println(group); // output all students (8)

		System.out.println("");
		System.out.println("Voenkomat students : count = " + group.get—onscripts().length);
		for (Student student : group.get—onscripts()) {
			System.out.println(student);
		}

	}

}
