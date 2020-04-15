package com.example.mysuperheroes;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ViewActivity extends AppCompatActivity {

    private TextView nameView;
    private TextView companyView;
    private TextView yearView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        nameView = findViewById(R.id.nameView);
        companyView = findViewById(R.id.companyView);
        yearView = findViewById(R.id.yearView);

        DatabaseManager dbm = new DatabaseManager(this);
        Intent i = getIntent();
        String name = i.getStringExtra("NAME");
        String[] entry = dbm.get(name);
        nameView.setText(entry[0]);
        companyView.setText(entry[1]);
        yearView.setText(entry[2]);

    }

    public void editPressed(View v){
        Intent i = new Intent(this, AddActivity.class);
        i.putExtra("ADD", false);
        i.putExtra("NAME", nameView.getText().toString());
        i.putExtra("COMPANY", companyView.getText().toString());
        i.putExtra("YEAR", yearView.getText().toString());
        startActivity(i);
    }

    public void onPause(){ super.onPause(); }

    public void onResume() { super.onResume(); }

    public void onBackPressed(){
        finish();
    }

}
