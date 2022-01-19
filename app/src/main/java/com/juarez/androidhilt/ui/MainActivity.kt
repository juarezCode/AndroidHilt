package com.juarez.androidhilt.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.juarez.androidhilt.AppNavigator
import com.juarez.androidhilt.MyApplication
import com.juarez.androidhilt.R
import com.juarez.androidhilt.Screens

class MainActivity : AppCompatActivity() {
    private lateinit var navigator: AppNavigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigator = (applicationContext as MyApplication).serviceLocator.provideNavigator(this)

        if (savedInstanceState == null) {
            navigator.navigateTo(Screens.BUTTONS)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.backStackEntryCount == 0) {
            finish()
        }
    }
}