package com.ne.samplenewars.domain.usecase

import android.util.Log
import com.ne.samplenewars.domain.model.Todo
import com.ne.samplenewars.domain.repository.TodoRepository

class AddTodoUseCase(private val repository: TodoRepository) {
    suspend operator fun invoke(todo: Todo) {
        Log.d("AddTodoUseCase", "UseCase Triggered for: ${todo.title}")
        repository.addTodo(todo)
    }
}
/*

mkdir data
mkdir data\local
mkdir data\repository
mkdir domain
mkdir domain\model
mkdir domain\repository
mkdir domain\usecase
mkdir presentation


 */