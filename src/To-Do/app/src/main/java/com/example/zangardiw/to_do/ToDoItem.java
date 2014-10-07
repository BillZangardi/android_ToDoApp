package com.example.zangardiw.to_do;

/**
 * Created by zangardiw on 10/7/14.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

public class ToDoItem {
    String task;
    Date created;

    public String getTask() {
        return task;
    }

    public Date getCreated(){
        return created;
    }

    public ToDoItem(String _task){
        this(_task, new Date(java.lang.System.currentTimeMillis()));
    }

    public ToDoItem(String _task, Date _created){
        task = _task;
        created = _created;
    }

    @Override
    public String toString(){
        SimpleDateFormat sdf = new SimpleDateFormat("mm/dd/yy");
        String dateString =sdf.format(created);
        return "(" + dateString + ") " + task;
    }
}
