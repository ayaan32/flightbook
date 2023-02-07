package com.example.abc

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sign_in_page)
        val firstButton = findViewById<Button>(R.id.signin)
        firstButton.setOnClickListener {
            val text = findViewById<EditText>(R.id.email)
            val value = text.text.toString()
            val textpass = findViewById<EditText>(R.id.password)
            val valuepass = textpass.text.toString()

            if(value.equals("Ayaan") && valuepass.equals("letpass")) {
                val intent = Intent(this, LandingPage::class.java)
                startActivity(intent)
            }
            else
            {
                val builder = AlertDialog.Builder(this)
                builder.setIcon(R.drawable.ic_error_foreground)
                builder.setTitle("Invalid Credentials")
                builder.setPositiveButton("OK") {dialog, which -> {} }
                builder.show()
            }
        }
        val regButton = findViewById<Button>(R.id.signup)
        regButton.setOnClickListener {
            regNewUser(User(fn = "Ayaan", ln = "Tariq", em = "Ayaan", pw = "letpass", ag = 21), this)
//            expNewUser(User(fn = "Ayaan", ln = "Tariq", em = "ayaan", pw = "letpass", ag = 21), this)
        }
    }
    }