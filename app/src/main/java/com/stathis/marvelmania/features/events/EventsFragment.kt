package com.stathis.marvelmania.features.events

import android.view.View
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.stathis.marvelmania.R
import com.stathis.marvelmania.abstraction.MarvelFragment
import kotlinx.android.synthetic.main.custom_marvel_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*

class EventsFragment : MarvelFragment(R.layout.fragment_events) {

    override fun initLayout(view: View) {

    }

    override fun startOperations() {
        marvel_toolbar.apply {
            home_menu_icon.setOnClickListener {
                //toggle menu
                val drawer = activity?.findViewById(R.id.drawer_layout) as DrawerLayout
                drawer.openDrawer(GravityCompat.START)
            }

            home_search_icon.visibility = View.GONE
        }
    }

    override fun stopOperations() {

    }
}