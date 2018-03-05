package Task_4_1;

public class MyExceptionOverTenStudents extends Exception {

	@Override
	public String getMessage() {
		return "Error - limit 10 students."; 
	}

}
