package com.termux.zerocore.workstation

import android.content.Context

/** 线上 Workstation 已移除后的空实现 stub。 */
object ZtWorkstationSmsHelper {
    fun listThreads(context: Context): Any = emptyList<Any>()
    fun listMessages(context: Context, threadId: String? = null, limit: Int = 0): Any = emptyList<Any>()
}
