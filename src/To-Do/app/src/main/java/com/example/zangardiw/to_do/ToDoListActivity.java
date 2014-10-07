package com.example.zangardiw.to_do;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class ToDoListActivity extends Activity implements NewItemFragment.OnNewItemAddListener {


    private ToDoItemAdapter aa;
    private ArrayList<ToDoItem> toDoItems;

    public void onNewItemAdded(String newItem){
        ToDoItem td = new ToDoItem(newItem);
        toDoItems.add(0, td);
        aa.notifyDataSetChanged();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);


        // Get references to the Fragments
        FragmentManager fm = getFragmentManager();
        ToDoListFragment toDoListFragment = (ToDoListFragment)fm.findFragmentById(R.id.ToDoListFragment);

        // Create the arraylist of to do items
        toDoItems = new ArrayList<ToDoItem>();

        // Create the array adapter too bind the array to the list view

        int resID = R.layout.todolist_item;
        aa= new ToDoItemAdapter(this, resID, toDoItems);

        //bind the Array Adapter to the list view
        toDoListFragment.setListAdapter(aa);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
