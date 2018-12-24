package com.ytaolibrary;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ytlibrary.dialog.IDialog;
import com.ytlibrary.dialog.impl.DialogLibrary;
import com.ytlibrary.dialog.impl.IDialogLibrary;

public class MainActivity extends AppCompatActivity  {
    private Context context = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniTest();
    }

    public void iniTest() {
        IDialogLibrary dialogLibrary = new DialogLibrary(context);

        dialogLibrary.promptDialog("测试一下效果怎么样是那个防守打法封口费爱就爱加分附加费积分加分放进书架福建省附近");

    }

}
