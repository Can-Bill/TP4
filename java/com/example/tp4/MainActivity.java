package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "TP4";
    private TextView textview;
    private ActivityMainBinding ui;
    private int compteur = 0;
    private Button bouton5;
    private Button bouton6;
    private Button bouton7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //initialisation interne de l'activité
        super.onCreate(savedInstanceState);
        //mise en place du layout par un   view binding
        ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        //titre de l'activité
        setTitle(getLocalClassName());
        //message d'information
        Log.i(TAG, "dans"+getLocalClassName()+".onCreate");

        //Recuperation de l'objet TextView
        //textview = findViewById(R.id.texte);
        //textview.setText("bonjour");

        //ecouteur pour le bouton2, lambda
        ui.bouton2.setOnClickListener(btn ->  {
            compteur += 2;
            ui.texte.setText("compteur = "+compteur);
        });

        //ecouteur pour le bouton3, reference de méthode
        ui.bouton3.setOnClickListener(this::onBouton3Click);

        //ecouteur pour le bouton4, l'activité elle même
        ui.bouton4.setOnClickListener(this);

        //partie concernant les bouton 5 et bouton 6
        bouton5 = findViewById(R.id.bouton5);
        bouton6= findViewById(R.id.bouton6);
        bouton7= findViewById(R.id.bouton7);


        //lancement des differents activités
        bouton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InfosActivity.class);
                startActivity(intent);
            }
        });

        bouton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), InfosActivity.class);
                startActivity(intent);
                finish();
            }
        });

        bouton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://perso.univ-rennes1.fr/pierre.nerzic/Android";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

        //recuperation des extras
        Intent intent = getIntent();
        String information = intent.getStringExtra("information");
        int nombre = intent.getIntExtra("nombre", -1);


        //recuperer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getCompteur();
    }

    private void onBouton3Click(View view){
        compteur *= 2;
        ui.texte.setText("compteur = "+compteur);
    }


     public void onBouton1Click(View view){
        compteur += 1;
        ui.texte.setText("compteur = "+compteur);
    }

    @Override
    public void onClick(View view){
        compteur *= 5;
        ui.texte.setText("compteur = "+compteur);
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i(TAG, "dans"+getLocalClassName()+".onDestroy");
    }

    @Override
    protected void onPause(){
        super.onPause();
        Log.i(TAG, "dans"+getLocalClassName()+".onPause");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i(TAG, "dans"+getLocalClassName()+".onResume");
    }


}