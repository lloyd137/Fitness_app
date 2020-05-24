package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.example.fitnessapp.providers.StringItemProvider

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val defaultMessage:String = "default confirmation message"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "This is an snackbar!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        startButton.setOnClickListener{
            val message:String = editText.text.toString();
            val intent = Intent(this, MainMenuActivity::class.java).apply {
                putExtra(defaultMessage, message);
            }
            startActivity(intent);
        }

        listButton.setOnClickListener{
            val intent = Intent(this, ListActivity::class.java).apply {
            }

            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
