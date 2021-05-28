package com.stathis.marvelmania.features.dashboard

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity

class DashboardActivity : MarvelActivity(R.layout.activity_dashboard) {

    override fun initLayout() {
        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation_menu)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)
    }

    override fun startOperations() {}

    override fun stopOperations() {}
}