package com.pichs.skin.xskinloader;

import android.util.AttributeSet;
import android.view.View;

import com.pichs.skin.xskinloader.entity.SkinAttr;
import com.pichs.skin.xskinloader.parser.ProgressBarIndeterminateDrawableStyleParser;
import com.pichs.skin.xskinloader.parser.TextViewTextColorStyleParser;
import com.pichs.skin.xskinloader.skinInterface.ISkinStyleParser;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Windy on 2018/2/10.
 */

public class StyleParserFactory {
    private static List<ISkinStyleParser> sStyleParserArray = new ArrayList<>();

    static {
        addStyleParser(new TextViewTextColorStyleParser());
        addStyleParser(new ProgressBarIndeterminateDrawableStyleParser());
    }

    public static void addStyleParser(ISkinStyleParser parser) {
        if (!sStyleParserArray.contains(parser)) {
            sStyleParserArray.add(parser);
        }
    }

    public static void parseStyle(View view, AttributeSet attrs, Map<String, SkinAttr> viewAttrs, String[] specifiedAttrList) {
        for (ISkinStyleParser parser : sStyleParserArray) {
            parser.parseXmlStyle(view, attrs, viewAttrs, specifiedAttrList);
        }
    }

}
