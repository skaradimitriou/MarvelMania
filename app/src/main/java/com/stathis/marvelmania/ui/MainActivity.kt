package com.stathis.marvelmania.ui

import android.view.MenuItem
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : MarvelActivity(R.layout.activity_main), NavigationView.OnNavigationItemSelectedListener{

    private lateinit var navController : NavController

    override fun initLayout() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        navController = navHostFragment.navController
        findViewById<NavigationView>(R.id.nav_view).setupWithNavController(navController)

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun startOperations() {}

    override fun stopOperations() {}

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_home -> drawer_layout.closeDrawer(GravityCompat.START)
            R.id.nav_search -> {
                navController.navigate(R.id.action_search)
                drawer_layout.closeDrawer(GravityCompat.START)
            }
        }
        return true
    }
}