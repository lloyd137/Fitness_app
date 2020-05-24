package com.example.fitnessapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ListView
import com.example.fitnessapp.adapters.ItemAdapter
import com.example.fitnessapp.models.StringItem
import com.example.fitnessapp.providers.StringItemProvider
import kotlinx.android.synthetic.main.activity_list.*
import java.util.*

class ListActivity : AppCompatActivity(), Observer {

    private val provider: StringItemProvider = StringItemProvider()
    private var items = provider.getItems()
    var listView: ListView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list);

        listView = findViewById<ListView>(R.id.textList)

        provider.add(StringItem(1, "one"));
        provider.add(StringItem(2, "two"));
        provider.add(StringItem(3, "three"));
        provider.add(StringItem(4, "four"));

        val adapter = ItemAdapter(this, items)
        listView?.adapter = adapter

        addButton.setOnClickListener { _ ->
            val intent = Intent(this, AddStringItemActivity::class.java).apply {
                putExtra("provider", provider)
            }
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()
        listView?.invalidate()
    }

    override fun update(o: Observable?, arg: Any?) {
        items = provider.getItems()
    }
}
