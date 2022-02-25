package com.damla.intershipproject2.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.damla.intershipproject2.R

class SplashScreenFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Handler().postDelayed({
            findNavController().navigate(R.id.action_splashScreenFragment_to_mainFragment)
        },3000)
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }


}