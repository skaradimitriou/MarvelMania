package com.stathis.marvelmania.features.intro

import android.content.Intent
import android.os.Handler
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import com.stathis.marvelmania.features.dashboard.DashboardActivity
import com.stathis.marvelmania.features.login.LoginActivity

class SplashActivity : MarvelActivity(R.layout.activity_splash) {

    override fun initLayout() {}

    override fun startOperations() {
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }, 1000)
    }

    override fun stopOperations() {}
}