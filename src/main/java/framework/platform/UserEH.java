package framework.platform;

import framework.Settings;
import framework.platform.utilities.StringUtils;

/**
 * UserEH
 */
public class UserEH {

	public UserEH(String firstName, String lastName, String email, String screenName, String password, String dobMM, String dobDD, String dobYYYY, String zip) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.screenName = screenName;
		this.password = password;
		this.dobMM = dobMM;
		this.dobDD = dobDD;
		this.dobYYYY = dobYYYY;
		this.zip = zip;
	}

	public UserEH() {
		this("John" + StringUtils.generateRandomNumeric(4),
				"Smith" + StringUtils.generateRandomNumeric(4),
				StringUtils.generateRandomEmail(),
				"JohnSmithAutomation" + StringUtils.generateRandomStrAlphabetic(6),
				Settings.config.getDefaultUserPassword(),
				"6",
				"26",
				"1975",
				"10014");
	}

	public UserEH(String email, String password) {
		this.email = email;
		this.password = password;
	}

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String screenName;
	private String dobMM;
	private String dobDD;
	private String dobYYYY;
	private String zip;

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getScreenName() {
		return screenName;
	}

	public String getDobMM() {
		return dobMM;
	}

	public String getDobDD() {
		return dobDD;
	}

	public String getDobYYYY() {
		return dobYYYY;
	}

	public String getZip() {
		return zip;
	}
}
