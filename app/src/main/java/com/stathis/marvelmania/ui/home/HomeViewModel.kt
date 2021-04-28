package com.stathis.marvelmania.ui.home

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.models.MainResponseModel
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.API_KEY
import com.stathis.marvelmania.util.FINAL_HASH_KEY
import com.stathis.marvelmania.util.TS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val data = MutableLiveData<MainResponseModel?>()
    val isConnected = MutableLiveData<Boolean>()

    fun getResultsFromApi(){
        CoroutineScope(Dispatchers.IO).launch { callWebService() }
    }

    @WorkerThread
    suspend fun callWebService() {
        val serviceData = ApiClient.getService().getCharacters(TS, API_KEY, FINAL_HASH_KEY).body()
        data.postValue(serviceData)
    }
}
