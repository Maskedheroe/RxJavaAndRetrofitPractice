package com.example.fangxy.javabeans

data class PM25Model(var cityId:String) {

    var aqi: Int = 0
    var area: String? = null
    var pm2_5: Int = 0
    var pm2_5_24h: Int = 0
    var position_name: String? = null
    var primary_pollutant: String? = null
    var quality: String? = null
    var station_code: String? = null
    var time_point: String? = null

}