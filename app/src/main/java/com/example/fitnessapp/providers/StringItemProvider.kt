package com.example.fitnessapp.providers

import android.os.Parcel
import android.os.Parcelable
import com.example.fitnessapp.models.StringItem
import kotlin.collections.ArrayList

class StringItemProvider() : Parcelable {

    private val stringItems = ArrayList<StringItem>()

    constructor(parcel: Parcel) : this() {
    }

    fun add(item: StringItem){
        stringItems.add(item)
    }

    fun getItems(): ArrayList<StringItem> {
        return stringItems
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<StringItemProvider> {
        override fun createFromParcel(parcel: Parcel): StringItemProvider {
            return StringItemProvider(parcel)
        }

        override fun newArray(size: Int): Array<StringItemProvider?> {
            return arrayOfNulls(size)
        }
    }
}