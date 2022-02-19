package com.ax.listappwithfragment.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.ax.listappwithfragment.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton fAbtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fAbtnAdd = findViewById(R.id.main_activity_fABtnAdd);
        fAbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onFABtnAddClick();
            }
        });
    }
    public void onFABtnAddClick(){
        Intent i = new Intent(MainActivity.this, AddToListActivity.class);
        startActivity(i);
    }
}