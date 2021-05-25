package com.stathis.marvelmania.features.comics

import androidx.annotation.WorkerThread
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.models.comics.ComicDataContainer
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.API_KEY
import com.stathis.marvelmania.util.FINAL_HASH_KEY
import com.stathis.marvelmania.util.TS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ComicViewModel : ViewModel() {

    val comics = MutableLiveData<ComicDataContainer>()

    fun getComics() {
        CoroutineScope(Dispatchers.IO).launch {
            getCharacterComics()
        }
    }

    @WorkerThread
    suspend fun getCharacterComics() {
        val serviceData = ApiClient.getService().getComics(TS, API_KEY,FINAL_HASH_KEY).body()
        comics.postValue(serviceData?.data)
    }
}