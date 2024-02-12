package com.example.activity_state_changes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {


    private var initialValue = 0
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("OnCreate","App started in OnCreate")

        var counterValue : TextView = findViewById(R.id.tvCounterValue)
        val increase : Button = findViewById(R.id.increaseBtn)
        val decrease : Button = findViewById(R.id.decreaseBtn)

        savedInstanceState?.let { counterValue.text = initialValue.toString() }


        increase.setOnClickListener {
            incrementValue(counterValue)
        }
        decrease.setOnClickListener {

            decreaseValue(counterValue)
        }



    }

    private fun decreaseValue(counterValue: TextView) {

        initialValue -= 1
        counterValue.text = initialValue.toString()
    }


    private fun incrementValue(counterValue: TextView) {
        initialValue += 1
        counterValue.text = initialValue.toString()
    }


    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putInt("CounterValue",initialValue)
        Log.i("OnSaveInstance","Data saved when state changed")

    }

    override fun onStop() {
        super.onStop()
        Log.i("OnStop","App stopped in onStop")
    }

}