/**
 * 
 */
package us.csbu.cs540.first;

/**
 * @author JeremyLu
 *
 */
public interface immigrationProcess {
	/**
	 * 
	 * @param type
	 * @return
	 */
	boolean applyVisa(VisaType type);
	
	/**
	 * 
	 * @return
	 */
	boolean applyWorkPermit();
	
	/**
	 * 
	 * @param newStatus
	 */
	void changeStatus(ImmigrationStatus newStatus);
}
