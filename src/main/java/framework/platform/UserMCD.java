package framework.platform;

/**
 * UserMCD
 */
public class UserMCD {

	public UserMCD(String firstName, String lastName, String email, String password, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.zip = zip;
	}

	public UserMCD(String email, String password) {
		this.email = email;
		this.password = password;
	}

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String zip;

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getZip() {
		return zip;
	}

	public String getFirstName() {
		return firstName;
	}
}
