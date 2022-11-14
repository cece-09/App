package com.example.sample

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteDatabase.openOrCreateDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.multidex.MultiDexApplication
import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase

class Application : MultiDexApplication() {
    companion object {
        lateinit var auth: FirebaseAuth
        var email: String? = null
        lateinit var db: FirebaseFirestore
        fun checkAuth(): Boolean {
            var currentUser = auth.currentUser
            return currentUser?.let {
                email = currentUser.email
                currentUser.isEmailVerified
            } ?: let {
                false
            }
        }
    }
    override fun onCreate() {
        super.onCreate()
        auth = Firebase.auth
        val localDB = openOrCreateDatabase("Chatlog", Context.MODE_PRIVATE, null)
        localDB.execSQL("create table CHAT_LOG(" +
                        "uid char(10) primary key," +
                        "time char(12)," +
                        "text Text)")
        localDB.execSQL("insert into CHAT_LOG (uid, time, text) values (?, ?)", arrayOf<String>("001", "2022-11-14", "hi"))
        localDB.execSQL("insert into CHAT_LOG (uid, time, text) values (?, ?)", arrayOf<String>("002", "2022-11-14", "hello"))
        val cursor =  localDB.rawQuery("select * from CHAT_LOG", null)
        while(cursor.moveToNext()) {
            Log.d("CHAT_LOG", cursor.getString(0))
            Log.d("CHAT_LOG", cursor.getString(1))
            Log.d("CHAT_LOG", cursor.getString(2))
        }
    }
}