package com.example.opt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SignInActivity extends AppCompatActivity {
    private EditText nom, prenom, adress, phone, mdp1, mdp22;

    Button btninscrip;

    TextView connexion;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        adress = findViewById(R.id.adresse);
        phone = findViewById(R.id.phone);
        mdp1 = findViewById(R.id.mdp);
        mdp22 = findViewById(R.id.mdp2);


        btninscrip = findViewById(R.id.inscrip);

        btninscrip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String noms = nom.getText().toString();
                String prenoms = prenom.getText().toString();
                String adr = adress.getText().toString();
                String tel = phone.getText().toString();
                String mdp = mdp1.getText().toString();
                String mdp2 = mdp22.getText().toString();

                inscription(noms, prenoms, adr, tel, mdp, mdp2);


            }
        });

        connexion = findViewById(R.id.textViewCon);

        connexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inscription(String noms, String prenoms, String adr, String tel, String mdp, String mdp2){

        boolean con_res = true;

        if (con_res){
            Intent intent = new Intent(SignInActivity.this, LoginActivity.class);
            intent.putExtra("nom", noms);
            intent.putExtra("mdp", mdp2);
            startActivity(intent);
        }else {
            Toast.makeText(this, "Connexion échoué", Toast.LENGTH_SHORT).show();
        }
    }

    private void connexion(String noms, String mdp ){

    }
}