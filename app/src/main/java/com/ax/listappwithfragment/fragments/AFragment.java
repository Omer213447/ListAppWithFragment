package com.ax.listappwithfragment.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ax.listappwithfragment.R;
import com.ax.listappwithfragment.adapters.RecyclerViewAdapter;
import com.ax.listappwithfragment.models.ListsModel;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AFragment extends Fragment implements RecyclerViewAdapter.OnListListener {
    RecyclerView recyclerView;
    RecyclerView.Adapter rVAdapter;
    GridLayoutManager gridLayoutManager;
    FloatingActionButton fAbtnAdd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        System.out.println("fragment crated");
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        System.out.println("Fragment olustu");
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        recyclerView = view.findViewById(R.id.listFragment_recyclerView);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        rVAdapter = new RecyclerViewAdapter(getContext(), ListsModel.genders, ListsModel.names, ListsModel.statuses, this);
        recyclerView.setAdapter(rVAdapter);
        fAbtnAdd = view.findViewById(R.id.list_fragment_fABtnAdd);
        fAbtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onfAbtnAddClick();
            }
        });
        return view;
    }

    public void onfAbtnAddClick(){
        AddToListFragment addToListFragment = new AddToListFragment();
        FragmentManager fragmentManager = getParentFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_activity_fL, addToListFragment, addToListFragment.getTag())
                .commit();
    }

    @Override
    public void onNameClick(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("Position", position);
        ShowInfoFragment showInfoFragment = new ShowInfoFragment();
        showInfoFragment.setArguments(bundle);
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(((ViewGroup)getView().getParent()).getId(), showInfoFragment, showInfoFragment.getTag())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onStatusClick(int position) {
        if(ListsModel.statuses.get(position) == R.drawable.tick){
            ListsModel.statuses.set(position, R.drawable.cross);
        }else {
            ListsModel.statuses.set(position, R.drawable.tick);
        }
        rVAdapter.notifyDataSetChanged();
    }

}