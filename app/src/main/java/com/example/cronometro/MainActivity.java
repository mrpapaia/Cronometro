package com.example.cronometro;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Boolean execucao=false;
    Boolean criado= false;
    Integer segundos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onStart(){
        super.onStart();

    }
    protected void onResume(){
        super.onResume();
        if(!criado) {
            runTime();
            criado=true;
        }
    }
    protected void onPause(){
        super.onPause();


    }

    public void onClickStart(View view){
        if(!execucao){
            execucao=true;
        }
    }
    public void onClickStop(View view){
        if(execucao) {
            execucao = false;
        }
    }
    public void onClickRestart(View view){
        segundos=0;


    }



    private void runTime(){

        Drawable seg = getDrawable(R.drawable.circularsegundos);
        Drawable min = getDrawable(R.drawable.circularminutos);
        Drawable h = getDrawable(R.drawable.circularhoras);
        final  TextView tvContador=(TextView)findViewById(R.id.tvContador);
        final ProgressBar pbSegundos =(ProgressBar) findViewById(R.id.pbSegundos);
        final ProgressBar pbMinutos =(ProgressBar) findViewById(R.id.pbMinutos);
        final ProgressBar pbHoras =(ProgressBar) findViewById(R.id.pbHoras);
        pbSegundos.setProgress(0);
        pbSegundos.setProgressDrawable(seg);
        pbMinutos.setProgress(0);
        pbMinutos.setProgressDrawable(min);
        pbHoras.setProgress(0);
        pbHoras.setProgressDrawable(h);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                Integer horas=segundos/3600;
                Integer minutos=(segundos%3600)/60;
                Integer secs=segundos%60;
                String timer = String.format("%02d:%02d:%02d", horas, minutos, secs);
                tvContador.setText(timer);
                pbSegundos.setProgress(secs);
                pbMinutos.setProgress(minutos);
                pbHoras.setProgress(horas);
                if(execucao){
                    segundos++;
                }
                handler.postDelayed(this,1000);

            }
        });

    }








}
