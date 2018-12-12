package com.ytlibrary.dialog.impl;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.ytlibrary.R;
import com.ytlibrary.dialog.DialogLibrary;
import com.ytlibrary.util.SystemUtils;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

/**
 * Author 余涛
 * Description 功能说明
 * Time 2018/12/12 16:42
 */
public class DialogLibraryImpl implements DialogLibrary {
    private Context context;
    private static Context myContext;
    private static DialogLibraryImpl instance;

    public DialogLibraryImpl(Context mContext){
        context = mContext;
        myContext = mContext;
    }

    public static DialogLibraryImpl getInstance(){
        if(instance == null){
            instance = new DialogLibraryImpl(myContext);
        }
        return instance;
    }

    /*****************************调用Github上高级自定义等待动画----开始*********************************/

    private  ZLoadingDialog myDialog;
    private  Z_TYPE type;
    private  int color = Color.WHITE;

    @Override
    public void waitDialog( String message) {
        waitDialog(message,11,"#00000000");
    }

    @Override
    public void waitDialog(String message, int cartoonStyle) {
        waitDialog(message,cartoonStyle,"#00000000");
    }

    @Override
    public void waitDialog(String message, int cartoonStyle, String background) {
        myDialog = new ZLoadingDialog(context);
        myDialog.setCanceledOnTouchOutside(false);  //点击其他位置,dialog不消失

        switch(cartoonStyle){
            case 0: type = Z_TYPE.CIRCLE; break;
            case 1: type = Z_TYPE.CIRCLE_CLOCK; break;
            case 2: type =Z_TYPE.STAR_LOADING; break;
            case 3: type = Z_TYPE.LEAF_ROTATE; break;
            case 4: type =Z_TYPE.DOUBLE_CIRCLE; break;
            case 5: type = Z_TYPE.PAC_MAN; break;
            case 6: type =Z_TYPE.ELASTIC_BALL; break;
            case 7: type =Z_TYPE.INFECTION_BALL; break;
            case 8: type = Z_TYPE.INTERTWINE; break;
            case 9: type =Z_TYPE.TEXT; break;
            case 10: type =Z_TYPE.SEARCH_PATH; break;
            case 11: type = Z_TYPE.ROTATE_CIRCLE; break;
            case 12: type =Z_TYPE.SINGLE_CIRCLE; break;
            case 13: type = Z_TYPE.SNAKE_CIRCLE; break;
            case 14: type =Z_TYPE.STAIRS_PATH; break;
            case 15: type = Z_TYPE.MUSIC_PATH; break;
            case 16: type =Z_TYPE.STAIRS_RECT; break;
            case 17: type =Z_TYPE.CHART_RECT; break;
            default: Toast.makeText(context,"选择数字超出所有动画类型！",Toast.LENGTH_SHORT); break;
        }

        if(background.equals("#ffffff")){
            color = Color.BLACK; //背景为白色,字体和动画颜色设置为黑色色(默认透明背景,字体默认白色)
        }

        myDialog.setLoadingBuilder(type)//设置类型
                .setLoadingColor(color)//颜色
                .setHintText(message)
                .setHintTextSize(16) // 设置字体大小 dp
                .setHintTextColor(Color.WHITE)  // 设置字体颜色
                .setDurationTime(0.5) // 设置动画时间百分比 - 0.5倍
                .setDialogBackgroundColor(Color.parseColor(background)) // 设置背景色，默认白色
                .show();
    }

    @Override
    public void closeWaitDialog() {
        myDialog.dismiss();
    }

    /*****************************调用Github上高级自定义等待动画----结束*********************************/


    @Override
    public void bottomDialog(String topButtonName, String midButtonName,
                             final OnBottomDialogClickListener onBottomDialogClickListener) {
        final Dialog dialog = new Dialog(context, R.style.alert_dialog);
        View view = View.inflate(context, R.layout.dialog_bottom_sheet, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(true);
        view.setMinimumHeight((int) (SystemUtils.getScreenHeight(context) * 0.23f));
        Window dialogWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        lp.width = (int) (SystemUtils.getScreenWidth(context) * 0.9f);
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        dialogWindow.setAttributes(lp);
        dialog.show();
        final TextView topText = (TextView) view.findViewById(R.id.tv_one);
        final TextView midText = (TextView) view.findViewById(R.id.tv_two);
        final Button cancel = (Button) view.findViewById(R.id.bt_cancle);

        topText.setText(topButtonName);
        midText.setText(midButtonName);

        /**
         * 顶部按钮
         */
        topText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBottomDialogClickListener.onTopButtonClick();
                dialog.cancel();
            }
        });
        /**
         * 中间按钮
         */
        midText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBottomDialogClickListener.onMidButonClick();
                dialog.cancel();
            }
        });
        /**
         * 取消
         */
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBottomDialogClickListener.onCancelButtonClick();
                dialog.cancel();
            }
        });
    }



}
