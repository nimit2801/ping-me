package com.nimit.pingme

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button

class MainActivity : AppCompatActivity() {
    var bClickVibration: Button? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator

        // Register buttons to ui
        val bNormalVibration:Button = findViewById(R.id.normalVibrationButton)
        bClickVibration = findViewById(R.id.clickVibrationButton)

        bNormalVibration.setOnClickListener {
                val vibrationEffect1: VibrationEffect

                // this is the only type of the vibration which requires system version Oreo (API 26)
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                    // this effect creates the vibration of default amplitude for 1000ms(1 sec)
                    vibrationEffect1 =
                        VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE)

                    // it is safe to cancel other vibrations currently taking place
                    vibrator.cancel()
                    vibrator.vibrate(vibrationEffect1)
                }
        }
    }
}
