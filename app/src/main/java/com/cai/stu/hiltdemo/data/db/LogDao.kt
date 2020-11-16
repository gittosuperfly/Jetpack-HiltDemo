package com.cai.stu.hiltdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.cai.stu.hiltdemo.data.model.Log

@Dao
interface LogDao {

    @Query("SELECT * FROM logs ORDER BY id DESC")
    fun getAll(): List<Log>

    @Insert
    fun insertAll(vararg logs: Log)

    @Query("DELETE FROM logs")
    fun emptyTable()
}