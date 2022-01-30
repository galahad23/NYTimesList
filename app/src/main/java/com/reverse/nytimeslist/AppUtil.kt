package com.reverse.nytimeslist

import java.text.SimpleDateFormat
import java.util.*

class AppUtil {

    companion object {

        fun convertISODate(iso: String): String {
            val formatter = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US)
            val format = SimpleDateFormat("dd MMM yyyy | h:mm a", Locale.US)
            val date: Date = formatter.parse(iso.replace("Z", "+00:00"))
            return format.format(date)
        }
    }
}