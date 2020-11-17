package com.cai.stu.hiltdemo.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.cai.stu.hiltdemo.data.model.Logger

@Dao
interface LoggerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(logger: Logger)

    @Query(value = "SELECT * FROM logger")
    suspend fun queryAll(): List<Logger>
}