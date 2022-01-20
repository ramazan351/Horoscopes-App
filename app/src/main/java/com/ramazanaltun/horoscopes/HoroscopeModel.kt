package com.ramazanaltun.horoscopes

import java.io.Serializable

data class HoroscobeModel(var name: String, var date: String, var icon: Int,var desciption:String, var largeIcon:Int):Serializable {}