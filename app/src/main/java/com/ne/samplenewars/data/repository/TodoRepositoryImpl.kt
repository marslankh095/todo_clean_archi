package com.ne.samplenewars.data.repository 

import android.util.Log
import com.ne.samplenewars.data.local.TodoDao
import com.ne.samplenewars.data.local.TodoEntity
import com.ne.samplenewars.domain.model.Todo
import com.ne.samplenewars.domain.repository.TodoRepository

class TodoRepositoryImpl(private val dao: TodoDao) : TodoRepository {
    override suspend fun addTodo(todo: Todo) {
        Log.d("TodoRepo", "Adding todo: ${todo.title}")
        dao.insertTask(
            TodoEntity(title = todo.title, priority = todo.priority)
        )
    }
}
