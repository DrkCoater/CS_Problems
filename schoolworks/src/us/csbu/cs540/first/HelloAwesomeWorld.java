package us.csbu.cs540.first;

public class HelloAwesomeWorld {

	public static void main(String[] args) {
		Student s1 = new Student("Jeremy Lu");
		s1.setAddress("1 Infinite loop, Cuppertino, CA 95014");
		s1.setStudentNumber(28);
		System.out.println(s1);
		System.out.println("\n");
		
		// International Student
		InternationalStudent s2 = new InternationalStudent("Suman Gopal", "India");
		s2.setAddress("2 Infinite loop, Cuppertino, CA 95014");
		s1.setStudentNumber(29);
		System.out.println(s2.getName() + " is from " + s2.getNationality() + " with status: " + s2.getImmigrationStatus());
		s2.applyVisa(VisaType.STUDENT_VISA);
		System.out.println(s2.getName() + " just applied for student visa, and got: " + s2.getImmigrationStatus());
		s2.applyWorkPermit();
		System.out.println(s2.getName() + " just applied work permit, and got: " + s2.getImmigrationStatus() + " and " + (s2.hasWorkPermit() ? "now has working permit " : "failed to obtain work permit") );
		s2.changeStatus(ImmigrationStatus.GREEN_CARD);
		System.out.println(s2);
	}
}
