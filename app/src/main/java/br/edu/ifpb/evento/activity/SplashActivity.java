package br.edu.ifpb.evento.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import br.edu.ifpb.evento.MainActivity;
import br.edu.ifpb.evento.R;


public class SplashActivity extends AppCompatActivity implements Runnable{

    private static final long Tempo_limite= 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler SplashScreen = new Handler();
        SplashScreen.postDelayed( this, Tempo_limite);
    }

    public void run() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}