package com.eneselcuk.bookprojectexample.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<VB:ViewBinding>:Fragment() {

    private var _binding:VB? = null
    val binding get() = _binding!!

    abstract fun getViewBinding():VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = getViewBinding()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRcView()
        setObserver()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

    open fun setObserver(){}
    open fun setRcView(){}



}