package com.example.myapplication

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity()
    {
        lateinit var binding: ActivityMainBinding
       private var tvselectedDate : TextView? = null
        private  var tvAgeInMinutes : TextView? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnDatePicker :Button = findViewById(R.id.btnDatePicker)
        tvselectedDate = findViewById(R.id.tvSelectedDate)
        tvAgeInMinutes = findViewById(R.id.tvAgeInMinutes)
        btnDatePicker.setOnClickListener {
            clickDatePicker()
    }

    }

        fun clickDatePicker() {
            val myCalender = Calendar.getInstance()
            val year =myCalender.get(Calendar.YEAR)
            val month = myCalender.get(Calendar.MONTH)
            val day = myCalender.get(Calendar.DAY_OF_MONTH)


            DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {view, selectedyear,selectedmonth,selecteddayofmonth->
                Toast.makeText(this,
                    "Year was $selectedyear and month ${selectedmonth+1} and day $selecteddayofmonth",
                    Toast.LENGTH_LONG).show()
                val selectedDate = "$selecteddayofmonth/${selectedmonth+1}/$selectedyear"
                tvselectedDate?.text = selectedDate
                val sdf =SimpleDateFormat("dd/mm/yyyy", Locale.ENGLISH)
                val theDate =sdf.parse(selectedDate)
                val selectedDateInMinutes = theDate.time / 60000
                val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val currentDateInMinutes = currentDate.time/60000
                val differenceInMinutes = currentDateInMinutes - selectedDateInMinutes
                tvAgeInMinutes?.text = differenceInMinutes.toString()


            },
                year,
                month,
                day
            ).show()

        }

}