package com.friendsofgroot.app.util.logger;

import com.friendsofgroot.app.util.constants.Cmds;

import static java.lang.Thread.sleep;

public class LogCustom {

	public static void loggerInstance(String[] ...msg)   {
		logErrorCheck();
		loggerInfo();
		CliLogger.getInstance().always();
		System.out.println(Cmds.NOW_LOGGING+ msg[0]);
		System.out.println(Cmds.LOGGING_AT+System.nanoTime());

	}
	public static void loggerInfo() {
		CliLogger.getInstance().atInfo();
	}
	public static void logErrorCheck() {
		CliLogger.getInstance().info("Program Started");
		 
		try {
			int x = 1/0;
		} catch (ArithmeticException e) {
			CliLogger.getInstance().error("System Logger Check: "+ e.getMessage());
		}
		CliLogger.getInstance().info("Program ended");
	}
		

}
