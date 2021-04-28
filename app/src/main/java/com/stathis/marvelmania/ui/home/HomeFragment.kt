package com.stathis.marvelmania.ui.home

import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import com.stathis.marvelmania.adapters.MainScreenAdapter
import com.stathis.marvelmania.callbacks.ItemClickListener
import com.stathis.marvelmania.models.MainResponseModel
import com.stathis.marvelmania.models.MarvelCharacter
import com.stathis.marvelmania.models.ResponseModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MarvelFragment(R.layout.fragment_home), ItemClickListener {

    private lateinit var viewModel: HomeViewModel
    val adapter = MainScreenAdapter(this)

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOperations() {
        home_recyclerview.adapter = adapter
        viewModel.getResultsFromApi()

        viewModel.data.observe(this, Observer {
            it?.data?.let { adapter.submitList(it.results) }
        })
    }

    override fun stopOperations() {
        viewModel.data.removeObservers(this)
    }

    private fun goToDetails() {
        Navigation.findNavController(requireView()).navigate(R.id.action_details)
    }

    override fun onItemClick(view: View) {
        when (view.tag) {
            is MarvelCharacter -> {
                Toast.makeText(requireContext(), (view.tag as MarvelCharacter).title, Toast.LENGTH_LONG).show()
            }
        }
    }
}