package com.lazzylogging;

/**
 * Created by shivam on 4/2/15.
 */
public class LogMessage {

    private String title;
    private String message;

    public LogMessage(String title, String message) {
        this.title = title;
        this.message = message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}