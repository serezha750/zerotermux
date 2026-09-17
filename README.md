# ZeroTermux

基于 [Termux](https://github.com/termux/termux-app) 的增强版 Android 终端模拟器。

<div align="center">
  <img src="img/6c5478a95ca60212eaee2f71f3e9f838_720.jpg" height="200" alt="screenshot">
  <img src="img/95d76c74cd49693d074d2eda75d20a03_720.jpg" height="200" alt="screenshot">
</div>

**当前版本：`0.118.3.65`**

## 功能概览

相对官方 Termux，本项目额外提供：

- 备份与恢复
- 容器切换
- 软件源切换
- Linux 发行版支持（Ubuntu、Kali 等）
- 文件管理、常用工具与界面增强

默认软件源面向国内用户（清华源 / 北京源等，可手动切换）。海外用户建议优先使用 [官方 Termux](https://github.com/termux/termux-app)。

熟悉基础操作后，也建议视需求逐步迁移到官方 Termux。

## 下载

请到本仓库 **[Releases](https://github.com/serezha750/zerotermux/releases)** 下载对应架构的 APK。

常见产物命名示例：

| 文件 | 说明 |
|------|------|
| `ZeroTermux-0.118.3.65-release_universal.apk` | 通用包 |
| `ZeroTermux-0.118.3.65-release_arm64-v8a.apk` | ARM64 |
| `ZeroTermux-0.118.3.65-release_armeabi-v7a.apk` | ARMv7 |
| `ZeroTermux-0.118.3.65-release_x86.apk` / `x86_64` | 模拟器 / x86 设备 |

也可通过 GitHub Actions 的构建产物（Artifacts）获取 Debug / Release 包。

## 自行编译

### 环境要求

- JDK 17
- Android SDK（`compileSdk 36`，见 `gradle.properties`）
- Android NDK（版本见 `gradle.properties` 中的 `ndkVersion`）

### 构建命令

```bash
chmod +x gradlew
./gradlew :app:assembleDebug
./gradlew :app:assembleRelease
```

输出目录：

```text
app/build/outputs/apk/debug/
app/build/outputs/apk/release/
```

签名相关配置见 `app/build.gradle` 中的 `signingConfigs`（可通过环境变量 `KEY_ALIAS`、`KEY_PASSWORD`、`STORE_PASSWORD` 覆盖）。

### CI

推送到 `main` 或手动触发 **CI** 工作流，会按架构矩阵编译 Debug / Release APK 并上传 Artifacts。

## 语言

界面与文档主要支持 **中文** 与 **英文**。

## 上游与致谢

本项目基于并使用了以下开源工作（不完全列表）：

| 项目 | 链接 |
|------|------|
| termux-app | https://github.com/termux/termux-app |
| termux-packages | https://github.com/termux/termux-packages |
| termux-api | https://github.com/termux/termux-api |
| termux-styling | https://github.com/termux/termux-styling |
| termux-tasker | https://github.com/termux/termux-tasker |
| AgentWeb | https://github.com/Justson/AgentWeb |
| XXPermissions | https://github.com/getActivity/XXPermissions |
| libaums | https://github.com/magnusja/libaums |
| glide | https://github.com/bumptech/glide |
| ImmersionBar | https://github.com/gyf-dev/ImmersionBar |
| ttyd | https://github.com/tsl0922/ttyd |
| filebrowser | https://github.com/filebrowser/filebrowser |

更多许可说明见 [LICENSE.md](LICENSE.md)。

## 声明

1. ZeroTermux 为开源软件，遵循 GPL 许可条款分发与修改。详见 [LICENSE.md](LICENSE.md) 与 [GPLv3](https://www.gnu.org/licenses/gpl-3.0.html)。
2. 本软件功能仅供学习与交流，使用者须自行承担使用风险。
3. 备份包、数据包、zip/模块等第三方内容来源不一，请自行甄别；因使用此类内容造成的损失由使用者自行承担。
4. 使用本软件可能对设备造成影响，作者与项目不对任何直接或间接损失承担责任。

## 相关资源

- 官方 Termux：https://github.com/termux/termux-app
- X11 相关实现参考：https://github.com/hanxinhao000/ZeroTermux-X11-aar

