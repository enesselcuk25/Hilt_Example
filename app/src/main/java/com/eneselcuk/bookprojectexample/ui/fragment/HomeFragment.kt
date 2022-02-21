package com.eneselcuk.bookprojectexample.ui.fragment

import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.eneselcuk.bookprojectexample.adapter.RecyAdapter
import com.eneselcuk.bookprojectexample.base.BaseFragment
import com.eneselcuk.bookprojectexample.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun getViewBinding() = FragmentHomeBinding.inflate(layoutInflater)

    private val viewModelDog: ViewModel by viewModels()
    @Inject lateinit var rcAdapter: RecyAdapter

    override fun setRcView() {
        rcAdapter = RecyAdapter()

        binding.rcView.apply {
            this.adapter = rcAdapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
    }

    override fun setObserver() {

        viewModelDog.dogLiveData.observe(viewLifecycleOwner, {
            rcAdapter.dogList = it.message?.take(30)
        })

        viewModelDog.loading.observe(viewLifecycleOwner,{
            binding.prograsbar.visibility = if(it){View.VISIBLE} else View.GONE
        })
    }
}