package com.stathis.marvelmania.features.details

import androidx.annotation.WorkerThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.adapters.DetailsAdapter
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.characters.ResponseModel
import com.stathis.marvelmania.models.comics.ComicDataContainer
import com.stathis.marvelmania.models.events.EventDataContainer
import com.stathis.marvelmania.models.series.SeriesDataContainer
import com.stathis.marvelmania.models.stories.StoryDataContainer
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.API_KEY
import com.stathis.marvelmania.util.FINAL_HASH_KEY
import com.stathis.marvelmania.util.TS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel() {

    val data = MutableLiveData<ResponseModel?>()
    val comics = MutableLiveData<ComicDataContainer?>()
    val events = MutableLiveData<EventDataContainer?>()
    val series = MutableLiveData<SeriesDataContainer?>()
    val stories = MutableLiveData<StoryDataContainer?>()
    var charactedId = 0

    val adapter = DetailsAdapter()

    init {
        getCharacterData()
    }

    fun bindCharacterData(character: MarvelCharacter) {
        adapter.submitList(listOf(character))
    }

    fun getCharacterData() {
        CoroutineScope(Dispatchers.IO).launch {
            getCharacterStories()
        }
    }

    @WorkerThread
    suspend fun getCharacterStories() {
        val serviceData =
            ApiClient.getService().getCharacterStories(charactedId, TS, API_KEY, FINAL_HASH_KEY)
                .body()
        stories.postValue(serviceData?.data)
    }

    fun removeObservers(owner: LifecycleOwner) {
        comics.removeObservers(owner)
        events.removeObservers(owner)
        series.removeObservers(owner)
        stories.removeObservers(owner)
    }
}
