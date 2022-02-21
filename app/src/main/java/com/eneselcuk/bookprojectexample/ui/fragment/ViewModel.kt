package com.eneselcuk.bookprojectexample.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eneselcuk.bookprojectexample.data.remote.model.AllDogs
import com.eneselcuk.bookprojectexample.repository.DogsRepo
import com.eneselcuk.bookprojectexample.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ViewModel @Inject constructor(private val repo: DogsRepo) : ViewModel() {

    private val dogMutableLiveData: MutableLiveData<AllDogs> = MutableLiveData()
    val dogLiveData: LiveData<AllDogs>
        get() = dogMutableLiveData

    private var error = MutableLiveData("")
    var loading = MutableLiveData(false)

    init {
        getDog()
    }

    private fun getDog() {
        viewModelScope.launch {
            val result = repo.getDog()
            loading.value = true
            when (result) {
                is Resource.Success -> {
                    result.data?.let {
                        dogMutableLiveData.postValue(it)
                    }
                    error.value = ""
                    loading.value = false
                }
                else -> {
                    error.value = result.message
                    loading.value = false
                }
            }
        }
    }
}