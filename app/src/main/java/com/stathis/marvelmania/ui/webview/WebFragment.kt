package com.stathis.marvelmania.ui.webview

import android.view.View
import android.webkit.WebSettings
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import kotlinx.android.synthetic.main.fragment_web.*

class WebFragment : MarvelFragment(R.layout.fragment_web) {

    override fun initLayout(view: View) {
        // note:  get url from safeargs
        val url = "https://www.google.com/"
        webView.loadUrl(url)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
    }

    override fun startOperations() {

    }

    override fun stopOperations() {}
}