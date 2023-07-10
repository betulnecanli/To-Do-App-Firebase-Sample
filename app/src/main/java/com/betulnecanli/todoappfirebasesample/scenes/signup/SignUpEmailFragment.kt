package com.betulnecanli.todoappfirebasesample.scenes.signup

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.databinding.FragmentSignUpBinding
import com.betulnecanli.todoappfirebasesample.databinding.FragmentSignUpEmailBinding

class SignUpEmailFragment : Fragment(R.layout.fragment_sign_up) {


    lateinit var binding : FragmentSignUpEmailBinding
    private val viewModel : SignUpEmailViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignUpEmailBinding.bind(view)


        binding.signUpButton.setOnClickListener {
            binding.apply {
                val email = mailLoginEt.text.toString()
                val password = passwordEt.text.toString()
                val confirmPassword = passwordConfirmEt.text.toString()
                context?.let { it1 ->
                    viewModel.signUpUserWithEmailAndPassword(email, password, confirmPassword,
                        it1
                    )
                }
            }




        }
    }


}