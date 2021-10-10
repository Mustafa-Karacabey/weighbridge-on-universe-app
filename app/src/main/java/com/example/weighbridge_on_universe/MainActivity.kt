package com.example.weighbridge_on_universe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val KG_TO_POUND: Double = 2.2045
    private val POUND_TO_KG : Double = 0.45359237
    val MARS_CONSTANT : Double = 0.38

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var userKilogram = inputKiloText.text

        button_hesapla.setOnClickListener({ v ->
            var poundKilo = convertKiloToPound(userKilogram.toString().toDouble())
            var marsPound = poundKilo * MARS_CONSTANT
            var marsKilo = convertPoundToKilo(marsPound)
            result_view.text = marsKilo.toString()
        })

    }

    fun convertKiloToPound(kilo : Double) : Double {
        return kilo * KG_TO_POUND
    }

    fun convertPoundToKilo (pound : Double) : Double {
        return pound * POUND_TO_KG
    }

    fun Double.Format(kacRakam : Int) = java.lang.String.format("%.${kacRakam}", this)


}