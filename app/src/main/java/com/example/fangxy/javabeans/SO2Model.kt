package com.example.fangxy.javabeans

data class SO2Model(var cityId:String) {
    var aqi: Int = 0
    var area: String? = null
    var so2: Int = 0
    var so2_24h: Int = 0
    var position_name: String? = null
    var primary_pollutant: String? = null
    var quality: String? = null
    var station_code: String? = null
    var time_point: String? = null
}