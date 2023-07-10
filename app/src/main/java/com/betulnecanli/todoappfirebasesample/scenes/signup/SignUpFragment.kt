package com.betulnecanli.todoappfirebasesample.scenes.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.databinding.FragmentSignUpBinding
import com.google.firebase.auth.OAuthProvider

class SignUpFragment : Fragment(R.layout.fragment_sign_up) {

    private lateinit var binding: FragmentSignUpBinding
    private val viewModel : SignUpViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)

        binding.signUpTwitterButton.setOnClickListener {
            val provider = OAuthProvider.newBuilder("twitter.com")
            context?.let { it1 -> activity?.let { it2 -> viewModel.signInWithTwitter(it2, provider,
                context!!
            ) } }
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpBinding.bind(view)

        binding.apply {

            signUpEmailButton.setOnClickListener {
                navigateToSignUpEmailScreen()
            }

            loginButton.setOnClickListener{
                val email = mailLoginEt.text.toString()
                val password = passwordLoginEt.text.toString()
                context?.let { it1 -> viewModel.loginWithEmailAndPassword(email,password, it1) }
            }

            signUpTwitterButton.setOnClickListener {


            }

            signUpGoogleButton.setOnClickListener {


            }
        }



    }

    fun navigateToSignUpEmailScreen(){
        findNavController().navigate(R.id.action_signUpFragment2_to_signUpEmailFragment2)
    }

}