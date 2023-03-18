package com.example.kullanicigiris;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Bağlamalar
    EditText edtKullaniciAd, edtSifre;
    Button btnGirisYap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtKullaniciAd= findViewById(R.id.edtKullaniciAdi);
        edtSifre= findViewById(R.id.edtSifre);
        btnGirisYap= findViewById(R.id.btnGirisYap);

        tiklama();

    }

    private void tiklama(){

        btnGirisYap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String alinanKullaniciAd = edtKullaniciAd.getText().toString();
                String alinanSifre = edtSifre.getText().toString();
                boslukKontrol(alinanKullaniciAd, alinanSifre);
            }
        });
    }

    private void boslukKontrol(String a , String b){

        edtKullaniciAd.setBackgroundColor(Color.WHITE);
        edtSifre.setBackgroundColor(Color.WHITE);

        if (a.isEmpty() ) {
            edtKullaniciAd.setBackgroundColor(Color.RED);
           // edtKullaniciAd.setBackgroundColor(Color.WHITE);
            edtKullaniciAd.setHintTextColor(Color.WHITE);
        }

        if (b.isEmpty()) {
            edtSifre.setBackgroundColor(Color.RED);
            edtSifre.setHintTextColor(Color.WHITE);
        }

        if (!a.isEmpty() && !b.isEmpty()) {
            String alinanKullaniciAd = edtKullaniciAd.getText().toString();
            String alinanSifre = edtSifre.getText().toString();
            sifreKontrol(alinanKullaniciAd,alinanSifre);
        }

    }

    private void sifreKontrol(String a, String b){
        if (a.equals("Budotekno") && b.equals("1234")) {

            Intent git = new Intent(MainActivity.this,AnaSayfaActivity.class);
            startActivity(git);


        }
        else {


            //uyarı mesajı gelecekkk
            Toast.makeText(MainActivity.this, "Yanlış giriş yaptınız! Lütfen tekrar deneyiniz", Toast.LENGTH_LONG).show();
          // edtSifre=findViewById(R.id.edtSifre);

            edtKullaniciAd.setText("");
            edtSifre.setText("");


        }


    }
}