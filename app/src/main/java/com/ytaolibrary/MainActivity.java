package com.ytaolibrary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ytlibrary.dialog.IDialog;
import com.ytlibrary.dialog.impl.DialogLibrary;

public class MainActivity extends AppCompatActivity  {
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniTest();
    }

    public void iniTest() {
        IDialog dialogLibrary = new DialogLibrary(context);


    }

}
