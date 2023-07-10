package com.betulnecanli.todoappfirebasesample.scenes.main.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.viewModels
import com.betulnecanli.todoappfirebasesample.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.firebase.firestore.FirebaseFirestore

class NewTaskBottomSheet : BottomSheetDialogFragment() {
    private lateinit var addButton: Button
    private lateinit var closeButton: Button
    private lateinit var editText: EditText
    private val firestore: FirebaseFirestore = FirebaseFirestore.getInstance()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.bottom_sheet_new_task, container, false)


        addButton = view.findViewById(R.id.save_task_button)
        closeButton = view.findViewById(R.id.exit_bt)
        editText = view.findViewById(R.id.new_task_et)

        addButton.setOnClickListener {
            val todoText = editText.text.toString().trim()
            if (todoText.isNotEmpty()) {
                // Call the addTodoItem function in your view model or repository
                addTitleToFirestore(todoText)
                dismiss() // Close the bottom sheet after adding the todo item
            }
        }

        closeButton.setOnClickListener {
            dismiss() // Close the bottom sheet when the close button is clicked
        }


        return view
    }



    fun addTitleToFirestore(title: String) {
        val firestore = FirebaseFirestore.getInstance()

        val todoListCollection = firestore.collection("todoList")

        val todoItem = hashMapOf(
            "title" to title
        )

        todoListCollection.add(todoItem)
            .addOnSuccessListener { documentReference ->
                Log.d("TAG", "To-do item added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("TAG", "Error adding to-do item", e)
            }

    }

    }
