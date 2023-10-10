package com.ahmadabuhasan.dicoding.model

import android.os.Parcelable

import kotlinx.parcelize.Parcelize

@Parcelize
data class Language(
    var name: String = "",
    var detail: String = "",
    var skill: String = "",
    var link: String = "",
    var image: Int = 0
) : Parcelable
