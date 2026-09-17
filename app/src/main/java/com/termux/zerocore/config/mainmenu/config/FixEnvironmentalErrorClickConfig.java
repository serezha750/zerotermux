package com.termux.zerocore.config.mainmenu.config;

import static com.termux.zerocore.config.mainmenu.MainMenuConfig.CODE_COMMON_FUNCTIONS;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.example.xh_lib.utils.UUtils;
import com.termux.R;

public class FixEnvironmentalErrorClickConfig extends BaseMenuClickConfig {
    @Override
    public int getType() {
        return CODE_COMMON_FUNCTIONS;
    }

    @Override
    public Drawable getIcon(Context context) {
        return context.getDrawable(R.mipmap.chongzhi_ico);
    }

    @Override
    public String getString(Context context) {
        return context.getString(R.string.x11_so_install);
    }

    @Override
    public void onClick(View view, Context context) {
        // X11 功能已移除
        UUtils.showMsg(context.getString(R.string.x11_so_install_error));
    }
}
