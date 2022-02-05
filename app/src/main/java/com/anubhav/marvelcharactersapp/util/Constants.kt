package com.anubhav.marvelcharactersapp.util

import android.os.Message
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()
        const val API_KEY = "6b78ff50bac9f1adfa914ec3fbdfadcf"
        const val PRIVATE_KEY = "cfd3f2c67dad1743b0bb05a372fe40020b26bc0e"
        fun hash():String{
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16).padStart(32,'0')
        }
    }
}