package com.example.exampart2

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.exampart2.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {

    private var binding: FragmentSecondBinding? = null

    private var name: String? = null
    private var age: Int? = null
    private var money: Double? = null
    private var isStudent: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        name = arguments?.getString("name")
        age = arguments?.getInt("age")
        money = arguments?.getDouble("money")
        isStudent = arguments?.getBoolean("isStudent")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSecondBinding.inflate(layoutInflater, container,false)
        return binding?.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.buttonBack?.setOnClickListener{
           backInfo()
        }
        binding?.textSecond?.text = "$name $age $money $isStudent"

    }

    private fun backInfo(){
        val bundle = bundleOf(
            "surname" to "Veliev",
            "age" to 24,
            "money" to 80.0,
            "isStudent" to true
        )
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FirstFragment::class.java, bundle)
            .commit()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }


}