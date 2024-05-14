package com.example.lotterynumbers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var obtainLotteryNumbers : Button
        lateinit var userNameText : EditText

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userNameText = findViewById(R.id.userNameText)
        obtainLotteryNumbers = findViewById(R.id.obtainLotteryNumbers)
        obtainLotteryNumbers.setOnClickListener {
            val intent = Intent(this, ResultsActivity::class.java)
            intent.putExtra("userName", userNameText.text.toString())
            startActivity(intent)
        }
    }
}