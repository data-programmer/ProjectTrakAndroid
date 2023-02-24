package com.kingsland.projecttrakandroid.util

import java.util.*

object Util {

    private fun getTimeOfDay(): Int {
        val calendar = Calendar.getInstance()
        return calendar.get(Calendar.HOUR_OF_DAY)
    }

    fun getGreetingMessage(): String {
        return when (getTimeOfDay()) {
            in 0..11 -> { "Good morning" }
            in 12..15 -> { "Good afternoon" }
            in 16..20 -> { "Good evening" }
            in 21..23 -> { "Good night" }
            else -> "Good day"
        }
    }
}
