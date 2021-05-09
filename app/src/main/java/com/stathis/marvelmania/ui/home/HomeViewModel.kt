package com.stathis.marvelmania.ui.home

import android.util.Log
import android.view.View
import androidx.annotation.WorkerThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.adapters.MainScreenAdapter
import com.stathis.marvelmania.callbacks.ComicClickListener
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.characters.ResponseModel
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.models.comics.ComicDataContainer
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.API_KEY
import com.stathis.marvelmania.util.FINAL_HASH_KEY
import com.stathis.marvelmania.util.MarvelHeroGenerator
import com.stathis.marvelmania.util.TS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel(), ItemClickListener {

    val data = MutableLiveData<ResponseModel?>()
    val comics = MutableLiveData<ComicDataContainer?>()
    private val characterId = MarvelHeroGenerator.getRandomHero()
    val adapter = MainScreenAdapter(this)
    private lateinit var callback : ComicClickListener

    fun getResultsFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            callWebService()
            getCharacterComics()
        }
    }

    @WorkerThread
    suspend fun callWebService() {
        val serviceData = ApiClient.getService().getCharacterById(characterId,TS, API_KEY, FINAL_HASH_KEY).body()
        data.postValue(serviceData?.data)
    }

    @WorkerThread
    suspend fun getCharacterComics() {
        val serviceData = ApiClient.getService().getCharacterComics(characterId,TS, API_KEY, FINAL_HASH_KEY).body()
        comics.postValue(serviceData?.data)
    }

    fun observeData(owner : LifecycleOwner,callback : ComicClickListener){
        this.callback = callback
        comics.observe(owner, Observer {
            Log.d("",it.toString())
            adapter.submitList(it?.results)
        })
    }

    override fun onItemClick(view: View) {
        when (view.tag) {
            is Comic -> callback.onComicClick(view.tag as Comic)
        }
    }
}
