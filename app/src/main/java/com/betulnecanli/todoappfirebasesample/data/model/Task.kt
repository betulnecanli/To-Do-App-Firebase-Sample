package com.betulnecanli.todoappfirebasesample.data.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Task(
    val addedBy: String = "",
    val addedDate: Date? = null,
    val checkedBy: String = "",
    val checkedDate: Date? = null,
    val isChecked: Boolean = false,
    val title: String = ""
) : Parcelable