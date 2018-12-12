package com.ytaolibrary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity implements OnLocationListener {
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new ToolUtils(context).onCreate();
    }

    @Override
    public void onSuccess(double longitude, double latitude, String myLocation) {
        Log.e("yutao", longitude + ", " + latitude + ", " + myLocation);
    }
}
