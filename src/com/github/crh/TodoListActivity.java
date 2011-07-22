package com.github.crh;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class TodoListActivity extends Activity {
  @Override
  public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    final ListView listView = (ListView) findViewById(R.id.listView);
    final EditText editText = (EditText) findViewById(R.id.editText);

    final List<String> toDoList = new ArrayList<String>();
    final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_list_item_1, toDoList);
    listView.setAdapter(adapter);

    editText.setOnKeyListener(new OnKeyListener() {

      @Override
      public boolean onKey(View arg0, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
          toDoList.add(editText.getText().toString());
          adapter.notifyDataSetChanged();
          editText.setText("");
          return true;
        }
        return false;
      }
    });
  }
}