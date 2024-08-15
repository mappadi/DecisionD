package framework.platform;

import framework.Settings;

/**
 * UserCacheEH
 */
public class UserCacheEH {
	public static UserEH MAIN_USER = new UserEH(Settings.config.getMainUserName(), Settings.config.getDefaultUserPassword());
	public static UserEH ADS_USER = new UserEH(Settings.config.getAdsUserName(), Settings.config.getDefaultUserPassword());
	public static UserEH PT_USER = new UserEH(Settings.config.getPtUserName(), Settings.config.getPtUserPassword());
	public static UserEH PT_REGISTRATION_USER = new UserEH("personalizedten@gmail.com", Settings.config.getPtUserPassword());
}
