package framework.platform;

import framework.Settings;

/**
 * UserCacheMCD
 */
public class UserCacheMCD {
	public static UserMCD USER_ONE = new UserMCD(Settings.config.getMainUserName(), Settings.config.getDefaultUserPassword());
	public static UserMCD USER_TWO = new UserMCD(Settings.config.getAdminEmail(), Settings.config.getAdminPassword());
}
