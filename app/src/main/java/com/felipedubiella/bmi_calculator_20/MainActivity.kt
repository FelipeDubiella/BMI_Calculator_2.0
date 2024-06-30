package com.felipedubiella.bmi_calculator_20

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.felipedubiella.bmi_calculator_20.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        with(binding) {

            btnCalculate.setOnClickListener {

                val edtHeight: String = edtHeight.text.toString()
                val edtWeight: String = edtWeight.text.toString()

                val intent = Intent(this@MainActivity, resultActivity::class.java)

                if (edtWeight.isNotEmpty() && edtHeight.isNotEmpty()) {
                    intent.putExtra("height", edtHeight.toFloat())
                    intent.putExtra("weight", edtWeight.toFloat())
                    startActivity(intent)

                } else {
                    Toast.makeText(
                        this@MainActivity,
                        "Fill all the fields to calcute your BMI",
                        Toast.LENGTH_SHORT
                    ).show()
                }


            }


        }



    }
}
