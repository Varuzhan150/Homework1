package com.example.gasparyan.homeworke;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        readSaveValueIfExist();
    }

    public void saveText(View view) {
        CheckBox myCheckBox = (CheckBox) findViewById(R.id.myCheckBok);
        EditText editTestComponent = (EditText) findViewById(R.id.myTest);
        if (myCheckBox.isChecked()) {
            String mytext = editTestComponent.getText().toString();
            SharedPreferences db = getPreferences(MODE_PRIVATE);
            SharedPreferences.Editor connect = db.edit();
            connect.putString("saveValue", mytext);
            connect.commit();
            Toast.makeText(MainActivity.this,"saved",Toast.LENGTH_SHORT).show();
        }
    }

    private void readSaveValueIfExist() {
        EditText text = (EditText) findViewById(R.id.myTest);
        SharedPreferences db = getPreferences(MODE_PRIVATE);
        String value = db.getString("saveValue","");
        text.setText( value);
        Toast.makeText(MainActivity.this,"load",Toast.LENGTH_SHORT).show();
    }
}

