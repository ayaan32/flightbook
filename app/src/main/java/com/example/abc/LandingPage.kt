package com.example.abc

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

@Suppress("DEPRECATION")
class LandingPage : AppCompatActivity() {

    @SuppressLint("WeekBasedYear")
    var formatDate=SimpleDateFormat("dd MMM YYYY", Locale.US)
    val players= arrayOf("Mangalore-IXE","Pune-PNQ","Delhi_DEL","Lucknow-LKO")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.landing_page)
        val datePickerButtonto=findViewById<Button>(R.id.datePickerButtonto)
        val datePickerButtonfrom=findViewById<Button>(R.id.datePickerButtonfrom)
        datePickerButtonto.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Dialog_MinWidth,
                { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    Toast.makeText(this, date, Toast.LENGTH_SHORT).show()
                    datePickerButtonto.setText(date)
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()

        }
        datePickerButtonfrom.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datePicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Dialog_MinWidth,
                { datePicker, i, i2, i3 ->
                    val selectDate = Calendar.getInstance()
                    selectDate.set(Calendar.YEAR, i)
                    selectDate.set(Calendar.MONTH, i2)
                    selectDate.set(Calendar.DAY_OF_MONTH, i3)
                    val date = formatDate.format(selectDate.time)
                    Toast.makeText(this, date, Toast.LENGTH_SHORT).show()
                    datePickerButtonfrom.setText(date)
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )
            datePicker.show()

        }
        val spinner=findViewById<Spinner>(R.id.spinCountryFrom)
        val spinner2=findViewById<Spinner>(R.id.spinCountryTo)
        val arrayAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,players)
        spinner.adapter=arrayAdapter
        spinner.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@LandingPage,players[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        val arrayAdapter2=ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,players)
        spinner2.adapter=arrayAdapter2
        spinner2.onItemSelectedListener= object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                Toast.makeText(this@LandingPage,players[p2],Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
        val searchflightsbutton = findViewById<Button>(R.id.searchflightsbutton)
        searchflightsbutton.setOnClickListener {
            val intent = Intent(this, ListScreen::class.java)
            startActivity(intent)
        }
    }
}