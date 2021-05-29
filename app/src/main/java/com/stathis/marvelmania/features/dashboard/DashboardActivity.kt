package com.stathis.marvelmania.features.dashboard

import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.iammert.library.readablebottombar.ReadableBottomBar
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import kotlinx.android.synthetic.main.activity_dashboard.*

class DashboardActivity : MarvelActivity(R.layout.activity_dashboard) {

    private lateinit var navController: NavController

    override fun initLayout() {
        navController = findNavController(R.id.nav_host_fragment)
    }

    override fun startOperations() {
        custom_bottom_nav.setOnItemSelectListener(object : ReadableBottomBar.ItemSelectListener {
            override fun onItemSelected(index: Int) {
                when (index) {
                    0 -> navController.navigate(R.id.nav_home)
                    1 -> navController.navigate(R.id.nav_search)
                    2 -> navController.navigate(R.id.nav_profile)
                }
            }
        })
    }

    override fun stopOperations() {}
}