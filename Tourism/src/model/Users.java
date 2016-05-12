
package model;

/**
 * This class is used as a model of user
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
public class Users {
	// The type of the user
	private String type;
	// The number of login
	private int count;

	public Users() {

	}

	/**
	 * The constructor of the class Users
	 * 
	 * @param type
	 *            The type of the user
	 * @param count
	 *            The times of login
	 */
	public Users(String type, int count) {
		this.setType(type);
		this.setCount(count);
	}

	/**
	 * This method is used to set the character 'count'
	 * 
	 * @param count
	 *            The number of login
	 */
	public void setCount(int count) {
		this.count = count;
	}

	/**
	 * This method is used to get the number of login
	 * 
	 * @return Number of login
	 */
	public int getCount() {
		return this.count;
	}

	/**
	 * This method is used to add 1 time of login
	 */
	public void addCount() {
		this.count++;
	}

	/**
	 * This method is used to set the type of the user
	 * 
	 * @param type
	 *            The type of the user
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * This method is used to get the type of the user
	 * 
	 * @return The type of the user
	 */
	public String getType() {
		return this.type;
	}
}
