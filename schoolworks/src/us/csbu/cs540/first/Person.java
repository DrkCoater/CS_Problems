package us.csbu.cs540.first;

/**
 * This class define a person
 * @author Charles
 *
 */
public class Person {
	
	protected String fullName;
	protected String address;
	
	public String getName(){
		return fullName;
	}
	
	public void setName(String name){
		this.fullName = name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public void setAddress(String address){
		this.address = address;
	}
	
	/**
	 * Create a string representation of a person
	 */
	
	public String toString() {
	      String printString = "   Name: " + getName() + "\n"; 
	            printString += "Address: " + getAddress() + "\n"; 
	      return printString;
	}

	/**
	 * main method to test the Person class
	 * @param args
	 */
	public static void main ( String [] args ) {

	  //Create a person object(instance of Person) and print it out.

	  Person joeMe = new Person();
	    joeMe.setName("Average Joe");
	    joeMe.setAddress ( "888 american way, Sunnyvale, CA 94085");
	    System.out.println ( joeMe );

	 }
}
