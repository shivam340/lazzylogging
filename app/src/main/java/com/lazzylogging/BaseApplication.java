package com.lazzylogging;

import android.app.Application;
import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by shivam on 4/2/15.
 */

public class BaseApplication extends Application {

    private static final int TIME_INTERVAL = 20 * 1000;
    public static boolean IS_THREAD_RUNNING = false;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("!!!!!!!LazzyLoggin", "Initialized app");

        LoggerHandler loggerHandler = LoggerHandler.getLoggerHandler();
        loggerHandler.addLog("LazzyLoggin", "Initialized app");
        initializeRunnable();
    }

    public void initializeRunnable() {

       Timer timer = new Timer();
        TimerTask repeatedTimerTask = new TimerTask() {
            @Override
            public void run() {
                if (!IS_THREAD_RUNNING) {

                    LoggerTask loggerTask = new LoggerTask();
                    loggerTask.run();
                }
            }
        };

// schedule the task to run starting now and then after every 20sec...
        timer.schedule(repeatedTimerTask, 0l, TIME_INTERVAL);
    }
}