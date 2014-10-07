package com.example.zangardiw.to_do;

import android.app.Activity;
import android.app.Fragment;
import android.view.KeyEvent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
/**
 * Created by zangardiw on 10/7/14.
 */
public class NewItemFragment extends Fragment {
    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);
        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);

        myEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN)
                    if((keyCode == KeyEvent.KEYCODE_DPAD_DOWN) || (keyCode == KeyEvent.KEYCODE_ENTER)){
                        String newItem = myEditText.getText().toString();
                        onNewItemAddListener.onNewItemAdded(newItem);
                        myEditText.setText("");
                        return true;
                    }
                return false;
            }
        });
        return view;
    }

    public interface OnNewItemAddListener {
        public void onNewItemAdded(String newItem);
    }

    private OnNewItemAddListener onNewItemAddListener;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);

        try{
            onNewItemAddListener = (OnNewItemAddListener)activity;
        } catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnNewItemAddedListener");
        }
    }
}
