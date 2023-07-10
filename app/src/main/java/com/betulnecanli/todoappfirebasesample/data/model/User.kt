package com.betulnecanli.todoappfirebasesample.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class User(
    var id: String = "",
    var lists: List<Task> = arrayListOf(),
    var name: String = ""
)