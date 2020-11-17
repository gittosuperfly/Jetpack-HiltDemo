package com.cai.stu.hiltdemo.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "logger")
class Logger(@ColumnInfo(name = "message") var message: String) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id = 0

    @ColumnInfo(name = "update_time")
    var updateTime = System.currentTimeMillis()


    override fun toString(): String {
        return "Logger(message='$message', id=$id, updateTime=$updateTime)\n----------------\n"
    }
}
