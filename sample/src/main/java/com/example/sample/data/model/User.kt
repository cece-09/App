package com.example.sample.data.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class User(
    var userId: String? = null,
    var nickname: String? = null,
    var email: String? = null,
    var gender: String? = null,
    @ServerTimestamp var timestamp: Date? = null
){
//    constructor( userId: String, nickname: String, email: String, gender: String ) : this() {
//        this.userId = userId
//        this.nickname = nickname
//        this.email = email
//        this.gender = gender
//    }
}
