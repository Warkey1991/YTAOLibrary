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
- 极简使用：传俩个变量，实现一个接口。</br>
第一个，顶部按钮名（topButtonName）String类型；第二个，中间按钮名（midButtonName）String类型；第三个，实现 OnBottomDialogClick 接口。</br>
实现接口全称：new IDialog.bottomDialog.OnBottomDialogClick(){...}，IDialog.bottomDialog.* 。</br>
抱歉名字比较长，为了规范化接口方法名管理，使逻辑结构更清晰，思考了很久，才选择定义了二重接口。
```
dialogLibrary.bottomDialog("顶部（替换）", "中间（替换）", new IDialog.bottomDialog.OnBottomDialogClick() {
            @Override
            public void onTopButtonClick() {
                showToast("自定义你的逻辑"); //该方法取自基本功能封装类
            }

            @Override
            public void onMidButonClick() {
                showToast("自定义你的逻辑");
            }
        });
```
- 效果图
<img src="/README/picture/bottomDialog.jpg" width = "337" height = "600"/>

- 高级使用：传六个变量，实现一个接口。</br>
该种使用，不推荐直接使用，可以按照各自的需求简单封装。</br>
第一个顶部按钮名（topButtonName）String类型；第二个，顶部按钮颜色（topColor）String类型；</br>
第三个，中间按钮名（midButtonName）String类型；第四个，中间按钮颜色（midColor）String类型；</br>
第五个，取消按钮名（cancelButtonName）String类型；第六个，取消按钮颜色（cancelColor）String类型。</br>
实现 OnBottomDialogDetailClick 接口。具体使用见下方代码范例。
```
dialogLibrary.bottomDialog("顶部按钮", "#008577", "中间按钮", "#00574B", "取消按钮", "#D81B60",
                new IDialog.bottomDialog.OnBottomDialogHighClick() {
                    @Override
                    public void onTopButtonClick() {
                        //添加你的逻辑,或者接口监听该项
                    }

                    @Override
                    public void onMidButonClick() {
                        //添加你的逻辑,或者接口监听该项
                    }

                    @Override
                    public void onCancelButtonClick() {
                        //添加你的逻辑,或者接口监听该项
                    }
                });
    }
```
- 效果图
<img src="/README/picture/bottomDialogOne.png" width = "337" height = "600"/>


***
</br>

### 提示弹窗（promptDialog）
