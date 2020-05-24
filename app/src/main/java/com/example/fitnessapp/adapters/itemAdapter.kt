package com.example.fitnessapp.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.fitnessapp.R
import com.example.fitnessapp.models.StringItem

class ItemAdapter(private val context: Context, private val dataSource: ArrayList<StringItem>) :
    BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // Get view for row item
        val item = inflater.inflate(R.layout.string_list_item, parent, false)

        val textNumber = item.findViewById(R.id.number) as TextView
        val textContent = item.findViewById(R.id.inputText) as TextView

        val stringItem = getItem(position) as StringItem

        textNumber.text = stringItem.itemNumber.toString()
        textContent.text = stringItem.text;

        return item
    }

    override fun getItem(position: Int): Any {
        return dataSource[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

}

