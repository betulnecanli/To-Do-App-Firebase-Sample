package com.betulnecanli.todoappfirebasesample.scenes.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.betulnecanli.todoappfirebasesample.R
import com.betulnecanli.todoappfirebasesample.data.model.CheckList
import com.betulnecanli.todoappfirebasesample.databinding.FragmentHomeBinding
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment(R.layout.fragment_home), HomeAdapter.OnItemClickListener {


    private val viewModel : HomeViewModel by viewModels()
    private lateinit var adapter: HomeAdapter
    lateinit var binding: FragmentHomeBinding


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeBinding.bind(view)

        binding.addItemFb.setOnClickListener {
            val bottomSheetFragment = NewTaskBottomSheet()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)

        }

        setupAdapter()
        viewModel.observeTodoList()
        viewModel.getTodoList().observe(viewLifecycleOwner) { todoList ->
            val stringList2 = todoList.distinct()
            adapter.differ.submitList(stringList2)
        }
    }



    fun setupAdapter(){
        binding.apply {
            itemRc.layoutManager = LinearLayoutManager(requireContext())
            adapter = HomeAdapter(this@HomeFragment)
            itemRc.adapter = adapter

        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onItemClick(list: CheckList) {
        //navigate using doc ID
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(list.document_id,list.list_name)
        findNavController().navigate(action)

    }


}