package com.vincent.design.behavioral_pattern.chain_of_resonsibility_pattern;

public abstract class AbstractLogger {

	protected int level;
	protected AbstractLogger nextLogger;
	public static int INFO = 1;
	public static int DEBUG = 2;
	public static int ERROR = 3;
	public void setNextLogger(AbstractLogger nextLogger) {
		this.nextLogger = nextLogger;
	}

	public void logMessage(int level, String message) {
		if (this.level <= level) {
			write(message);
		}
		if (nextLogger != null) {
			nextLogger.logMessage(level, message);
		}
	}

	abstract protected void write(String message);

}
