package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.tp4.databinding.ActivityInfosBinding;
import com.example.tp4.databinding.ActivityMainBinding;

public class InfosActivity extends AppCompatActivity {
    private static final String TAG = "TP4";
    private ActivityInfosBinding ui;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_infos);
        //titre de l'activité
        setTitle(getLocalClassName());
        //mise en place du layout par un view binding
        ui = ActivityInfosBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        //message d'information
        Log.i(TAG,"dans "+getLocalClassName()+".onCreate");


        //recuperer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getCompteur();
    }
}