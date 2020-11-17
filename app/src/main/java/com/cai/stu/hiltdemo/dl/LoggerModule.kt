package com.cai.stu.hiltdemo.dl

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.cai.stu.hiltdemo.data.db.LoggerDao
import com.cai.stu.hiltdemo.data.model.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object LoggerModule {
    @Provides
    @Singleton
    fun provideAppDatabase(context: Application): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, "logger.db")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    @Singleton
    fun provideLoggerDao(appDatabase: AppDatabase): LoggerDao = appDatabase.getLoggerDao()

    @Database(entities = [Logger::class], version = 1, exportSchema = false)
    abstract class AppDatabase : RoomDatabase() {
        abstract fun getLoggerDao(): LoggerDao
    }
}