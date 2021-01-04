package com.pichs.skin.xskinloader.skinDeployer;

import android.content.res.ColorStateList;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.pichs.skin.xskinloader.SkinResDeployerFactory;
import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.entity.SkinConfig;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;

/**
 * Created by Windy on 2018/1/10.
 */

public class ImageDrawableResDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        if (!(view instanceof ImageView)) {
            return;
        }
        Drawable drawable = null;
        if (SkinConfig.RES_TYPE_NAME_COLOR.equals(skinAttr.attrValueTypeName)) {
            if (SkinResDeployerFactory.IMAGE_SRC.equals(skinAttr.attrName)) {
                drawable = new ColorDrawable(resource.getColor(skinAttr.attrValueRefId));
            } /*else if (SkinResDeployerFactory.IMAGE_TINT.equals(skinAttr.attrName)) {
                // 增加ImageView的tint控制, 控制的是colorFilter
                ((ImageView) view).setColorFilter(skinAttr.attrValueRefId);
            }*/
        } else if (SkinConfig.RES_TYPE_NAME_DRAWABLE.equals(skinAttr.attrValueTypeName)) {
            drawable = resource.getDrawable(skinAttr.attrValueRefId);
        } else if (SkinConfig.RES_TYPE_NAME_MIPMAP.equals(skinAttr.attrValueTypeName)) {
            drawable = resource.getDrawableForMapmip(skinAttr.attrValueRefId);
        }
        if (drawable != null) {
            ((ImageView) view).setImageDrawable(drawable);
        }
    }
}
