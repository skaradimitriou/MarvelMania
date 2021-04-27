package com.stathis.marvelmania.ui.details

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment

class DetailsFragment : MarvelFragment(R.layout.fragment_details) {

    private lateinit var viewModel: DetailsViewModel

    override fun initLayout(view: View) {
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
    }

    override fun startOperations() {
        //
    }

    override fun stopOperations() {
        //
    }
}