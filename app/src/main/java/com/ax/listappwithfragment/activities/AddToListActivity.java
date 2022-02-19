package com.ax.listappwithfragment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ax.listappwithfragment.models.ControlModel;
import com.ax.listappwithfragment.models.ListsModel;
import com.ax.listappwithfragment.R;
import com.ax.listappwithfragment.adapters.SimpleImageArrayAdapter;

public class AddToListActivity extends AppCompatActivity {
    //Constants
    private static final int genderImageWidth = 150;
    private static final int genderImageHeight = 128;
    private static final int statusImageWidth = 150;
    private static final int statusImageHeight = 128;
    //View items
    Spinner sGender;
    Spinner sStatus;
    EditText tvName;
    EditText tvDescription;
    Button btnAdd;
    private void initializeValues(Integer idSGender, Integer idSStatus, Integer idTvName, Integer idTvDescription, Integer idBtnAdd){
        sGender = findViewById(idSGender);
        sStatus = findViewById(idSStatus);
        tvName = findViewById(idTvName);
        tvDescription = findViewById(idTvDescription);
        btnAdd = findViewById(idBtnAdd);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);
        initializeValues(R.id.add_to_list_activity_sGender, R.id.add_to_list_activity_sStatus, R.id.add_to_list_activity_tvName, R.id.add_to_list_activity_tvDescription, R.id.add_to_list_activity_btnAdd);
        SimpleImageArrayAdapter genderArrayAdapter = new SimpleImageArrayAdapter(this, new Integer[]{R.drawable.maleicon, R.drawable.femaleicon}, genderImageWidth, genderImageHeight);
        sGender.setAdapter(genderArrayAdapter);
        SimpleImageArrayAdapter statusArrayAdapter = new SimpleImageArrayAdapter(this, new Integer[]{R.drawable.tick, R.drawable.cross}, statusImageWidth, statusImageHeight);
        sStatus.setAdapter(statusArrayAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!ControlModel.isEditTextEmpty(tvName) && !ControlModel.isEditTextEmpty(tvDescription)){
                    ListsModel.add((Integer) sGender.getSelectedItem(), (Integer) sStatus.getSelectedItem(), tvName.getText().toString(), tvDescription.getText().toString());
                    Intent i = new Intent(AddToListActivity.this, MainActivity.class);
                    startActivity(i);
                }else {
                    Toast.makeText(AddToListActivity.this, R.string.text_fields_empty_message, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}