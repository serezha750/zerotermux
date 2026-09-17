package com.termux.zerocore.config.mainmenu;

import android.content.Context;

import com.termux.R;
import com.termux.zerocore.config.BaseConfig;
import com.termux.zerocore.config.mainmenu.config.AdbShellRunClickConfig;
import com.termux.zerocore.config.mainmenu.config.BackupRestoreClickConfig;
import com.termux.zerocore.config.mainmenu.config.BeautificationSettingsClickConfig;
import com.termux.zerocore.config.mainmenu.config.BootCommandClickConfig;
import com.termux.zerocore.config.mainmenu.config.ChangBashClickConfig;
import com.termux.zerocore.config.mainmenu.config.ChangStartMsgClickConfig;
import com.termux.zerocore.config.mainmenu.config.ClearStyleClickConfig;
import com.termux.zerocore.config.mainmenu.config.CloseTurnNetworkAdbClickConfig;
import com.termux.zerocore.config.mainmenu.config.CommandDefinitionCLickConfig;
import com.termux.zerocore.config.mainmenu.config.CommonlyUsedSoftLinksDataClickConfig;
import com.termux.zerocore.config.mainmenu.config.DataMessageClickConfig;
import com.termux.zerocore.config.mainmenu.config.DefBashClickConfig;
import com.termux.zerocore.config.mainmenu.config.DockerCheckClickConfig;
import com.termux.zerocore.config.mainmenu.config.FloatWindowsClickConfig;
import com.termux.zerocore.config.mainmenu.config.FontSettingsClickConfig;
import com.termux.zerocore.config.mainmenu.config.FullScreenClickConfig;
import com.termux.zerocore.config.mainmenu.config.GitHubClickConfig;
import com.termux.zerocore.config.mainmenu.config.InstallModuleClickConfig;
import com.termux.zerocore.config.mainmenu.config.KeyDataClickConfig;
import com.termux.zerocore.config.mainmenu.config.LanguageClickConfig;
import com.termux.zerocore.config.mainmenu.config.MainMenuClickConfig;
import com.termux.zerocore.config.mainmenu.config.MyUsedSoftLinksDataClickConfig;
import com.termux.zerocore.config.mainmenu.config.OpenPathClickConfig;
import com.termux.zerocore.config.mainmenu.config.OpenTurnNetworkAdbClickConfig;
import com.termux.zerocore.config.mainmenu.config.ParticleClickConfig;
import com.termux.zerocore.config.mainmenu.config.PhoneSmsClickConfig;
import com.termux.zerocore.config.mainmenu.config.ReleaseLinuxVersionClickConfig;
import com.termux.zerocore.config.mainmenu.config.ScheduledTaskClickConfig;
import com.termux.zerocore.config.mainmenu.config.SnowflakeClickConfig;
import com.termux.zerocore.config.mainmenu.config.SwitchSourceClickConfig;
import com.termux.zerocore.config.mainmenu.config.UnInstallClickConfig;
import com.termux.zerocore.config.mainmenu.config.X86AlpineDataClickConfig;
import com.termux.zerocore.config.mainmenu.config.ZTCommandKeyClickConfig;
import com.termux.zerocore.config.mainmenu.config.ZTSettingsClickConfig;
import com.termux.zerocore.config.mainmenu.data.MainMenuCategoryData;

import java.util.ArrayList;

/**
 * 主菜单配置（已移除 X11 功能、线上功能相关入口）。
 * 保留：开机启动、ZT 目录相关、备份恢复等。
 */
public class MainMenuConfig implements BaseConfig {
    public static final int CODE_COMMON_FUNCTIONS = 0;
    /** @deprecated X11 功能已移除，保留常量避免外部引用崩溃 */
    @Deprecated
    public static final int CODE_X11_FEATURES = 1;
    public static final int CODE_BEAUTIFICATION_FUNCTION = 2;
    /** @deprecated 线上功能已移除，保留常量避免外部引用崩溃 */
    @Deprecated
    public static final int CODE_ONLINE_FEATURES = 3;
    public static final int CODE_ZT_FEATURES = 4;
    public static final int CODE_ZT_ROOT = 5;
    public static final int CODE_ZT_ENGINE = 6;
    public static final int CODE_ZT_CONFIG = 7;
    /** @deprecated 创建项目菜单已移除 */
    public static final int CODE_CREATE_PROJECT = 8;

    private static ArrayList<MainMenuCategoryData> MAIN_MENU_CATEGORY_DATAS = new ArrayList<>();

    public static void init(Context context) {
        MAIN_MENU_CATEGORY_DATAS.clear();

        // 常用功能
        ArrayList<MainMenuClickConfig> commonClicks = new ArrayList<>();
        commonClicks.add(new SwitchSourceClickConfig());
        commonClicks.add(new BackupRestoreClickConfig());
        commonClicks.add(new ReleaseLinuxVersionClickConfig());
        commonClicks.add(new ZTSettingsClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.common_functions), CODE_COMMON_FUNCTIONS, commonClicks));

        // X11 功能 — 已彻底移除
        // 线上功能 — 已彻底移除

        // 美化/UI 功能
        ArrayList<MainMenuClickConfig> beautificationClicks = new ArrayList<>();
        beautificationClicks.add(new FloatWindowsClickConfig());
        beautificationClicks.add(new BeautificationSettingsClickConfig());
        beautificationClicks.add(new FontSettingsClickConfig());
        beautificationClicks.add(new FullScreenClickConfig());
        beautificationClicks.add(new SnowflakeClickConfig());
        beautificationClicks.add(new ParticleClickConfig());
        beautificationClicks.add(new ClearStyleClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.beautification_function), CODE_BEAUTIFICATION_FUNCTION, beautificationClicks));

        // 需要引擎
        ArrayList<MainMenuClickConfig> engineClicks = new ArrayList<>();
        engineClicks.add(new KeyDataClickConfig());
        engineClicks.add(new X86AlpineDataClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.zt_engine), CODE_ZT_ENGINE, engineClicks));

        // ROOT 功能
        ArrayList<MainMenuClickConfig> rootClicks = new ArrayList<>();
        rootClicks.add(new OpenTurnNetworkAdbClickConfig());
        rootClicks.add(new CloseTurnNetworkAdbClickConfig());
        rootClicks.add(new DockerCheckClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.zt_root_fun), CODE_ZT_ROOT, rootClicks));

        // 配置文件（保留开机启动）
        ArrayList<MainMenuClickConfig> configClicks = new ArrayList<>();
        configClicks.add(new AdbShellRunClickConfig());
        configClicks.add(new ZTCommandKeyClickConfig());
        configClicks.add(new DefBashClickConfig());
        configClicks.add(new ChangBashClickConfig());
        configClicks.add(new ChangStartMsgClickConfig());
        configClicks.add(new CommandDefinitionCLickConfig());
        configClicks.add(new BootCommandClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.zt_menu_title_config), CODE_ZT_CONFIG, configClicks));

        // ZT功能（已移除 FTP、远程连接等线上相关）
        ArrayList<MainMenuClickConfig> ztFeaturesClicks = new ArrayList<>();
        ztFeaturesClicks.add(new InstallModuleClickConfig());
        ztFeaturesClicks.add(new CommonlyUsedSoftLinksDataClickConfig());
        ztFeaturesClicks.add(new MyUsedSoftLinksDataClickConfig());
        ztFeaturesClicks.add(new UnInstallClickConfig());
        ztFeaturesClicks.add(new PhoneSmsClickConfig());
        ztFeaturesClicks.add(new ScheduledTaskClickConfig());
        ztFeaturesClicks.add(new OpenPathClickConfig());
        ztFeaturesClicks.add(new DataMessageClickConfig());
        ztFeaturesClicks.add(new LanguageClickConfig());
        ztFeaturesClicks.add(new GitHubClickConfig());
        MAIN_MENU_CATEGORY_DATAS.add(new MainMenuCategoryData(context.getString(R.string.zt_features), CODE_ZT_FEATURES, ztFeaturesClicks));
    }

    public static ArrayList<MainMenuCategoryData> getMainMenuCategoryDatas() {
        return MAIN_MENU_CATEGORY_DATAS;
    }
}
