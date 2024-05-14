package com.example.lotterynumbers

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lotterynumbers.R.id.goBackButton

class ResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var goBackButton : Button
        lateinit var shareNumButton : Button
        lateinit var userNameText : TextView
        lateinit var randomNum1: TextView
        lateinit var randomNum2: TextView
        lateinit var randomNum3: TextView
        lateinit var randomNum4: TextView
        lateinit var randomNum5: TextView
        lateinit var randomNum6: TextView

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_results)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        userNameText = findViewById(R.id.userNameText)
        userNameText.text = intent.getStringExtra("userName")
        goBackButton = findViewById(R.id.goBackButton)
        goBackButton.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        shareNumButton = findViewById(R.id.shareNumButton)
        shareNumButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            val userName = userNameText.text.toString()
            var message = "$userName generated these numbers with Lottery App:"
            message += "\n"
            message += "The lottery numbers are: " + randomNum1.text + " " +
                    randomNum2.text + " " +
                    randomNum3.text + " " +
                    randomNum4.text + " " +
                    randomNum5.text + " " +
                    randomNum6.text
            intent.putExtra(Intent.EXTRA_TEXT, message)
            startActivity(Intent.createChooser(intent, "Share numbers with:"))
        }

        randomNum1 = findViewById(R.id.randomNum1)
        randomNum2 = findViewById(R.id.randomNum2)
        randomNum3 = findViewById(R.id.randomNum3)
        randomNum4 = findViewById(R.id.randomNum4)
        randomNum5 = findViewById(R.id.randomNum5)
        randomNum6 = findViewById(R.id.randomNum6)

        val random = java.util.Random()
        randomNum1.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)
        randomNum2.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)
        randomNum3.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)
        randomNum4.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)
        randomNum5.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)
        randomNum6.text = getString(R.string.random_number_placeholder, random.nextInt(49) + 1)

    }
}