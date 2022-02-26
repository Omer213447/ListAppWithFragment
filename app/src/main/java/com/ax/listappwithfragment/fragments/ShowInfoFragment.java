package com.ax.listappwithfragment.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ax.listappwithfragment.R;
import com.ax.listappwithfragment.models.ListsModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ShowInfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ShowInfoFragment extends Fragment {
    TextView tvName;
    TextView tvDescription;
    ImageView ivGender;
    ImageView ivStatus;
    Button btnDelete;
    int position;

    private void initializeValues(View view, Integer idTvName, Integer idTvDescription, Integer idIvGender, Integer idIvStatus, Integer idBtnDelete){
        tvName = view.findViewById(idTvName);
        tvDescription = view.findViewById(idTvDescription);
        ivGender = view.findViewById(idIvGender);
        ivStatus = view.findViewById(idIvStatus);
        btnDelete = view.findViewById(idBtnDelete);
    }

    public ShowInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_show_info, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        position = requireArguments().getInt("Position", 0);
        initializeValues(view, R.id.show_info_fragment_tvName, R.id.show_info_fragment_tvDescription, R.id.show_info_fragment_ivGender, R.id.show_info_fragment_ivStatus, R.id.show_info_fragment_btnDelete);
        tvName.setText(ListsModel.names.get(position));
        tvDescription.setText(ListsModel.descriptions.get(position));
        ivGender.setImageResource(ListsModel.genders.get(position));
        ivStatus.setImageResource(ListsModel.statuses.get(position));
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnDeleteClick();
            }
        });
    }

    public void btnDeleteClick(){
        ListsModel.remove(position);
        AFragment aFragment = new AFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_activity_fL, aFragment, aFragment.getTag())
                .commit();
    }
}