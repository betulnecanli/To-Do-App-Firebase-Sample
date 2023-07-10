package com.betulnecanli.todoappfirebasesample.scenes.signup

import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.betulnecanli.todoappfirebasesample.scenes.main.HomeActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class SignUpEmailViewModel: ViewModel() {

    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    fun signUpUserWithEmailAndPassword(email: String, password: String, confirmPassword: String, context: Context) {
        if (password != confirmPassword) {
            // Password and confirm password do not match
            // You can display an error message or handle it as desired
            Toast.makeText(context, "Passwords not same", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Sign-up success, user is now registered
                    val user: FirebaseUser? = auth.currentUser
                    // Navigate to HomeActivity on successful sign-up
                    val intent = Intent(context, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                       } else {
                    // Sign-up failed, display a message to the user
                    val errorMessage = task.exception?.message
                    Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()

                }
            }
    }


}