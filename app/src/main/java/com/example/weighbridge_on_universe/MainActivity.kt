package com.example.weighbridge_on_universe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.CheckBox
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val KG_TO_POUND: Double = 2.2045
    private val POUND_TO_KG : Double = 0.45359237
    private val MARS : Double = 0.38
    private val JUPITER : Double = 2.34
    private val VENUS : Double = 0.91

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Glide.with(this).load(R.drawable.title).into(imageView)//Glide ile yükledik


        checkBoxMars.setOnClickListener(this) //Neleri Dinleyeceğini söyledik
        checkBoxJupi.setOnClickListener(this)
        checkBoxVenus.setOnClickListener(this)
    }

    fun convertKiloToPound(kilo : Double) : Double {
        return kilo * KG_TO_POUND
    }

    fun convertPoundToKilo (pound : Double) : Double {
        return pound * POUND_TO_KG
    }

    fun Double.Format(kacRakam : Int) = java.lang.String.format("%.${kacRakam}", this)

    override fun onClick(v: View?) {//CheckBox Dinlicek şekilde configure ettim

        v as CheckBox

        var isChecked : Boolean = v.isChecked

        var userKilogram = inputKiloText.text.toString().toDouble()
        var pound = convertKiloToPound(userKilogram)

        if(!TextUtils.isEmpty(inputKiloText.text.toString())) {
            when(v.id) {
                R.id.checkBoxJupi-> if(isChecked) {
                    checkBoxMars.isChecked = false
                    checkBoxVenus.isChecked = false
                    calculateUserKilo(pound, v)
                }
                R.id.checkBoxMars-> if(isChecked){
                    checkBoxVenus.isChecked = false
                    checkBoxJupi.isChecked = false
                    calculateUserKilo(pound, v)
                }
                R.id.checkBoxVenus-> if(isChecked) {
                    checkBoxJupi.isChecked = false
                    checkBoxMars.isChecked = false
                    calculateUserKilo(pound, v)
                }
                else -> {
                    println("Nothing !!!")
                }
            }

        }



    }


    fun calculateUserKilo(pound: Double, checkBox: CheckBox) {
        var calculatedpound : Double
        var calculatedkilo : Double

        when(checkBox.id) {

            R.id.checkBoxMars -> {
                calculatedpound = pound * MARS
                calculatedkilo= convertPoundToKilo(calculatedpound)
                result_view.text = calculatedkilo.toString()
            }
            R.id.checkBoxJupi -> {
                calculatedpound = pound * JUPITER
                calculatedkilo= convertPoundToKilo(calculatedpound)
                result_view.text = calculatedkilo.toString()
            }
            R.id.checkBoxVenus -> {
                calculatedpound = pound * VENUS
                calculatedkilo= convertPoundToKilo(calculatedpound)
                result_view.text = calculatedkilo.toString()
            }
        }
    }

}



/*button_hesapla.setOnClickListener({ v ->
          var poundKilo = convertKiloToPound(userKilogram.toString().toDouble())
          var marsPound = poundKilo * MARS
          var marsKilo = convertPoundToKilo(marsPound)
          result_view.text = marsKilo.toString()
      })*/