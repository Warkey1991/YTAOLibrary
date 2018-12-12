package com.ytaolibrary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ytlibrary.dialog.DialogLibrary;
import com.ytlibrary.dialog.impl.DialogLibraryImpl;

public class MainActivity extends AppCompatActivity  {
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniTest();
    }

    public void iniTest(){

        DialogLibrary dialogLibrary = new DialogLibraryImpl(context);
        dialogLibrary.bottomDialog("打击武器", "方法",
                new DialogLibrary.OnBottomDialogClickListener() {
            @Override
            public void onTopButtonClick() {

            }

            @Override
            public void onMidButonClick() {

            }

            @Override
            public void onCancelButtonClick() {

            }
        });

    }


}
