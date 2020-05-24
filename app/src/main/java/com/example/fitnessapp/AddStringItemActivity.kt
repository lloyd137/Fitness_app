package com.example.fitnessapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fitnessapp.models.StringItem
import com.example.fitnessapp.providers.StringItemProvider
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_add_string_item.*
import kotlinx.android.synthetic.main.activity_list.*
import kotlinx.android.synthetic.main.string_list_item.*

class AddStringItemActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_string_item)

        val provider: StringItemProvider = intent.getParcelableExtra("provider") as StringItemProvider

        cancelButton.setOnClickListener {
            finish()
        }

        saveButton.setOnClickListener {view ->
            if (textInput.text.isNotEmpty()) {
                provider.add(StringItem(provider.getItems().size + 1, textInput.text.toString()))
                finish()
            } else {
                Snackbar.make(view, "Write something to save!", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }
    }
}
