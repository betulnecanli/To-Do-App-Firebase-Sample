package com.betulnecanli.todoappfirebasesample.scenes.signup


import android.app.Application
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.betulnecanli.todoappfirebasesample.scenes.main.HomeActivity
import com.google.firebase.auth.*


class SignUpViewModel(application: Application) : AndroidViewModel(application) {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()



    fun loginWithEmailAndPassword(email: String, password: String, context : Context) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Login success, user is now logged in
                    val user: FirebaseUser? = auth.currentUser
                    val intent = Intent(context, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                    } else {
                    // Login failed, display a message to the user
                    val errorMessage = task.exception?.message
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                }
            }
    }











}
