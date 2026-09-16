package com.termux.x11;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.view.KeyEvent;
import android.widget.FrameLayout;

public class MainActivity extends FrameLayout {

    public interface MainActivityOnKeyDown {
        boolean onKeyDown(int keyCode, KeyEvent event);
    }

    public MainActivity(Context context) {
        super(context);
        setVisibility(GONE);
    }

    public MainActivity(Activity activity) {
        super(activity);
        setVisibility(GONE);
    }

    public static boolean isConnected() {
        return false;
    }

    public void init() {}
    public void onPause() {}
    public void onResume() {}
    public void onDestroy() {}
    public void onDestroy(Activity activity) {}
    public void onConfigurationChanged(Configuration newConfig) {}
    public void onWindowFocusChanged(boolean hasFocus) {}
    public void setTerminalToolbarViewVisible(boolean visible) {}
    public void setMainActivityOnKeyDown(MainActivityOnKeyDown listener) {}
    public void setSettingsClick(Runnable listener) {}
}
