package com.pichs.skin.xskinloader.skinDeployer;

import android.view.View;

import androidx.cardview.widget.CardView;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.entity.SkinConfig;
import com.pichs.skin.xskinloader.skinInterface.ISkinResDeployer;
import com.pichs.skin.xskinloader.skinInterface.ISkinResourceManager;

/**
 * CardView 的 cardBackgroundColor 属性更换
 */
public class CardViewBackgroundColorResDeployer implements ISkinResDeployer {
    @Override
    public void deploy(View view, SkinAttr skinAttr, ISkinResourceManager resource) {
        if (
                view instanceof CardView &&
                skinAttr.attrName.equals("cardBackgroundColor") &&
                SkinConfig.RES_TYPE_NAME_COLOR.equals(skinAttr.attrValueTypeName)
        ) {
            ((CardView) view).setCardBackgroundColor(resource.getColor(skinAttr.attrValueRefId));
        }
    }
}
