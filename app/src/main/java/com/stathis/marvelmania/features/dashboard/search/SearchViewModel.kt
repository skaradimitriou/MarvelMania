package com.stathis.marvelmania.features.dashboard.search

import android.view.View
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stathis.marvelmania.adapters.SearchAdapter
import com.stathis.marvelmania.callbacks.CharacterClickListener
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.characters.MarvelCharacter
import com.stathis.marvelmania.models.characters.ResponseModel
import com.stathis.marvelmania.network.ApiClient
import com.stathis.marvelmania.util.API_KEY
import com.stathis.marvelmania.util.FINAL_HASH_KEY
import com.stathis.marvelmania.util.TS
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel(),ItemClickListener {

    val adapter = SearchAdapter(this)
    val data = MutableLiveData<ResponseModel>()
    private lateinit var callback : CharacterClickListener

    fun getResultsForCharacter(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            getCharacterResults(query)
        }
    }

    suspend fun getCharacterResults(characterName: String) {
        val serviceData =
            ApiClient.getService().getCharacterByName(characterName, TS, API_KEY, FINAL_HASH_KEY)
                .body()
        data.postValue(serviceData?.data)
    }

    fun observeData(owner: LifecycleOwner, callback : CharacterClickListener) {
        this.callback = callback
        data.observe(owner, Observer {
            it?.let { adapter.submitList(it.results) }
        })
    }

    override fun onItemClick(view: View) {
        when(view.tag){
            is MarvelCharacter -> callback.onCharacterClick(view.tag as MarvelCharacter)
        }
    }
}
