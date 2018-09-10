package com.example.fangxy.apis

import com.example.fangxy.javabeans.PM10Model
import com.example.fangxy.javabeans.PM25Model
import com.example.fangxy.javabeans.SO2Model
import retrofit2.http.GET
import retrofit2.http.Query
import io.reactivex.Maybe
import java.sql.RowId

interface APIService {

    val API_BASE_SERVER_URL : String
        get() = "http://www.pm25.in/"

    @GET("api/querys/pm2_5.json")
    fun pm25(@Query("City") cityId: String,@Query("token") token:String):Maybe<List<PM25Model>>

    @GET("api/querys/pm10.json")
    fun pm10(@Query("city") cityId: String,@Query("token") token: String):Maybe<List<PM10Model>>

    @GET("api/querys/so2.json")
    fun so2(@Query("city") cityId: String,@Query("token")token: String):Maybe<List<SO2Model>>

}