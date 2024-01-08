package com.example.exampart2

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import com.example.exampart2.databinding.FragmentFirstBinding
import com.example.exampart2.databinding.FragmentSecondBinding

class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null

    private var surname: String? = null
    private var age: Int? = null
    private var money: Double? = null
    private var isStudent: Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        surname = arguments?.getString("surname")
        age = arguments?.getInt("age")
        money = arguments?.getDouble("money")
        isStudent = arguments?.getBoolean("isStudent")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(layoutInflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.buttonNext?.setOnClickListener{
            next()
        }
        binding?.textFirst?.text = "$surname $age $money $isStudent"
    }


    private fun next(){
        val bundle = bundleOf(
            "age" to 24,
            "name" to "Nurlan",
            "money" to 100.0,
            "isStudent" to false
        )

        val secondFragment = SecondFragment()
        parentFragmentManager.beginTransaction()
            .addToBackStack(FirstFragment::class.java.canonicalName)
            .replace(R.id.fragmentContainer, secondFragment::class.java, bundle)
            .commit()
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }


}




