package com.betulnecanli.todoappfirebasesample.scenes.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.databinding.FragmentDetailBinding
import com.betulnecanli.todoappfirebasesample.scenes.main.home.HomeAdapter


class DetailFragment : Fragment(R.layout.fragment_detail) {

    lateinit var binding: FragmentDetailBinding
    private val viewModel : DetailViewModel by viewModels()
    private lateinit var adapter: DetailAdapter
    val args: DetailFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDetailBinding.bind(view)

        // Retrieve the argument value
        val argID = args.documentId
        val argTitle = args.title

        binding.itemName.text = argTitle
        viewModel.setDocumentId(argID)
        setupAdapter()
        viewModel.observeTodoList()
        viewModel.getTaskList().observe(viewLifecycleOwner) { todoList ->
            val stringList2 = todoList.distinct()
            adapter.differ.submitList(stringList2)
        }

    }

    fun setupAdapter(){
        binding.apply {
            itemsList.layoutManager = LinearLayoutManager(requireContext())
            adapter = DetailAdapter()
            itemsList.adapter = adapter

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }


}