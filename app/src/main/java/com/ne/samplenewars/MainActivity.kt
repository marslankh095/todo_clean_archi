package com.ne.samplenewars

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText 
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.ne.samplenewars.data.local.TodoDatabase
import com.ne.samplenewars.data.repository.TodoRepositoryImpl
import com.ne.samplenewars.domain.usecase.AddTodoUseCase
import com.ne.samplenewars.presentation.TodoViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: TodoViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 🔹 Room Database Init
        val db = Room.databaseBuilder(
            applicationContext,
            TodoDatabase::class.java,
            "todo_db"
        ).build()

        val repository = TodoRepositoryImpl(db.todoDao())
        val useCase = AddTodoUseCase(repository)

        // 🔹 ViewModel manual factory
        viewModel = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return TodoViewModel(useCase) as T
            }
        }.create(TodoViewModel::class.java)

        // 🔹 UI Bindings
        val titleEdit = findViewById<EditText>(R.id.edtTitle)
        val priorityEdit = findViewById<EditText>(R.id.edtPriority)
        val btnAdd = findViewById<Button>(R.id.btnAdd)

        btnAdd.setOnClickListener {
            val title = titleEdit.text.toString()
            val priority = priorityEdit.text.toString()
            viewModel.insertTodo(title, priority)
            Log.d("MainActivity", "Clicked add button")
        }
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