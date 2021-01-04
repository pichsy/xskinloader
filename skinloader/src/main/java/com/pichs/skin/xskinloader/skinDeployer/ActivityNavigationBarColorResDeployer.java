package com.pichs.skin.xskinloader.skinDeployer;

import android.os.Build;
import android.view.View;
import android.view.Window;

import androidx.core.content.ContextCompat;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;
import com.pichs.skin.xskinloader.util.ReflectUtils;

import static android.view.WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS;

public class ActivityNavigationBarColorResDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        Window window;
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            //API23以上，DecorView独立成一个类，并持有mWindow对象
            window = (Window) ReflectUtils.getField(view, "mWindow");
        } else {
            //API23以下，DecorView是PhoneWindow的内部类，隐式持有PhoneWindow对象
            window = ReflectUtils.getExternalField(view);
        }
        if (window == null) {
            throw new IllegalArgumentException("view is not a DecorView, cannot get the window");
        }
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                window.addFlags(FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                //底部导航栏
                window.setNavigationBarColor(resource.getColor(skinAttr.attrValueRefId));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
