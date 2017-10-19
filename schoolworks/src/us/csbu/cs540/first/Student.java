package us.csbu.cs540.first;

/**
 * Homework
 * Student class extends Person class
 * @author JeremyLu
 * @version 0.0.1
 */
public class Student extends Person {

	protected int studentNumber;
	
	public Student(String fullName) {
		this.fullName = fullName;
	}
	
	public void setStudentNumber(int number) {
		this.studentNumber = number;
	}
	
	public int getStudentNumber() {
		return this.studentNumber;
	}
		
	public String toString() {
	      String printString = "          Name: " + getName() + "\n"; 
	            printString += "       Address: " + getAddress() + "\n"; 
	            printString += "Student Number: " + getStudentNumber() + "\n";
	      return printString;
	}

}
