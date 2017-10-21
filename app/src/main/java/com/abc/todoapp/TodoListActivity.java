package com.abc.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TodoListActivity extends AppCompatActivity {
  private ListView listView;
  private ArrayAdapter<String> listAdapter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_todo_list);
    listView = (ListView) findViewById(R.id.list_view);
    listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1);
    listView.setAdapter(listAdapter);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.create_todo_btn);

    fab.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        startActivityForResult(new Intent(TodoListActivity.this, CreateTodoActivity.class), 100);
      }
    });
  }

  @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 100 && resultCode == Activity.RESULT_OK) {
      String todo = data.getStringExtra("todo");
      listAdapter.add(todo);
    }
  }
}
