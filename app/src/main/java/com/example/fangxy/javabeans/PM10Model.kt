package com.example.fangxy.javabeans

data class PM10Model(var cityId:String) {
    var aqi: Int = 0
    var area: String? = null
    var pm10: Int = 0
    var pm10_24h: Int = 0
    var position_name: String? = null
    var primary_pollutant: String? = null
    var quality: String? = null
    var station_code: String? = null
    var time_point: String? = null


}