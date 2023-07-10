package com.betulnecanli.todoappfirebasesample.scenes.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.databinding.ActivityHomeBinding
import com.betulnecanli.todoappfirebasesample.scenes.main.home.HomeFragment
import com.betulnecanli.todoappfirebasesample.scenes.main.personal.PersonalFragment
import com.betulnecanli.todoappfirebasesample.scenes.signup.SignUpFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView3)
                    as NavHostFragment
        navController = navHostFragment.findNavController()
        // Find reference to bottom navigation view

        // Hook your navigation controller to bottom navigation view
        binding.bottomNavigationView.setupWithNavController(navController)


    }



}