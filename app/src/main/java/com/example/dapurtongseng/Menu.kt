package com.example.dapurtongseng

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Menu(
    val name: String,
    val description: String,
    val photo: String
) : Parcelable