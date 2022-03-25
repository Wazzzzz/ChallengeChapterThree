package com.example.challengechapterthree.fragment

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPerson(
    val name: String? = null,
    val age: Int? = null,
    val address: String? = null,
    val job: String? = null
): Parcelable
