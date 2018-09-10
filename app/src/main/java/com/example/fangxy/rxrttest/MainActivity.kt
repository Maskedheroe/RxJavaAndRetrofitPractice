package com.example.fangxy.rxrttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.fangxy.apis.APIService

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun test(){
        val apiService : APIService = RetrofitManager.retrofit().create(APIService::class.java)

/*        apiService.pm25("苏州")
//                .compose(RxUtils)*/
     }
}
