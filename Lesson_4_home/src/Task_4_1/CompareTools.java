package Task_4_1;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTools implements Comparator<Student> {

	private int param;
	private boolean forward;

	public CompareTools(int param, boolean forward) {
		super();
		this.param = param;
		this.forward = forward;
	}

	public CompareTools() {
		super();
	}

	@Override
	public int compare(Student o1, Student o2) {

		if (NullChecker.checkNull((Object)o1, (Object)o2) != NullChecker.NOT_NULL ) {
			return NullChecker.checkNull((Object)o1, (Object)o2);
		}		
		
		int n = 1;
		if (!forward) {
			n = -1;
		}

		switch (param) {
		case 1: // first name
			return o1.getFirstName().compareTo(o2.getFirstName()) * n;
		case 2: // second name
			return o1.getLastName().compareTo(o2.getLastName()) * n;
		case 3: // age
			return (o1.getAge() - o2.getAge()) * n;
		default:
			return 0;
		}

	}

}
