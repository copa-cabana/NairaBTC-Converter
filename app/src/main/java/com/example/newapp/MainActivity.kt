package com.example.newapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.newapp.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnConverter.setOnClickListener {
            calculateValue()
        }
    }

    private fun calculateValue() {

        val cost = binding.cost.text.toString().toDoubleOrNull()
//    Condition to check if input field has value or empty
        if(cost == null){
            binding.valueResult.text = ""
            return
        }
        val btc = 0.0000000499396

        var btcRoundedUpValue = btc * cost

        binding.valueResult.text = NumberFormat.getNumberInstance().format(btcRoundedUpValue)

//        To convert result to whole number
        var wholeNumber = binding.switchRoundUp.isChecked

        if (wholeNumber){
            btcRoundedUpValue = kotlin.math.round(btcRoundedUpValue)
        }

        binding.valueResult.text = NumberFormat.getNumberInstance().format(btcRoundedUpValue)
    }
}