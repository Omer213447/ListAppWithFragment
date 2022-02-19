package com.ax.listappwithfragment.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ax.listappwithfragment.R;
import com.ax.listappwithfragment.activities.ShowInfoActivity;
import com.ax.listappwithfragment.adapters.RecyclerViewAdapter;
import com.ax.listappwithfragment.models.ListsModel;

public class ListFragment extends Fragment implements RecyclerViewAdapter.OnListListener{
    RecyclerView recyclerView;
    RecyclerView.Adapter rVAdapter;
    GridLayoutManager gridLayoutManager;

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        recyclerView = view.findViewById(R.id.listFragment_recyclerView);
        gridLayoutManager = new GridLayoutManager(getContext(), 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        rVAdapter = new RecyclerViewAdapter(getContext(), ListsModel.genders, ListsModel.names, ListsModel.ticks, this);
        recyclerView.setAdapter(rVAdapter);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onNameClick(int position) {
        Intent i = new Intent(getContext(), ShowInfoActivity.class);
        i.putExtra("position", position);
        i.putExtra("gender", ListsModel.genders.get(position));
        i.putExtra("name", ListsModel.names.get(position));
        i.putExtra("description", ListsModel.infos.get(position));
        i.putExtra("status", ListsModel.ticks.get(position));
        startActivity(i);
    }

    @Override
    public void onStatusClick(int position) {
        if(ListsModel.ticks.get(position) == R.drawable.tick){
            ListsModel.ticks.set(position, R.drawable.cross);
        }else {
            ListsModel.ticks.set(position, R.drawable.tick);
        }
        rVAdapter.notifyDataSetChanged();
    }
}