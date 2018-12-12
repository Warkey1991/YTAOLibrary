package com.ytlibrary.dialog;

import android.content.Context;

/**
 * Author 余涛
 * Description 功能说明
 * Time 2018/12/12 17:23
 */
public interface DialogLibrary {


    /**
     * 重载设置默认值,默认背景透明,字体和动画为白色. 默认动画为:11(多圆旋转)
     * @param message 传入需要等待的信息
     */
    void waitDialog(String message);

    /**
     *  默认背景透明,字体和动画为白色
     * @param message 传入提示用户等待信息
     * @param cartoonStyle 动画类型（0-17）
     */
    void waitDialog(String message, int cartoonStyle );

    /**
     *  高级详细设置等待动画
     * @param message 传入等待信息
     * @param cartoonStyle 动画类型
     * @param background  dialog显示背景
     */
    void waitDialog(String message, int cartoonStyle, String background );

    /**
     * 关闭等待动画
     */
    void closeWaitDialog();


    /**
     * 底部弹出式，选择dialog
     * @param topButtonName
     * @param midButtonName
     * @param onBottomDialogClickListener
     */
    void bottomDialog(String topButtonName , String midButtonName, final OnBottomDialogClickListener onBottomDialogClickListener);


    interface OnBottomDialogClickListener{
        /**
         * 顶部按钮点击事件
         */
        void onTopButtonClick();

        /**
         * 中间按钮点击事件
         */
        void onMidButonClick();

        /**
         * 取消按钮点击事件
         */
        void onCancelButtonClick();
    }

}
