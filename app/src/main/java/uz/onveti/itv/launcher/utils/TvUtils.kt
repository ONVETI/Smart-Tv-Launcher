package uz.onveti.itv.launcher.utils

import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager

fun isTVDevice(packageManager: PackageManager): Boolean {
    return packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)
}

private fun isMediaApp(packageName: String): Boolean {
    val mediaApps = listOf(
        "com.netflix.ninja", "com.amazon.amazonvideo.livingroom",
        "com.google.android.youtube.tv", "com.spotify.tv.android",
        "com.mxtech.videoplayer.television", "org.xbmc.kodi"
    )
    return packageName in mediaApps
}

private fun isGameApp(packageName: String, packageManager: PackageManager): Boolean {
    return packageName.contains("game") || packageManager.getApplicationInfo(
        packageName,
        0
    ).category == ApplicationInfo.CATEGORY_GAME
}

private fun isUtilityApp(packageName: String): Boolean {
    val utilityApps = listOf(
        "com.android.settings", "com.android.tv.settings",
        "com.android.vending", "com.google.android.apps.tv.launcherx"
    )
    return packageName in utilityApps
}