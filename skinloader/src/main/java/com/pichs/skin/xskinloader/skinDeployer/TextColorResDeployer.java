package com.pichs.skin.xskinloader.skinDeployer;

import android.view.View;
import android.widget.TextView;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.entity.SkinConfig;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;

/**
 * Created by Windy on 2018/1/10.
 */

public class TextColorResDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        if (view instanceof TextView && SkinConfig.RES_TYPE_NAME_COLOR.equals(skinAttr.attrValueTypeName)) {
            TextView tv = (TextView) view;
            tv.setTextColor(resource.getColorStateList(skinAttr.attrValueRefId));
        }
    }
}
