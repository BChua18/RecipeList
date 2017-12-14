package com.example.chua.recipelist

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by Chua on 12/15/2017.
 */
data class Recipe(
        val recipePic: Int = 0,
        val recipeName: String = "",
        val recipeDescription: String = "",
        val ingredients: String = "",
        val procedure: String = "") : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(recipePic)
        parcel.writeString(recipeName)
        parcel.writeString(recipeDescription)
        parcel.writeString(ingredients)
        parcel.writeString(procedure)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}