package com.termux.zerocore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.example.xh_lib.utils.UUtils;
import com.termux.R;

/**
 * ZeroTermux 背景布局（已移除 X11 内部通道相关逻辑）。
 */
public class ZeroTermuxBackLayout extends RelativeLayout {
    private View mBackgroundRoot;
    private View back_color;
    private ImageView back_img;
    private CustomerVideoView back_video;

    public ZeroTermuxBackLayout(Context context) {
        super(context);
    }

    public ZeroTermuxBackLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        initLayout(context);
    }

    public ZeroTermuxBackLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initLayout(context);
    }

    public ZeroTermuxBackLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initLayout(context);
    }

    private void initLayout(Context mContext) {
        View viewLay = UUtils.getViewLay(R.layout.layout_zero_termux);
        mBackgroundRoot = viewLay;
        back_color = viewLay.findViewById(R.id.back_color);
        back_img = viewLay.findViewById(R.id.back_img);
        back_video = viewLay.findViewById(R.id.back_video);
        addView(viewLay);
    }

    /** 兼容旧调用：X11 已移除，空实现。 */
    public void applyX11SystemInsets(android.app.Activity activity) {
        // no-op
    }

    public View getBackColor() {
        return back_color;
    }

    public ImageView getBackImg() {
        return back_img;
    }

    public VideoView getBackVideo() {
        return back_video;
    }

    /** 兼容旧调用：X11 已移除，返回 null。 */
    public Object getMainActivity() {
        return null;
    }
}
