package com.nexis.landmarkbook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.nexis.landmarkbook.databinding.RecyclerRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder> {
    ArrayList<Landmark> landmarkList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkList) {
        this.landmarkList = landmarkList;
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerRowBinding recyclerRowBinding=RecyclerRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, @SuppressLint("RecyclerView") int position) {

        holder.binding.recyclerViewTxt.setText(landmarkList.get(position).name);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(holder.itemView.getContext(),DetailsActivity.class);
                Singleton singleton = Singleton.getInstance();
                singleton.setChosenLandmark(landmarkList.get(position));

             holder.itemView.getContext().startActivity(i);



            }
        });


    }

    @Override
    public int getItemCount() {
        return landmarkList.size();
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder {
        private RecyclerRowBinding binding;

        public LandmarkHolder(RecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

}
