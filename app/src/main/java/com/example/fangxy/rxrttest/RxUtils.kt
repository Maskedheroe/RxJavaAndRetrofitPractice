package com.example.fangxy.rxrttest

import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable
import io.reactivex.ObservableTransformer
import io.reactivex.ObservableSource



class RxUtils {

    /**
     * 对RxView绑定的事件
     * 封装了防止重复点击和RxLifecycle的生命周期
     *//*
    fun useRxViewTransformer(targetActivity: AppCompatActivity): ObservableTransformer<*, *> {

        return object : ObservableTransformer {

            fun apply(upstream: Observable): ObservableSource<*> {
                return upstream.compose(Rx .preventDuplicateClicksTransformer())
                        .compose(RxLifecycle.bind(targetActivity).toLifecycleTransformer())
            }
        }
    }*/
}