package com.abc.todoapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateTodoActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create_todo);

    final EditText editText = (EditText) findViewById(R.id.edit_text);
    Button saveButton = (Button) findViewById(R.id.button_save);

    saveButton.setOnClickListener(new Button.OnClickListener() {
      @Override public void onClick(View v) {
        String todo = editText.getText().toString();
        Intent resultIntent = new Intent();
        resultIntent.putExtra("todo", todo);
        setResult(Activity.RESULT_OK, resultIntent);
        finish();
      }
    });
  }
}
