package com.termux.zerocore.filetype

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.zp.z_file.listener.ZFileImageListener
import java.io.File
import java.util.Locale

/**
 * 文件列表缩略图加载（性能优化）：
 * - 仅对图片扩展名走 Glide，其它类型用静态图标避免解码
 * - 限制解码尺寸、禁用动画、用 RESOURCE 缓存降低滚动卡顿
 */
class MyFileImageListener : ZFileImageListener() {

    companion object {
        private val IMAGE_EXT = setOf(
            "jpg", "jpeg", "png", "gif", "webp", "bmp", "heic", "heif"
        )
        // 列表图标约 40–56dp，解码到 128px 足够
        private const val THUMB_PX = 128

        private val thumbOptions: RequestOptions = RequestOptions()
            .override(THUMB_PX, THUMB_PX)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
            .dontAnimate()
            .placeholder(com.zp.z_file.R.drawable.ic_zfile_other)
            .error(com.zp.z_file.R.drawable.ic_zfile_other)
    }

    override fun loadImage(imageView: ImageView, file: File) {
        val ext = file.extension.lowercase(Locale.US)
        if (ext !in IMAGE_EXT) {
            // 非图片：取消可能残留的 Glide 请求，直接设静态图，避免无意义 IO
            Glide.with(imageView).clear(imageView)
            imageView.setImageResource(com.zp.z_file.R.drawable.ic_zfile_other)
            return
        }
        Glide.with(imageView.context)
            .load(file)
            .apply(thumbOptions)
            .into(imageView)
    }

    override fun loadVideo(imageView: ImageView, file: File) {
        // 视频也走缩略图解码，限制尺寸
        Glide.with(imageView.context)
            .load(file)
            .apply(thumbOptions)
            .into(imageView)
    }
}
