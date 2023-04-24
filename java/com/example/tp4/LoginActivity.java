package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.example.tp4.databinding.ActivityInfosBinding;
import com.example.tp4.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {
    private ActivityLoginBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //titre de l'activité
        setTitle(getLocalClassName());
        //mise en place du layout par un view binding
        ui = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(ui.getRoot());
        //ecouteur quand on valide la saisie du pseudo
        ui.username.setOnEditorActionListener(this::onEditorAction);

        //recuperer le contexte d'application et la donnée qu'elle contient
        TP4Application app = (TP4Application) getApplicationContext();
        int compteur = app.getCompteur();

    }
    private boolean onEditorAction(TextView textView, int actionId, KeyEvent event){
        if(actionId == EditorInfo.IME_ACTION_DONE){
            //texte saisi
            String username = ui.username.getText().toString();
            //TODO lancement de MainActivity avec username, sans retour possible
            String information ="username";
            int nombre =12;
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("information", information);
            intent.putExtra("nombre", nombre);
            startActivity(intent);
            finish();
            return true;
        }else{
            //evenement non consommé
            return false;
        }
    }
}