package com.nexis.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.nexis.landmarkbook.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    ArrayList<Landmark> landmarkArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarkArrayList=new ArrayList<>();




        Landmark pisa=new Landmark("pisa","Italy",R.drawable.pisa);
        Landmark eifel=new Landmark("Eifel","Fransa",R.drawable.eyfel);
        Landmark collesium =new Landmark("Collesium","Italy",R.drawable.collesium);


        landmarkArrayList.add(pisa);
        landmarkArrayList.add(eifel);
        landmarkArrayList.add(collesium);

        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter=new LandmarkAdapter(landmarkArrayList);
        binding.recyclerView.setAdapter(landmarkAdapter);
    }
}