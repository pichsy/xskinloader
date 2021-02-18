# XSkinLoader


换肤方案， 参考github大神的[XSkinLoader](https://github.com/WindySha/XSkinLoader) ，并做了一些基础ui的支持
个人还是比较喜欢这种低侵入性的换肤框架：[XSkinLoader](https://github.com/WindySha/XSkinLoader)  我是一个代码搬运工。

- 在此框架基础上增加CardView背景属性换肤 <br>开放从皮肤资源包中获取Color的方法，方便代码使用。

- 此框架还会为 xwidget，xuikit 框架的换肤扩展做基础，为了保证稳定性，所以将此库搬运下来，自己维护。

- 点个star支持一下我吧！

### 引入

      ```
      
        implementation 'com.github.pichsy:xskinloader:1.0'
        
        
      ```

### 用法

- 可以参考： https://github.com/WindySha/XSkinLoader
- 基本一样。

```
      <?xml version="1.0" encoding="utf-8"?>
      <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
          xmlns:app="http://schemas.android.com/apk/res-auto"
          xmlns:skin="http://schemas.android.com/android/skin"
          android:layout_width="match_parent"
          android:layout_height="match_parent">
          增加skin命名空间
          
          <TextView
            skin:enable="true"/>
          
          </>
            
            
```
    
### 感谢
 [XSkinLoader](https://github.com/WindySha/XSkinLoader) 提供的支持
