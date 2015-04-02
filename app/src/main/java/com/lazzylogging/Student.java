package com.lazzylogging;

import java.io.Serializable;

/**
 * Created by shivam on 4/2/15.
 */
public class Student implements Serializable {

    private int rollNumber;
    private String name;
    private float percentage;


    public Student(int rollNumber, String name, float percentage) {

        this.percentage = percentage;
        this.rollNumber = rollNumber;
        this.name = name;

    }


    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }
}
