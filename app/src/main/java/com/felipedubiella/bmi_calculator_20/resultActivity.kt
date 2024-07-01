package com.felipedubiella.bmi_calculator_20

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.felipedubiella.bmi_calculator_20.databinding.ActivityResultBinding

class resultActivity : AppCompatActivity() {
    private val binding by lazy { ActivityResultBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {

            val bundle = intent.extras
            if (bundle != null) {

                val height = bundle.getFloat("height")
                val weight = bundle.getFloat("weight")

                val result = weight / (height * height)

                tvHeight.text = "Your height is: $height"
                tvWeight.text = "Your Weight is: $weight"
                tvResult.text = "$result"

                val classification = if (result <= 18.5f) {
                    "UNDERWEIGHT"

                } else if (result > 18.5f && result <= 24.9) {
                    "NORMAL"
                } else if (result >= 25f && result <= 29.9) {
                    "OVERWEIGHT"
                } else {
                    "OBESE"
                }

                tvClassification.text = classification

            }


        }


    }
}