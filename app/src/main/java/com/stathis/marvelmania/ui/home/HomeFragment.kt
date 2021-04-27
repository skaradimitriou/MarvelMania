package com.stathis.marvelmania.ui.home

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : MarvelFragment(R.layout.fragment_home) {

    private lateinit var viewModel: HomeViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
    }

    override fun startOperations() {
        dummy_text.setOnClickListener {
            goToDetails()
        }

        viewModel.data.observe(this, Observer {
            Log.d("", it.toString())
        })
    }

    override fun stopOperations() {
        viewModel.data.removeObservers(this)
    }

    private fun goToDetails() {
        Navigation.findNavController(requireView()).navigate(R.id.action_details)
    }
}