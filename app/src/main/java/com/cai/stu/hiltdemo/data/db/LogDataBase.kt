package com.cai.stu.hiltdemo.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.cai.stu.hiltdemo.data.model.Log

@Database(entities = [Log::class], version = 1, exportSchema = false)
abstract class LogDataBase : RoomDatabase() {
    abstract fun logDao(): LogDao
}