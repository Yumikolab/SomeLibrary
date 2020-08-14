package com.licheedev.context

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import java.lang.reflect.InvocationTargetException

object AppProvider {

    val application: Application by lazy {
        initApplication()
    }

    private fun initApplication(): Application {
        var context = ApplicationContextProvider.autoContext
        if (context == null) {
            context = getApplicationByReflect()
        }
        return context.applicationContext as Application
    }

    @JvmStatic
    fun getApplicationByReflect(): Application {
        try {
            @SuppressLint("PrivateApi") val activityThread =
                Class.forName("android.app.ActivityThread")
            val thread =
                activityThread.getMethod("currentActivityThread").invoke(null)
            val app = activityThread.getMethod("getApplication").invoke(thread)
                ?: throw NullPointerException("you should init first")
            return app as Application
        } catch (e: NoSuchMethodException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        } catch (e: InvocationTargetException) {
            e.printStackTrace()
        } catch (e: ClassNotFoundException) {
            e.printStackTrace()
        }
        throw NullPointerException("you should init first")
    }


}