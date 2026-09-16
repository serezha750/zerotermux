package com.termux.zerocore.editor

import android.app.Activity
import android.content.res.Configuration
import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import io.github.rosemoe.sora.widget.CodeEditor

/**
 * X11 / 内置 GUI 功能已移除后的空实现。
 * 保留原构造与公开方法签名，保证编辑器相关代码可编译。
 */
class EditorX11Panel(
    private val activity: Activity,
    private val surfaceContainer: FrameLayout,
    private val setupPanel: View,
    private val setupMessageView: TextView,
    private val setupActionView: TextView,
    private val statusView: TextView,
    private val displayButton: TextView?,
    private val connectButton: TextView?,
    private val maximizeButton: ImageView,
    private val codeEditor: CodeEditor?,
    private val dockHeightController: DockHeightController,
    private val onWriteTerminal: (String) -> Unit,
    private val onEnsureTerminal: () -> Unit,
    private val isShellX11Ready: () -> Boolean,
    private val onLayoutChanged: () -> Unit,
    private val onTabActiveChanged: (Boolean) -> Unit,
    private val onBarActionsChanged: () -> Unit
) {

    interface DockHeightController {
        fun saveDockedHeight()
        fun restoreDockedHeight()
    }

    fun init() {
        surfaceContainer.visibility = View.GONE
        setupPanel.visibility = View.GONE
        statusView.text = "X11 removed"
    }

    fun isSetupMode(): Boolean = false
    fun isBootstrapInProgress(): Boolean = false
    fun isAvailable(): Boolean = false
    fun isTabActive(): Boolean = false
    fun isMaximized(): Boolean = false

    fun prepareForProgramRun(onReady: () -> Unit) {
        onReady()
    }

    fun onGuiAppStarted() {}
    fun onTabShown() {}
    fun onTabHidden() {}
    fun onDockHidden() {}
    fun restoreFromMaximized(): Boolean = false
    fun onResume() {}
    fun onPause() {}
    fun onDestroy() {
        surfaceContainer.removeAllViews()
    }
    fun onConfigurationChanged(@Suppress("UNUSED_PARAMETER") newConfig: Configuration) {}
    fun onWindowFocusChanged(@Suppress("UNUSED_PARAMETER") hasFocus: Boolean) {}
    fun onHostLayoutChanged() {}
}
