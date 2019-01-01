## Dialog篇
### 使用封装的dialog控件需要先实例化对象
```
IDialogLibrary dialogLibrary = new DialogLibrary(this);
```

***
</br>

### 等待弹窗(waitDialog)
#### 说明：该控件是对另一依赖库的进一步封装，详细请看 [自定义Loading View库](https://github.com/zyao89/ZLoading)
#### 使用方式:
- 等待加载弹窗关闭，统一使用
```
dialogLibrary.closeWaitDialog();
```

- 极简使用:只需要传一个变量，等待信息（message）String类型
```
dialogLibrary.waitDialog("测试");
```
- 效果图
<img src="/README/picture/waitDialog.gif" width = "337" height = "600"/>

- 二重设置：传俩个变量，第一个，等待信息（message）String类型；第二个动画类型(cartoonStyle)int类型（只限0-17，18种动画类型）。
```
dialogLibrary.waitDialog("测试", 12);
```
- 效果图
<img src="/README/picture/waitDialogOne.gif" width = "337" height = "600"/>

- 三重设置：传三个变量，第一个，等待信息（message）String类型；第二个动画类型（cartoonStyle）int类型（只限0-17，18种动画类型）；第三个，动画背景（background）String类型，传入颜色代码，参照下方范例。
```
dialogLibrary.waitDialog("测试",13, "#6C6C6C");
```
- 效果图
<img src="/README/picture/waitDialogTwo.gif" width = "337" height = "600"/>

***
</br>

### 底部弹窗(bottomDialog)
#### 使用方式:
```
dialogLibrary.bottomDialog("顶部（替换）", "中间（替换）", new IDialog.bottomDialog.OnBottomDialogClick() {
            @Override
            public void onTopButtonClick() {
                showToast("自定义你的逻辑");
            }

            @Override
            public void onMidButonClick() {
                showToast("自定义你的逻辑");
            }

            @Override
            public void onCancelButtonClick() {
                showToast("自定义你的逻辑");
            }
        });
```
