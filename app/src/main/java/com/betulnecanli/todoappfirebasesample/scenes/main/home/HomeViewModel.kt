package com.betulnecanli.todoappfirebasesample.scenes.main.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betulnecanli.todoappfirebasesample.data.model.CheckList
import com.google.firebase.firestore.FirebaseFirestore

class HomeViewModel : ViewModel() {

    /*
      // Collection: "users"
      {
          // Document ID: "user1"
          "name": "John Doe",  //field
           "email": "johndoe@example.com", //field
           "age": 25 //field
      },
      {
           // Document ID: "user2"
           "name": "Jane Smith", //field
          "email": "janesmith@example.com", //field
          "age": 30 //field
          }

  */


    val todoArray = MutableLiveData<List<CheckList>>()

    val firestore = FirebaseFirestore.getInstance()
    val todoListCollection = firestore.collection("todoList")

    init {
    todoArray.value = emptyList()

    }
    // Expose the todoList as LiveData to the UI
    fun getTodoList(): LiveData<List<CheckList>> = todoArray

    fun observeTodoList() {
        todoListCollection.addSnapshotListener { querySnapshot, exception ->
            if (exception != null) {
                // Handle any errors that occurred
                return@addSnapshotListener
            }

            val newList = mutableListOf<CheckList>()
            querySnapshot?.let {
                for (document in it.documents) {
                    val title = document.data?.values.toString().removeSurrounding("[", "]")
                    val todo = CheckList("${document.id}","$title")
                    newList.add(todo)
                }
            }
            todoArray.value = newList
        }
    }





}