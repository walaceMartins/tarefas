package br.usjt.ads.desmob.ciclodevida;

import android.app.Activity;
import android.os.Bundle;

public class ActivityA extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_a);
    }
    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public void onPause(){
        super.onPause();
    }
    @Override
    public void onStop(){
        super.onStop();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }

}
