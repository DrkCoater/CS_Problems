/**
 * 
 */
package us.csbu.cs540.first;
import java.util.Random;

/**
 * @author JeremyLu
 *
 */
public class InternationalStudent extends Student implements immigrationProcess {
	
	private String nationality;
	private ImmigrationStatus immigrationStatus;
	private boolean hasWorkPermit;

	public InternationalStudent(String fullName, String nationality) {
		super(fullName);
		this.nationality = nationality;
		this.immigrationStatus = ImmigrationStatus.REFUGEE;
		this.hasWorkPermit = false;
	}

	/**
	 * Adding optional parameters
	 * @param fullName
	 * @param nationality
	 * @param status
	 */
	public InternationalStudent(String fullName, String nationality, ImmigrationStatus status) {
		super(fullName);
		this.nationality = nationality;
		this.immigrationStatus = status;
		this.hasWorkPermit = false;
	}
	
	/**
	 * Adding optional parameters
	 * @param fullName
	 * @param nationality
	 * @param status
	 * @param hasWorkPermit
	 */
	public InternationalStudent(String fullName, String nationality, ImmigrationStatus status, boolean hasWorkPermit) {
		super(fullName);
		this.nationality = nationality;
		this.immigrationStatus = status;
		this.hasWorkPermit = hasWorkPermit;
	}
	
	public String toString() {
	      String printString = "              nationality: " + getNationality() + "\n"; 
	            printString += "	   immigration Status: " + getImmigrationStatus() + "\n"; 
	            printString += "allowed to work in the US: " + (hasWorkPermit() ? "YES" : "NO") + "\n";
	      return super.toString() + printString;
	}
	
	/**
	 * @return 
	 */
	public String getNationality() {
		return nationality;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean hasWorkPermit() {
		return this.hasWorkPermit;
	}
	
	/**
	 * 
	 * @param hasWorkPermit
	 */
	public void setHasWorkPermit(boolean hasWorkPermit) {
		this.hasWorkPermit = hasWorkPermit;
	}
	
	/**
	 * 
	 * @return
	 */
	public ImmigrationStatus getImmigrationStatus() {
		return this.immigrationStatus;
	}
	
	/**
	 * 
	 * @param status
	 */
	public void setStatus(ImmigrationStatus status) {
		this.immigrationStatus = status;
	}
	
	/**
	 * 
	 * @param rate
	 * @return
	 */
	public static boolean passBySuccessRate(float rate) {
		Random rand = new Random();
		int randomInt = rand.nextInt(100) + 1; // 1 ~ 100
		if (randomInt >= Math.floor(100 - rate*100)) {
			return true;
		}
		return false;
	}

	@Override
	public void changeStatus(ImmigrationStatus newStatus) {
		this.immigrationStatus = newStatus;
	}

	@Override
	public boolean applyVisa(VisaType type) {
		// make it 40% success rate
		boolean isSuccess = InternationalStudent.passBySuccessRate((float) 0.4);
		if (isSuccess) {
			switch(type) {
				case WORK_VISA:
					this.hasWorkPermit = true;
					this.immigrationStatus = ImmigrationStatus.WORKING_VISA;
					break;
				case STUDENT_VISA:
					this.immigrationStatus = ImmigrationStatus.STUDENT_VISA;
					break;
				case TRAVEL_VISA:
					this.immigrationStatus = ImmigrationStatus.TRAVEL_VISA;
					break;
			default:
				break;
			}
		}
		return isSuccess;
	}
	
	@Override
	public boolean applyWorkPermit() {
		// make it 60% success rate
		boolean isSuccess = InternationalStudent.passBySuccessRate((float) 0.6);
		if (isSuccess) {
			this.hasWorkPermit = true;
		}
		return isSuccess;
	}
}
