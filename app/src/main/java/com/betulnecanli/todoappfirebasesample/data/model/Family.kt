package com.betulnecanli.todoappfirebasesample.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


data class Family(
    var id: String = "",
    var members: List<User> = arrayListOf(),
    var name: String = "",
    var checklist: String = ""
)