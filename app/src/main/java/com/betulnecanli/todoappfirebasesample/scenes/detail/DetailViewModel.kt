package com.betulnecanli.todoappfirebasesample.scenes.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betulnecanli.todoappfirebasesample.data.model.CheckList
import com.betulnecanli.todoappfirebasesample.data.model.Task
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore

class DetailViewModel : ViewModel(){

    private val firestore = FirebaseFirestore.getInstance()
    private var documentId: String = ""
    private lateinit var todoListCollection: CollectionReference
    private val taskArray = MutableLiveData<List<Task>>()

    // Set the document ID from the previous fragment
    fun setDocumentId(id: String) {
        documentId = id
        todoListCollection = firestore
            .collection("todoList")
            .document(documentId)
            .collection("tasks")

        observeTodoList()
    }

    init {
        taskArray.value = emptyList()
    }

    // Expose the taskArray as LiveData to the UI
    fun getTaskList(): LiveData<List<Task>> = taskArray

    fun observeTodoList() {
        todoListCollection.addSnapshotListener { querySnapshot, exception ->
            if (exception != null) {
                // Handle any errors that occurred
                return@addSnapshotListener
            }

            val newList = mutableListOf<Task>()
            querySnapshot?.let {
                for (document in it.documents) {
                    val task = document.toObject(Task::class.java)
                    if (task != null) {
                        newList.add(task)
                    }
                }
            }
            taskArray.value = newList
        }
    }
}