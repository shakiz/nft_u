package com.digital.nftu.presentation.views

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.digital.nftu.R
import com.digital.nftu.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomNavigationView.background = null
        binding.bottomNavigationView.menu.getItem(2).isEnabled = false
    }

    fun setBottomNavigationBarVisibility(visible: Boolean) {
        if (visible) {
            findViewById<BottomAppBar>(R.id.bottomAppBar).visibility = View.VISIBLE
            findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.VISIBLE
            findViewById<FloatingActionButton>(R.id.fab).visibility = View.VISIBLE
        } else {
            findViewById<BottomAppBar>(R.id.bottomAppBar).visibility = View.GONE
            findViewById<BottomNavigationView>(R.id.bottomNavigationView).visibility = View.GONE
            findViewById<FloatingActionButton>(R.id.fab).visibility = View.GONE
        }
    }
}