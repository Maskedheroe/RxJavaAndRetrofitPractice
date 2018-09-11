package com.example.fangxy.rxrttest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.ObservableOnSubscribe
import io.reactivex.functions.BiFunction
import io.reactivex.internal.operators.flowable.FlowableBlockingSubscribe.subscribe
import java.util.concurrent.atomic.AtomicInteger

private val s ="Mian"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        zipTest()
        var button:Button = Button(this)

    }

    private fun zipTest() {
        var observable : Observable<Int> = Observable.create(ObservableOnSubscribe {
            @Override
            fun subscribe(emitter: ObservableEmitter<Int>) {

                Log.d(s, "emit 1")
                emitter.onNext(1)
                Log.d(s, "emit 2")
                emitter.onNext(2)
                Log.d(s, "emit 3")
                emitter.onNext(3)
                Log.d(s, "emit 4")
                emitter.onNext(4)
                Log.d(s, "emit complete1")
                emitter.onComplete()
            }
        })



        var observable2 : Observable<String> = Observable.create(ObservableOnSubscribe {
            @Override
            fun subscibe(emitter: ObservableEmitter<String>){
                Log.d(s, "emit A");
                emitter.onNext("A");
                Log.d(s, "emit B");
                emitter.onNext("B");
                Log.d(s, "emit C");
                emitter.onNext("C");
                Log.d(s, "emit complete2");
                emitter.onComplete();


            }
        })

        Observable.zip(observable,observable2, BiFunction<Int,String,String>(){ i: Int, s: String ->
            return@BiFunction i.toString()+s
        }).subscribe(Observable<String>){

        }

    }




}
