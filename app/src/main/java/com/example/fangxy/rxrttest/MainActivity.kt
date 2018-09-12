package com.example.fangxy.rxrttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import io.reactivex.functions.BiFunction
import io.reactivex.functions.Consumer
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicInteger

private val s = "Mian"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zipTest()
    }

    private fun zipTest() {
        var observable: Observable<Int> = Observable.create(object :ObservableOnSubscribe<Int>{

            override fun subscribe(emitter: ObservableEmitter<Int>?) {
                 Log.d(s, "emit 1")
                emitter!!.onNext(1)
                Log.d(s, "emit 2")
                emitter.onNext(2)
                Log.d(s, "emit 3")
                emitter.onNext(3)
                Log.d(s, "emit 4")
                emitter.onNext(4)
                Log.d(s, "emit complete1")
                emitter.onComplete()


            }
        }).subscribeOn(Schedulers.io())


        var observable2: Observable<String> = Observable.create(object :ObservableOnSubscribe<String>{

            override fun subscribe(emitter: ObservableEmitter<String>?) {
                Log.d(s, "emit A");
                emitter!!.onNext("A");
                Log.d(s, "emit B");
                emitter.onNext("B");
                Log.d(s, "emit C");
                emitter.onNext("C");
                Log.d(s, "emit complete2");
                emitter.onComplete()

            }


        }).subscribeOn(Schedulers.io())

        Observable.zip(observable, observable2, object : BiFunction<Int, String, String> {
            override fun apply(integer: Int?, s: String): String {
                return integer!!.toString() + s
            }
        }).subscribe(object : Observer<String> {  //此处是一个匿名对象！
            @Throws(Exception::class)//注意与java的注解写法不同！
            override fun onSubscribe(d: Disposable) {
                Log.d(s, "onSubscribe")
            }

            override fun onNext(value: String) {
                Log.d(s, "onNext: $value")
            }

            override fun onError(e: Throwable) {
                Log.d(s, "onError")
            }

            override fun onComplete() {
                Log.d(s, "onComplete")
            }
        })


    }


}


