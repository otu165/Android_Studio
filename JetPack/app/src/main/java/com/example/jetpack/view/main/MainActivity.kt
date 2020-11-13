package com.example.jetpack.view.main

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.room.Room
import com.example.jetpack.R
import com.example.jetpack.data.room.UserDatabase
import com.example.jetpack.databinding.ActivityMainBinding
import com.example.jetpack.models.user.User
import com.example.jetpack.view.fragment.SecondFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var navController: NavController
    private lateinit var m : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = mainViewModel

        mainViewModel.rvLiveData.observe(this, Observer {
            Log.d(TAG, "recycler view data updated")
        })

        // Navigation
        navHostFragment = supportFragmentManager.findFragmentById(R.id.frag_main) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)

        // action bar with Navigation
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.toolbar_main_menu, menu)

        m = menu?.findItem(R.id.secondFragment)!!

        return super.onCreateOptionsMenu(menu)
    }

    @Override
    @SuppressLint("RestrictedApi")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(navController.currentDestination?.label == "secondFragment") {
            m.isVisible = true
        }

        if(item.itemId == R.id.secondFragment) {
            item.isVisible = false
        }

        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    @Override
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @Override
    override fun onBackPressed() {
        if(!m.isVisible)
            m.isVisible = true

        super.onBackPressed()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}