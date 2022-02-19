package com.ax.listappwithfragment.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ax.listappwithfragment.models.ListsModel;
import com.ax.listappwithfragment.R;

public class ShowInfoActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvDescription;
    ImageView ivGender;
    ImageView ivStatus;
    Button btnDelete;

    private void initializeValues(Integer idTvName, Integer idTvDescription, Integer idIvGender, Integer idIvStatus, Integer idBtnDelete){
        tvName = findViewById(idTvName);
        tvDescription = findViewById(idTvDescription);
        ivGender = findViewById(idIvGender);
        ivStatus = findViewById(idIvStatus);
        btnDelete = findViewById(idBtnDelete);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);
        initializeValues(R.id.show_info_activity_tvName, R.id.show_info_activity_tvDescription, R.id.show_info_activity_ivGender, R.id.show_info_activity_ivStatus, R.id.show_info_activity_btnDelete);
        Intent i = getIntent();
        tvName.setText(i.getStringExtra("name"));
        tvDescription.setText(i.getStringExtra("description"));
        ivGender.setImageResource(i.getIntExtra("gender", R.drawable.maleicon));
        ivStatus.setImageResource(i.getIntExtra("status", R.drawable.tick));
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = i.getIntExtra("position", -1);
                if(position == -1){
                    Toast.makeText(ShowInfoActivity.this, getString(R.string.show_info_activity_errorMessage), Toast.LENGTH_SHORT).show();
                }else {
                    ListsModel.remove(position);
                    Intent m = new Intent(ShowInfoActivity.this, MainActivity.class);
                    startActivity(m);
                }
            }
        });
    }
}