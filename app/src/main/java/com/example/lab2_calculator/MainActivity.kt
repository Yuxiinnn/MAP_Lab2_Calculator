package com.example.lab2_calculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    // 1. Declare view variables
    lateinit var number1: EditText
    lateinit var number2: EditText
    lateinit var button_add: Button
    lateinit var textview_result: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        // Handles padding for the system status/navigation bars
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // 2. Bind variables to the XML layout components
        number1 = findViewById(R.id.number1)
        number2 = findViewById(R.id.number2)
        button_add = findViewById(R.id.btn_add)
        textview_result = findViewById(R.id.answer)
        // 3. Set OnClickListener for addition
        button_add.setOnClickListener {
            val str1 = number1.text.toString()
            val str2 = number2.text.toString()
            // Safe parsing to prevent crashes if an input is left blank
            val num1 = str1.toIntOrNull() ?: 0
            val num2 = str2.toIntOrNull() ?: 0
            val res = num1 + num2
            textview_result.text = res.toString()
        }
    }
}