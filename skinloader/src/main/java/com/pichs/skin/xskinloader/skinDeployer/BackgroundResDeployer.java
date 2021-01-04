package com.pichs.skin.xskinloader.skinDeployer;

import android.graphics.drawable.Drawable;
import android.view.View;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.entity.SkinConfig;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;

/**
 * Created by Windy on 2018/1/10.
 */

public class BackgroundResDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        if (SkinConfig.RES_TYPE_NAME_COLOR.equals(skinAttr.attrValueTypeName)) {
            view.setBackgroundColor(resource.getColor(skinAttr.attrValueRefId));
        } else if (SkinConfig.RES_TYPE_NAME_DRAWABLE.equals(skinAttr.attrValueTypeName)) {
            Drawable bg = resource.getDrawable(skinAttr.attrValueRefId);
            view.setBackground(bg);
        }else if (SkinConfig.RES_TYPE_NAME_MIPMAP.equals(skinAttr.attrValueTypeName)) {
            Drawable bg = resource.getDrawableForMapmip(skinAttr.attrValueRefId);
            view.setBackground(bg);
        }
    }
}
