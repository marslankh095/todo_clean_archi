package com.ne.samplenewars.domain.repository

import com.ne.samplenewars.domain.model.Todo


interface TodoRepository {
    suspend fun addTodo(todo: Todo)
}
