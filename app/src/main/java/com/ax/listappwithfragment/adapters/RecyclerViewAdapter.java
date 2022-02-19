package com.ax.listappwithfragment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ax.listappwithfragment.R;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<Integer> aLGender;
    private ArrayList<String> aLName;
    private ArrayList<Integer> aLStatus;
    private Context context;
    private OnListListener onListListener;


    public RecyclerViewAdapter(Context context, ArrayList<Integer> aLGender, ArrayList<String> aLName, ArrayList<Integer> aLStatus, OnListListener onListListener){
        this.aLGender = aLGender;
        this.aLName = aLName;
        this.aLStatus = aLStatus;
        this.context = context;
        this.onListListener = onListListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_list, parent, false);
        ViewHolder viewHolder = new ViewHolder(view, onListListener);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.ivGender.setImageResource(aLGender.get(position));
        holder.ivStatus.setImageResource(aLStatus.get(position));
        holder.tvName.setText(aLName.get(position));
    }

    @Override
    public int getItemCount() {
        return aLGender.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView ivGender;
        TextView tvName;
        ImageView ivStatus;
        GridLayout gridItemLayout;
        OnListListener onListListener;
        public ViewHolder(@NonNull View itemView, OnListListener onListListener) {
            super(itemView);
            ivGender = itemView.findViewById(R.id.item_list_layout_ivImage);
            tvName = itemView.findViewById(R.id.item_list_layout_tvName);
            ivStatus = itemView.findViewById(R.id.item_list_layout_ivStatus);
            gridItemLayout = itemView.findViewById(R.id.grid_layout);
            this.onListListener = onListListener;

            tvName.setOnClickListener(this);
            ivGender.setOnClickListener(this);
            ivStatus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onListListener.onStatusClick(getBindingAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View view) {
            onListListener.onNameClick(getBindingAdapterPosition());
        }
    }

    public interface OnListListener{
        void onNameClick(int position);
        void onStatusClick(int position);
    }
}
