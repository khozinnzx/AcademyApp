package com.example.academy.ui.academy

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.academy.R
import com.example.academy.databinding.FragmentAcademyBinding
import com.example.academy.utils.DataDummy


class AcademyFragment : Fragment() {

    private lateinit var binding: FragmentAcademyBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAcademyBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[AcademyViewModel::class.java]
            val course = viewModel.getCourse()
            val academyAdapter = AcademyAdapter()
            academyAdapter.setCourse(course)

            binding.rvAcademy.layoutManager = LinearLayoutManager(context)
            binding.rvAcademy.setHasFixedSize(true)
            binding.rvAcademy.adapter = academyAdapter
        }
    }
}