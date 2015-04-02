package com.lazzylogging;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends ActionBarActivity {

    private static final String KEY = "KEY";
    ArrayList<Student> studentArrayList = new ArrayList<>();
    ArrayList<Student> studentArrayListDuplicate = new ArrayList<>();
    private Button buttonAddLog = null;
    private Button display = null;
    private Button remove = null;
    private Button add = null;
    private String TAG = "LazzyLogging";
    private LoggerHandler loggerHandler;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loggerHandler = LoggerHandler.getLoggerHandler();

        studentArrayList.clear();
        studentArrayListDuplicate.clear();

        buttonAddLog = (Button) findViewById(R.id.btn_add_log);
        display = (Button) findViewById(R.id.btn_1);
        remove = (Button) findViewById(R.id.btn_2);
        add = (Button) findViewById(R.id.btn_3);

         try {
             studentArrayList = (ArrayList<Student>) StorageMaster.readObject(getApplicationContext(), KEY);
         }
         catch (Exception ex) {
             loggerHandler.addLog(TAG, "File reading error is "+ex.getMessage());
         }

        buttonAddLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ( studentArrayList.size() <= 0) {

                    loggerHandler.addLog(TAG, "2 message");
                    loggerHandler.addLog(TAG, "3 message");
                    loggerHandler.addLog(TAG, "4 message");
                    loggerHandler.addLog(TAG, "SHUTDOWN");

                    Student student1 = new Student(1, "abc", 78);
                    Student student2 = new Student(2, "del", 76);
                    Student student3 = new Student(3, "joh", 77);
                    Student student4 = new Student(4, "dsolew", 75);
                    Student student5 = new Student(5, "hsas", 81);
                    Student student6 = new Student(6, "pqe", 98);

                    studentArrayList.add(student1);
                    studentArrayList.add(student2);
                    studentArrayList.add(student3);
                    studentArrayList.add(student4);
                    studentArrayList.add(student5);
                    studentArrayList.add(student6);
                    try {
                        StorageMaster.writeObject(getApplicationContext(), KEY, studentArrayList);
                    } catch (IOException ex) {
                        loggerHandler.addLog("error while writing", "" + ex.getMessage());
                    }
                }
                else {
                    loggerHandler.addLog(TAG, "file is not empty");
                }
            }
        });


        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                displayInfo();

            }
        });


        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                removeInfo();

            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                insertData();
            }
        });


    }


    private void displayInfo() {

        try {

            for (int i = 0; i < studentArrayList.size(); i++) {
                Student student = studentArrayList.get(i);

                loggerHandler.addLog("Data for ", "Student " + (i + 1));
                loggerHandler.addLog("Student Roll Number is  ", "" + student.getRollNumber());
                loggerHandler.addLog("Student Name is  ", "" + student.getName());
                loggerHandler.addLog("Student Percentage is  ", "" + student.getPercentage());
            }

        } catch (Exception ex) {
            loggerHandler.addLog("error while reading", "" + ex.getMessage());
        } finally {
        }

    }

    private void removeInfo() {

        try {
            if (studentArrayList.size() > 0) {
                studentArrayList.remove(0);
                StorageMaster.writeObject(getApplicationContext(), KEY, studentArrayList);
            } else {
                Toast.makeText(getApplicationContext(), "No Data.", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception ex) {
            loggerHandler.addLog("error while reading", "" + ex.getMessage());
        }

    }

    private void insertData() {

        try {
            Student student = new Student(100, "dummy", 99);
            studentArrayList.add(student);
            StorageMaster.writeObject(getApplicationContext(), KEY, studentArrayList);

        } catch (Exception ex) {
            loggerHandler.addLog("error while reading", "" + ex.getMessage());
        }

        /*
        Set<Student> set = new HashSet<Student>();
        set.addAll(studentArrayList);

        SharedPreferences sharedPreferences = getSharedPreferences("student", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putStringSet("data",set);*/

    }
}
