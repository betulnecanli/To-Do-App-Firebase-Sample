package com.betulnecanli.todoappfirebasesample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.betulnecanli.todoappfirebasesample.databinding.ActivityMainBinding
import com.betulnecanli.todoappfirebasesample.scenes.main.HomeActivity
import com.betulnecanli.todoappfirebasesample.scenes.main.home.HomeFragment
import com.betulnecanli.todoappfirebasesample.scenes.main.personal.PersonalFragment
import com.betulnecanli.todoappfirebasesample.scenes.signup.SignUpFragment
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.messaging.FirebaseMessaging

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController : NavController
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize Firebase. This is necessary to set up Firebase services in your application.
        FirebaseApp.initializeApp(this)


        //notification
        // Get the Firebase Messaging instance and retrieve the FCM registration token
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                Log.w("Token for Firebase", "Fetching FCM registration token failed", task.exception)
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            Log.d("Token for Firebase", token)
            Toast.makeText(this,token,Toast.LENGTH_LONG).show()
             })

     /*   try {
            val result = 10 / 0
        } catch (e: Exception) {
            throw RuntimeException("An error occurred: ${e.message}")
        }
*/

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2)
                    as NavHostFragment
        navController = navHostFragment.findNavController()

        auth = FirebaseAuth.getInstance()
        if (auth.currentUser != null) {
            // User is logged in, proceed to home screen
            startHomeActivity()
        }



    }

    private fun startHomeActivity() {
        // Start the home activity
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish() // Finish the current activity to prevent going back to it when logged in
    }
}