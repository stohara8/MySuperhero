package com.example.mysuperheroes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onPause(){ super.onPause(); }

    public void onResume() { super.onResume(); }

    public void additionPressed(View v){
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", true);
        startActivity(i);
    }

    public void viewPressed(View v){
        Intent in = new Intent(this, NameViewActivity.class);
        startActivity(in);
    }
}
