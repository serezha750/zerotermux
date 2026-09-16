package com.termux.zerocore.editor

import android.view.View

/**
 * X11 功能已移除后的空实现 stub，保证编辑器 dock 仍可编译。
 */
class EditorX11Panel(private val root: View? = null) {
    fun isMaximized(): Boolean = false
    fun show() { /* no-op */ }
    fun hide() { /* no-op */ }
    fun destroy() { /* no-op */ }
    fun ensureSession(onReady: (() -> Unit)? = null) {
        onReady?.invoke()
    }
}
