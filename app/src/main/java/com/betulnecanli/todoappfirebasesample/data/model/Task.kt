package com.betulnecanli.todoappfirebasesample.data.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*


data class Task(
    val addedDate: Date? = null,
    val checkedDate: Date? = null,
    val check: Boolean = false,
    val title: String = ""
)