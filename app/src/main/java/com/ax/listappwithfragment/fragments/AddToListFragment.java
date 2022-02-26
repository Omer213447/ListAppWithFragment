package com.ax.listappwithfragment.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.ax.listappwithfragment.R;
import com.ax.listappwithfragment.adapters.SimpleImageArrayAdapter;
import com.ax.listappwithfragment.models.ListsModel;

public class AddToListFragment extends Fragment {

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
    private void initializeValues(View view, Integer idSGender, Integer idSStatus, Integer idTvName, Integer idTvDescription, Integer idBtnAdd){
        sGender = view.findViewById(idSGender);
        sStatus = view.findViewById(idSStatus);
        tvName = view.findViewById(idTvName);
        tvDescription = view.findViewById(idTvDescription);
        btnAdd = view.findViewById(idBtnAdd);
    }

    public AddToListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_to_list, container, false);
        initializeValues(view, R.id.add_to_list_fragment_sGender, R.id.add_to_list_fragment_sStatus, R.id.add_to_list_fragment_tvName, R.id.add_to_list_fragment_tvDescription, R.id.add_to_list_fragment_btnAdd);
        SimpleImageArrayAdapter genderArrayAdapter = new SimpleImageArrayAdapter(getContext(), new Integer[]{R.drawable.maleicon, R.drawable.femaleicon}, genderImageWidth, genderImageHeight);
        sGender.setAdapter(genderArrayAdapter);
        SimpleImageArrayAdapter statusArrayAdapter = new SimpleImageArrayAdapter(getContext(), new Integer[]{R.drawable.tick, R.drawable.cross}, statusImageWidth, statusImageHeight);
        sStatus.setAdapter(statusArrayAdapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnAddClick();
            }
        });
        return view;
    }

    public void btnAddClick(){
        ListsModel.add((Integer) sGender.getSelectedItem(), (Integer) sStatus.getSelectedItem(), tvName.getText().toString(), tvDescription.getText().toString());
        AFragment aFragment = new AFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_activity_fL, aFragment, aFragment.getTag())
                .commit();
    }
}