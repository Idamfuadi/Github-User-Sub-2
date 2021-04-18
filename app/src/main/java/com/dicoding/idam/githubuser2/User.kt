package com.dicoding.idam.githubuser2

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class User(
    var photo: String,
    var name: String,
    var username: String,
    var company: String,
//    var location: String,
//    var repository: String,
//    var followers: String,
//    var following: String
) : Parcelable
