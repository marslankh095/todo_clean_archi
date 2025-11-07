package com.ne.samplenewars.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TodoDao {

    // 🔹 Insert function suspend because database call background me hoga
    @Insert
    suspend fun insertTask(todo: TodoEntity)

    @Query("SELECT * FROM todo_table")
    suspend fun getAll(): List<TodoEntity>
}
