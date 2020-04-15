package com.example.mysuperheroes;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class AddActivity extends AppCompatActivity {

    private EditText nameBox;
    private EditText companyBox;
    private EditText yearBox;
    private Button addButton;
    private boolean add;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        nameBox = findViewById(R.id.nameBox);
        companyBox = findViewById(R.id.companyBox);
        yearBox = findViewById(R.id.yearBox);
        addButton = findViewById(R.id.addButton);
        Intent i = getIntent();
        add = i.getBooleanExtra("ADD", true);
        if(add){
            addButton.setText("ADD");
        }
        else{
            addButton.setText("EDIT");
            nameBox.setText(i.getStringExtra("NAME"));
            companyBox.setText(i.getStringExtra("COMPANY"));
            yearBox.setText(i.getStringExtra("YEAR"));
        }

    }

    public void addPressed(View v){
        String name = nameBox.getText().toString();
        String company = companyBox.getText().toString();
        String year = yearBox.getText().toString();
        DatabaseManager dbm = new DatabaseManager(this);
        dbm.insert(name, company, year);
        if(add){
            dbm.insert(name, company, year);
        }
        else{
            dbm.updateByName(name, company);
            dbm.updateByName2(name, year);
        }

        finish();
    }

    public void onPause(){ super.onPause(); }

    public void onResume() { super.onResume(); }

    public void onBackPressed(){
        finish();
    }
}
