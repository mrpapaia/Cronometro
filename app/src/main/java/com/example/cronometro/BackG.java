package com.example.cronometro;

import android.os.Looper;

public class BackG implements  Runnable {
    Looper looper;
    public void run(){
        Looper.prepare();
        looper.myLooper();
        Looper.loop();

    }

}
