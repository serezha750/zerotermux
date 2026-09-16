package com.termux.zerocore.workstation

import java.io.File

/**
 * 线上 Workstation 已移除后的空实现 stub。
 */
object ZtWorkstationFileHelper {
    fun resolveSafePath(path: String): File? = null
    fun listDirectory(path: String): Any = emptyList<Any>()
    fun readText(path: String, maxBytes: Int = 0): String = ""
    fun writeText(path: String, content: String): Boolean = false
    fun createFile(path: String): Boolean = false
    fun mkdir(path: String): Boolean = false
    fun delete(path: String): Boolean = false
    fun stat(path: String): Any? = null
}
