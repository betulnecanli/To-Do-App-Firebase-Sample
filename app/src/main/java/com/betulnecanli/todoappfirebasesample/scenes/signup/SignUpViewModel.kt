package com.betulnecanli.todoappfirebasesample.scenes.signup

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.lifecycle.ViewModel
import com.betulnecanli.todoappfirebasesample.scenes.main.HomeActivity
import com.google.firebase.auth.*



class SignUpViewModel: ViewModel() {

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


    fun signInWithTwitter(activity: Activity, provider: OAuthProvider.Builder, context : Context) {

        auth.startActivityForSignInWithProvider(activity, provider.build())
            .addOnSuccessListener { authResult ->
                val twitterCredential = authResult.credential
                if (twitterCredential != null && twitterCredential.signInMethod == TwitterAuthProvider.PROVIDER_ID) {
                    // User is signed in with Twitter.
                    val twitterSession = authResult.additionalUserInfo?.profile?.get("session")

                    // Use the token and secret as needed.
                    // Navigate to HomeActivity on successful sign-up
                    val intent = Intent(context, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    context.startActivity(intent)
                }
            }
            .addOnFailureListener { exception ->
                // Handle failure.
                Toast.makeText(context, exception.message.toString(), Toast.LENGTH_SHORT).show()
            }





    }

    fun signInWithGoogle(credential: AuthCredential) {

    }

}
