A simple To-Do App in Clean Architecture (Layered) with:

✅ Room Database (Entity, DAO, Database)

✅ Repository & UseCase

✅ ViewModel (with Coroutine + Logs)

✅ Simple UI (XML)

✅ Only Insert Feature

✅ Urdu Roman Comments (samajhnay k liye asaan)

🧩 Project Structure (Clean Architecture)
com.example.todo
│
├── data
│   ├── local
│   │   ├── TodoEntity.kt
│   │   ├── TodoDao.kt
│   │   └── TodoDatabase.kt
│   └── repository
│       └── TodoRepositoryImpl.kt
│
├── domain
│   ├── model
│   │   └── Todo.kt
│   ├── repository
│   │   └── TodoRepository.kt
│   └── usecase
│       └── AddTodoUseCase.kt
│
├── presentation
│   ├── TodoViewModel.kt
│   └── MainActivity.kt
│
└── res
    └── layout
        └── activity_main.xml

![Preview](1.PNG)


 ✅ App Flow:

User fills title & priority → presses "Add Todo"

ViewModel → UseCase → Repository → DAO → Database

Logcat me har step ka log show hoga
