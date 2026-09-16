package com.termux.x11;

import android.app.Activity;
import android.content.Context;
import android.view.KeyEvent;
import android.widget.FrameLayout;

/**
 * X11 功能已移除后的空实现 stub，保证现有调用方仍能编译。
 * 所有方法均为 no-op。
 */
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

    public void init() {
        // no-op
    }

    public void onPause() {
        // no-op
    }

    public void onResume() {
        // no-op
    }

    public void onDestroy() {
        // no-op
    }

    public void setTerminalToolbarViewVisible(boolean visible) {
        // no-op
    }

    public void setMainActivityOnKeyDown(MainActivityOnKeyDown listener) {
        // no-op
    }
}
