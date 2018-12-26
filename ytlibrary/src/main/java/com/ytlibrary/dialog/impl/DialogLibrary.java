package com.ytlibrary.dialog.impl;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ytlibrary.R;
import com.ytlibrary.dialog.IDialog;
import com.ytlibrary.util.SystemUtils;
import com.zyao89.view.zloading.ZLoadingDialog;
import com.zyao89.view.zloading.Z_TYPE;

/**
 * Author 余涛
 * Description Dialog功能库接口实现
 * Time 2018/12/12 16:42
 */
public class DialogLibrary implements IDialogLibrary {
    private Context context;
    private static Context myContext;
    private static DialogLibrary instance;

    public DialogLibrary(Context mContext){
        context = mContext;
        myContext = mContext;
    }

    public static DialogLibrary getInstance(){
        if(instance == null){
            instance = new DialogLibrary(myContext);
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

    /*****************************底部选择控件----开始*********************************/
    @Override
    public void bottomDialog(String topButtonName, String midButtonName,
                             final OnBottomDialogClick onBottomDialogClick) {
        final Dialog dialog = new Dialog(context, R.style.MyDialog);
        View view = View.inflate(context, R.layout.dialog_bottom_sheet, null);
        dialog.setContentView(view);
        dialog.setCanceledOnTouchOutside(false); //点击其他部分不消失
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
                onBottomDialogClick.onTopButtonClick();
                dialog.cancel();
            }
        });
        /**
         * 中间按钮
         */
        midText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBottomDialogClick.onMidButonClick();
                dialog.cancel();
            }
        });
        /**
         * 取消
         */
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBottomDialogClick.onCancelButtonClick();
                dialog.cancel();
            }
        });
    }
    /*****************************底部选择控件----结束*********************************/


    /*****************************基础对话控件----开始*********************************/
    @Override
    public void baseDialog(String title, String message, String positiveButtonName, String negativeButtonName,
                           final OnBaseDialogClick onBaseDialogClick) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.AlertDialog)
                .setTitle(title).setMessage(message)
                .setPositiveButton(positiveButtonName, new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        onBaseDialogClick.positiveOnClick();
                    }
                })
                .setNegativeButton(negativeButtonName, new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        onBaseDialogClick.negativeOnClick();
                    }
                }).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }

    @Override
    public void baseDialog(String title, String message, final OnSimBaseDialogClick onBaseDialogClick) {
        AlertDialog alertDialog = new AlertDialog.Builder(context, R.style.AlertDialog)
                .setTitle(title).setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {//添加"Yes"按钮
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        onBaseDialogClick.positiveOnClick();
                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {//添加取消
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        //点击取消,不进行操作
                    }
                }).create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
    /*****************************基础对话控件----结束*********************************/

    /*****************************简单提示控件----开始*********************************/
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void promptDialog(String message,String buttonName, final OnPromptDialogClick onPromptDialogClick) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(context, R.style.AlertDialog);
        dialog.setPositiveButton(buttonName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        final AlertDialog alertDialog = dialog.create();
//        TextView title = new TextView(context);
//        title.setText("");
//        title.setPadding(10, 30, 10, 10);
//        title.setGravity(Gravity.CENTER);
//        title.setTextSize(18);
//        title.setTextColor(Color.BLACK);
        TextView myMessage = new TextView(context);
        myMessage.setText(message);
        myMessage.setPadding(10, 50, 10, 30);
        myMessage.setGravity(Gravity.CENTER);
        myMessage.setTextSize(18);
        myMessage.setTextColor(Color.GRAY);
//        alertDialog.setCustomTitle(title);
        alertDialog.setView(myMessage);  //提示消息
        alertDialog.setCancelable(false);
        alertDialog.show();
        Button button = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
        LinearLayout.LayoutParams cancelBtnPara = (LinearLayout.LayoutParams) button.getLayoutParams();
        //设置按钮的大小
        cancelBtnPara.height = LinearLayout.LayoutParams.WRAP_CONTENT;
        cancelBtnPara.width = LinearLayout.LayoutParams.MATCH_PARENT;
        //设置文字居中
        cancelBtnPara.gravity = Gravity.CENTER;
        //设置按钮左上右下的距离
        cancelBtnPara.setMargins(100, 30, 100, 15);
        button.setLayoutParams(cancelBtnPara);
        button.setBackground(ContextCompat.getDrawable(context, R.color.transparent));
        button.setTextColor(ContextCompat.getColor(context, R.color.blue));
        button.setTextSize(19);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alertDialog.dismiss();
                onPromptDialogClick.buttonOnClick();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void promptDialog(String message) {
        promptDialog(message, "知道了", new OnPromptDialogClick() {
            @Override
            public void buttonOnClick() {
                //空逻辑
            }
        });
    }
    /*****************************简单提示控件----结束*********************************/



}
