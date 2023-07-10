package com.betulnecanli.todoappfirebasesample.scenes.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betulnecanli.todoappfirebasesample.data.model.CheckList
import com.betulnecanli.todoappfirebasesample.data.model.Task
import com.google.firebase.firestore.FirebaseFirestore

class DetailViewModel : ViewModel(){

    val taskArray = MutableLiveData<List<Task>>()
    val firestore = FirebaseFirestore.getInstance()
    val todoListCollection = firestore.collection("todoList/tasks")

    init {
        taskArray.value = emptyList()
        observeTodoList()
    }
    // Expose the todoList as LiveData to the UI
    fun getTodoList(): LiveData<List<Task>> = taskArray

    fun observeTodoList() {
        todoListCollection.addSnapshotListener { querySnapshot, exception ->
            if (exception != null) {
                // Handle any errors that occurred
                return@addSnapshotListener
            }

            val newList = mutableListOf<Task>()
            querySnapshot?.let {
                for (document in it.documents) {
                    Log.d("mesajjj", "${document.data}")
                    //val title = document.data?.values.toString().removeSurrounding("[", "]")
                   // val todo = CheckList("${document.id}","$title")
                   // newList.add(todo)
                }
            }
            taskArray.value = newList
        }
    }
}