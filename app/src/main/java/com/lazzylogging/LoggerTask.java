package com.lazzylogging;

import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by shivam on 4/2/15.
 */
public class LoggerTask implements Runnable {

    /*private static LoggerTask loggerTask = new LoggerTask();*/

    public LoggerTask() {

    }

  /*  private LoggerTask getLoggerTask() {
        return loggerTask;
    }*/

    @Override
    public void run() {
        try {

            BaseApplication.IS_THREAD_RUNNING = true;

            ArrayList<LogMessage> logMessageArrayList = LoggerHandler.getLoggerHandler().getLogMessageArrayList();
            Log.d("log message array list size is  ", "" + logMessageArrayList.size());

            Iterator<LogMessage> iterator = logMessageArrayList.iterator();

            while (iterator.hasNext()) {
                LogMessage logMessage = iterator.next();
                Log.d("" + logMessage.getTitle(), "" + logMessage.getMessage());
                iterator.remove();
            }
        }
        catch (NullPointerException ex) {
        //TODO handle exception here
        }
        finally {
            BaseApplication.IS_THREAD_RUNNING = false;
        }

    }
}