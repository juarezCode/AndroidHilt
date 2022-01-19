package com.juarez.androidhilt

import android.content.Context
import androidx.fragment.app.FragmentActivity
import androidx.room.Room
import com.juarez.androidhilt.db.AppDatabase
import com.juarez.androidhilt.db.LoggerLocalDataSource

class ServiceLocator(applicationContext: Context) {

    private val logsDatabase = Room.databaseBuilder(
        applicationContext,
        AppDatabase::class.java,
        "logging.db"
    ).build()

    val loggerLocalDataSource = LoggerLocalDataSource(logsDatabase.logDao())

    fun provideDateFormatter() = DateFormatter()

    fun provideNavigator(activity: FragmentActivity): AppNavigator {
        return AppNavigatorImpl(activity)
    }
}