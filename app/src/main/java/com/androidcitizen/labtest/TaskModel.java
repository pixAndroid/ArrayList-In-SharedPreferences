package com.androidcitizen.labtest;


import java.io.Serializable;

/********************************************
 *     Created by DailyCoding on 3/23/2020.  *
 ********************************************/

public class TaskModel implements Serializable{
    private String task_name;
    private String  task_added_time;

    public TaskModel() {
    }

    public TaskModel(String taskName, String  taskAddedTime) {
        this.task_name = taskName;
        this.task_added_time = taskAddedTime;
    }

    public String getTaskName() {
        return task_name;
    }

    public String getTaskAddedTime() {
        return task_added_time;
    }
}
