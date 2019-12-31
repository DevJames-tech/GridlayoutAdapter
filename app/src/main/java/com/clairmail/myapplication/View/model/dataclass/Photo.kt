package com.clairmail.myapplication.View.model.dataclass

import android.os.Parcel
import android.os.Parcelable
import android.view.inspector.InspectionCompanion
import com.google.gson.annotations.SerializedName


data class Photo(

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("width")
	val width: Int? = null,

	@field:SerializedName("download_url")
	val downloadUrl: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("url")
	val url: String? = null,

	@field:SerializedName("height")
	val height: Int? = null
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(author)
        parcel.writeValue(width)
        parcel.writeString(downloadUrl)
        parcel.writeString(id)
        parcel.writeString(url)
        parcel.writeValue(height)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Photo> {
        const val BUNDLE_TAG = "PhotoBundle"
        override fun createFromParcel(parcel: Parcel): Photo {
            return Photo(parcel)
        }

        override fun newArray(size: Int): Array<Photo?> {
            return arrayOfNulls(size)
        }
    }
}