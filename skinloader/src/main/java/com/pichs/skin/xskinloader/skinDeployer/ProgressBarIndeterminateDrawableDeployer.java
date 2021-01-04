package com.pichs.skin.xskinloader.skinDeployer;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ProgressBar;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.entity.SkinConfig;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;

/**
 * Created by Windy on 2018/1/23.
 */

public class ProgressBarIndeterminateDrawableDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        if (!(view instanceof ProgressBar)) {
            return;
        }

        ProgressBar pb = (ProgressBar) view;
        Drawable drawable = null;
        if (SkinConfig.RES_TYPE_NAME_COLOR.equals(skinAttr.attrValueTypeName)) {
            drawable = new ColorDrawable(resource.getColor(skinAttr.attrValueRefId));
        } else if (SkinConfig.RES_TYPE_NAME_DRAWABLE.equals(skinAttr.attrValueTypeName)) {
            drawable = resource.getDrawable(skinAttr.attrValueRefId);
        }
        if (drawable != null) {
            pb.setIndeterminateDrawable(drawable);
        }
    }
}
