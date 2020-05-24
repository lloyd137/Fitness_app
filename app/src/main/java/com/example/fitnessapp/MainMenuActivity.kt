package com.example.fitnessapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main_menu_activity.*

class MainMenuActivity : AppCompatActivity(){

    private val defaultMessage:String = "default confirmation message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_activity)

            intentView.text = intent.getStringExtra(defaultMessage)
    }

}