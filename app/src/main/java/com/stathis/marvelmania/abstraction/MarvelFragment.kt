package com.stathis.marvelmania.abstraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class MarvelFragment(contentLayoutId: Int) : Fragment(contentLayoutId) {

    abstract fun initLayout(view: View)
    abstract fun startOperations()
    abstract fun stopOperations()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initLayout(view)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
        startOperations()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        stopOperations()
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}