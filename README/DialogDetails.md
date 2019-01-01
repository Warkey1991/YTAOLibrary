# Dialog篇
## 使用封装的dialog控件需要先实例化对象
```
IDialogLibrary dialogLibrary = new DialogLibrary(this);
```
## 等待弹窗(waitDialog)
### 使用方式:

- 极简使用:只需要传一个变量，类型字符串(String)
```
dialogLibrary.waitDialog("测试");
```

- 二重使用:
```

```

## 底部弹窗(bottomDialog)
### 使用方式:
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
