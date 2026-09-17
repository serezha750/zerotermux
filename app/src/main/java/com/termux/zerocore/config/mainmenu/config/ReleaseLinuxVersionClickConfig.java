package com.termux.zerocore.config.mainmenu.config;

import static com.termux.zerocore.config.mainmenu.MainMenuConfig.CODE_COMMON_FUNCTIONS;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;

import com.termux.R;
import com.termux.zerocore.code.CodeString;
import com.termux.zerocore.utils.SingletonCommunicationUtils;

/**
 * 常用功能 → 发行版本：使用官方 proot-distro 管理发行版。
 * https://github.com/termux/proot-distro
 */
public class ReleaseLinuxVersionClickConfig extends BaseMenuClickConfig {
    @Override
    public int getType() {
        return CODE_COMMON_FUNCTIONS;
    }

    @Override
    public Drawable getIcon(Context context) {
        return context.getDrawable(R.mipmap.linux_ico);
    }

    @Override
    public String getString(Context context) {
        return context.getString(R.string.发行版本);
    }

    @Override
    public void onClick(View view, Context context) {
        // 安装 proot-distro（若已安装则跳过更新耗时由 pkg 处理），列出可用发行版并提示用法
        SingletonCommunicationUtils.getInstance()
            .getmSingletonCommunicationListener()
            .sendTextToTerminal(CodeString.INSTANCE.getRunLinuxSh());
    }
}
