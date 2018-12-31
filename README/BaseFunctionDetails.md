#### 使用基础功能前需要初始化：
```
new BaseFunction(this);
```

##### 简单封装弹出Toast：
```
showToast("测试");  //默认弹出时间短  

//设置弹出时间 
showToast("测试",Toast.LENGTH_SHORT); //弹出时间短  
showToast("测试",Toast.LENGTH_LONG);  //弹出时间长
```
