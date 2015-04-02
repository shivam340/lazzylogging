package com.lazzylogging;

import java.util.ArrayList;

/**
 * Created by shivam on 4/2/15.
 */
public class LoggerHandler {

    private static LoggerHandler loggerHandler = new LoggerHandler();
    private ArrayList<LogMessage> logMessageArrayList = new ArrayList<LogMessage>();

    private LoggerHandler() {

    }

    public static LoggerHandler getLoggerHandler() {
        return loggerHandler;
    }

    /**
     * This is the main method which makes use of addNum method.
     * @param title log title.
     * @param message log message.
     * @return Nothing.
     * @see java.io.IOException
     */
    public void addLog(String title, String message) {
        LogMessage logMessage = new LogMessage("" + title, "" + message);
        logMessageArrayList.add(logMessage);
    }

    public void addLog(LogMessage logMessage) {
        logMessageArrayList.add(logMessage);
    }

    public ArrayList<LogMessage> getLogMessageArrayList() {
        return logMessageArrayList;
    }

}
