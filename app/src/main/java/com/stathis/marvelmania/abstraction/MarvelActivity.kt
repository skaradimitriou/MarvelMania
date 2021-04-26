package com.stathis.marvelmania.abstraction

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class MarvelActivity(contentLayoutId : Int) : AppCompatActivity(contentLayoutId) {

    abstract fun initLayout()
    abstract fun startOperations()
    abstract fun stopOperations()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        initLayout()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPostResume() {
        super.onPostResume()
        startOperations()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        stopOperations()
        super.onStop()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}