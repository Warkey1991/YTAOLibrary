package com.ytlibrary.dialog.impl;

import com.ytlibrary.dialog.IDialog;

/**
 * Author 余涛
 * Description 接口中转,接口可以多继承接口
 * Time 2018/12/24 22:38
 */
public interface IDialogLibrary extends IDialog.baseDialog,IDialog.bottomDialog,
        IDialog.promptDialog,IDialog.waitDialog {
    /**
     * 这里可以更加灵活的控件接口,如若不想要某个功能模块,可以直接去掉继承的某个接口模块便可.
     */
}
