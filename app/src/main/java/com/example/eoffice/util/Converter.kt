package com.example.eoffice.util

import java.text.SimpleDateFormat
import java.util.*

class Converter {
    companion object{
        fun getDate(date: Date): String{
            val sdf = SimpleDateFormat("yyyy-m-dd")
            return sdf.format(date)
        }
    }
}