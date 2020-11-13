package com.example.naviprac.view.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.naviprac.R

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navController: NavController
    private lateinit var moveOption : MenuItem

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // navigation
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
        supportActionBar?.title = "Navigation Practice"
    }

    @Override
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.actionbar_main_menu, menu)
        menu?.findItem(R.id.secondFragment).let {
            moveOption = it!!
        }

        return super.onCreateOptionsMenu(menu)
    }

    @Override
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMoveOptionVisible()

        if(item.itemId == R.id.secondFragment) {
            item.isVisible = false
        }

        return  item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    @Override
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    @Override
    override fun onBackPressed() {
        setMoveOptionVisible()

        super.onBackPressed()
    }

    private fun setMoveOptionVisible() {
        if(!moveOption.isVisible) {
            moveOption.isVisible = true
        }
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}