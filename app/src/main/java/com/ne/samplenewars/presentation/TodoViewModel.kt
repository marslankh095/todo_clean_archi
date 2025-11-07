package com.ne.samplenewars.presentation
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ne.samplenewars.domain.model.Todo
import com.ne.samplenewars.domain.usecase.AddTodoUseCase
import kotlinx.coroutines.launch

class TodoViewModel(private val addTodoUseCase: AddTodoUseCase) : ViewModel() {

    fun insertTodo(title: String, priority: String) {
        Log.d("TodoViewModel", "Insert triggered")
        viewModelScope.launch {
            addTodoUseCase(Todo(title, priority))
        }
    }
}
