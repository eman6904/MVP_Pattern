package com.example.architecturepatterns.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.architecturepatterns.R
import com.example.architecturepatterns.databinding.FragmentCalculateBinding
import com.example.architecturepatterns.model.Data
import com.example.architecturepatterns.presenter.IntermediateClass


class Calculate : Fragment(R.layout.fragment_calculate), IntermediateClass.View {
    private lateinit var binding: FragmentCalculateBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentCalculateBinding.bind(view)
        navController = Navigation.findNavController(view)
        //to hide action bar
        val activity = activity as MainActivity
        activity.supportActionBar?.hide()
        binding.calculate.setOnClickListener()
        {
            val first = binding.E1.text.toString().toInt()
            val second = binding.E2.text.toString().toInt()
            val intermediateClass = IntermediateClass(this)
            intermediateClass.calculate(first, second)
        }
    }
    override fun getInfo(data: Data) {
        binding.sum.text = data.sum.toString()
        binding.sub.text = data.sub.toString()
    }
}