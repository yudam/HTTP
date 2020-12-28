package com.mdy.http.cache

import android.app.Application
import okhttp3.internal.cache.DiskLruCache
import okhttp3.internal.io.FileSystem

/**
 * User: maodayu
 * Date: 2020/12/21 11:41
 */
class CacheManager(val app:Application) {

    internal val cache = DiskLruCache(FileSystem.SYSTEM,app.cacheDir,
    )
}