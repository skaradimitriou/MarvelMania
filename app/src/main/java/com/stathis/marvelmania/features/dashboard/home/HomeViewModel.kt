package com.stathis.marvelmania.features.dashboard.home

import android.util.Log
import android.view.View
import androidx.annotation.WorkerThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.adapters.MainScreenAdapter
import com.stathis.marvelmania.callbacks.HomeClickListener
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.ShimmerObject
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.characters.ResponseModel
import com.stathis.marvelmania.models.comics.Comic
import com.stathis.marvelmania.models.comics.ComicDataContainer
import com.stathis.marvelmania.models.events.Event
import com.stathis.marvelmania.models.events.EventDataContainer
import com.stathis.marvelmania.models.stories.StoryDataContainer
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel() : ViewModel(), ItemClickListener {

    val heroes = MutableLiveData<ResponseModel?>()
    val comics = MutableLiveData<ComicDataContainer?>()
    val events = MutableLiveData<EventDataContainer?>()
    val adapter = MainScreenAdapter(this)
    val heroAdapter = MainScreenAdapter(this)
    val eventsAdapter = MainScreenAdapter(this)
    private lateinit var callback: HomeClickListener

    init {
        adapter.submitList(
            listOf(
                ShimmerObject(),
                ShimmerObject(),
                ShimmerObject(),
                ShimmerObject()
            )
        )
    }

    fun getResultsFromApi() {
        CoroutineScope(Dispatchers.IO).launch {
            getMarvelCharacters()
            getMarvelComics()
            getMarvelEvents()
        }
    }

    @WorkerThread
    suspend fun getMarvelEvents() {
        val data = ApiClient.getService().getEvents(TS, API_KEY, FINAL_HASH_KEY).body()
        events.postValue(data?.data)
    }

    @WorkerThread
    suspend fun getMarvelCharacters() {
        val data = ApiClient.getService().getCharacters(TS, API_KEY, FINAL_HASH_KEY).body()
        heroes.postValue(data?.data)
    }

    @WorkerThread
    suspend fun getMarvelComics() {
        val serviceData = ApiClient.getService().getComics(TS, API_KEY, FINAL_HASH_KEY).body()
        comics.postValue(serviceData?.data)
    }

    fun observeData(owner: LifecycleOwner, callback: HomeClickListener) {
        this.callback = callback
        comics.observe(owner, Observer {
            Log.d(TAG, it.toString())
            adapter.submitList(it?.results)
            adapter.notifyDataSetChanged()
        })

        heroes.observe(owner, Observer {
            Log.d(TAG, it.toString())
            heroAdapter.submitList(it?.results)
        })

        events.observe(owner, Observer {
            Log.d(TAG, it.toString())
            eventsAdapter.submitList(it?.results)
        })
    }

    override fun onItemClick(view: View) {
        when (view.tag) {
            is Comic -> callback.onComicClick(view.tag as Comic)
            is MarvelCharacter -> callback.onHeroClick(view.tag as MarvelCharacter)
            is Event -> callback.onEventClick(view.tag as Event)
        }
    }
}
