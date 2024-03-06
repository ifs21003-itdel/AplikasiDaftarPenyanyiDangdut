package com.example.aplikasidaftarpenyanyidangdut

import android.os.Parcel
import android.os.Parcelable

data class Penyanyi(
    val name: String?,
    val description: String?,
    val description_preview: String?,
    val photo: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeString(description_preview)
        parcel.writeInt(photo)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Penyanyi> {
        override fun createFromParcel(parcel: Parcel): Penyanyi {
            return Penyanyi(parcel)
        }

        override fun newArray(size: Int): Array<Penyanyi?> {
            return arrayOfNulls(size)
        }
    }
}

