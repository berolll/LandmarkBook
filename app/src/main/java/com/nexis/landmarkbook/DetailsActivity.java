package com.nexis.landmarkbook;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.nexis.landmarkbook.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

            private ActivityDetailsBinding binding;


            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                binding = ActivityDetailsBinding.inflate(getLayoutInflater());
                View view = binding.getRoot();
                setContentView(view);


                //Landmark selectedLandmark = (Landmark) intent.getSerializableExtra("landmark");

                Singleton singleton = Singleton.getInstance();
                Landmark selectedLandmark = singleton.getSelectedLandmark();

                binding.txtName.setText(selectedLandmark.name);
                binding.txtCountry.setText(selectedLandmark.country);
                binding.img.setImageResource(selectedLandmark.image);



            }
}