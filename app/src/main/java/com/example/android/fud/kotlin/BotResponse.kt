package com.example.chatbot1.utils

import com.example.chatbot1.utils.Constants.OPEN_GOOGLE
import com.example.chatbot1.utils.Constants.OPEN_SEARCH

import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message = _message.lowercase(Locale.getDefault())

        return when {
            //Hello
            message.contains("hello") || message.contains("hi") -> {
                when (random) {
                    0 -> "Hello there!"
                    1-> "Hi"
                    2-> "Wsup"
                    else -> "error"
                }
            }

            //How are you?
            message.contains("how are you") -> {
                when (random) {
                    0 -> "I'm doing fine, thanks!"
                    1 -> "I'm hungry..."
                    2 -> "Pretty good! How about you?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time")  -> {
               Time.timeStamp()
            }

            //Open Google
            message.contains("open") && message.contains("google") -> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search") -> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "I don't understand..."
                    1 -> "Try asking me something different"
                    2 -> "I dont know"
                    else -> "error"
                }
            }
        }
    }
}