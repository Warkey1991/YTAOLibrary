package com.ytlibrary.dialog;

import android.content.Context;

/**
 * Author 余涛
 * Description 功能说明
 * Time 2018/12/12 17:23
 */
public interface IDialog {


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
     * @param topButtonName 顶部button名
     * @param midButtonName  中间button名
     * @param onBottomDialogClickListener 接口监听点击事件
     */
    void bottomDialog(String topButtonName , String midButtonName, final OnBottomDialogClickListener onBottomDialogClickListener);


    /**
     * bottomDialog辅助监听接口
     */
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


    /**
     * 基础dialog
     * @param title 标题
     * @param message 主体信息
     * @param positiveButtonName position按钮名
     * @param negativeButtonName negative按钮名
     * @param onBaseDialogClickListener  监听点击事件
     */
    void baseDialog(String title, String message, String positiveButtonName, String negativeButtonName,
                    final OnBaseDialogClickListener onBaseDialogClickListener );

    interface OnBaseDialogClickListener{

        /**
         * 确定按钮点击事件
         */
        void positiveOnClick();

        /**
         * 取消按钮点击事件
         */
        void negativeOnClick();

    }

    /**
     * 重载
     * @param message
     */
    void promptDialog(String message);

    /**
     * 简单提示dialog
     * @param message 提示信息
     * @param buttonName  按钮名
     * @param onPromptAlertClickListener  监听点击按钮接口
     */
    void promptDialog(String message, String buttonName, final OnPromptAlertClickListener onPromptAlertClickListener );

    interface OnPromptAlertClickListener{
        /**
         * 按钮点击事件
         */
        void buttonOnClick();
    }

}
