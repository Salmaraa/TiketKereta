package com.example.tiketkereta

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tiketkereta.databinding.ActivityBelitiketBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class belitiket : AppCompatActivity() {

    private val calendar = Calendar.getInstance()
    private lateinit var binding: ActivityBelitiketBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBelitiketBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.datepick.setOnClickListener {
            showDatePicker()
        }

        binding.inputtime.setOnClickListener {
            showTimePicker()
        }

        binding.btntime.setOnClickListener {
            showTimePicker()
        }

        // Inisialisasi Spinner dengan data kelas tiket
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, kelas)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.kelastiket.adapter = adapter

        binding.pesan.setOnClickListener {
            val selectedDate = binding.datepick.text.toString()
            val selectedTime = binding.inputtime.text.toString()
            val selectedClass = binding.kelastiket.selectedItem.toString()

            // Munculkan pesan toast sesuai dengan input pengguna
            val toastMessage = "Tiket dengan tanggal keberangkatan $selectedDate, jam keberangkatan $selectedTime, dan kelas tiket $selectedClass berhasil dipesan"
            Toast.makeText(this, toastMessage, Toast.LENGTH_SHORT).show()
        }
    }

    private fun showDatePicker() {
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _, year, monthOfYear, dayOfMonth ->
                calendar.set(Calendar.YEAR, year)
                calendar.set(Calendar.MONTH, monthOfYear)
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

                val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
                binding.datepick.setText(dateFormat.format(calendar.time))
            },
            year,
            month,
            day
        )
        datePickerDialog.show()
    }

    private fun showTimePicker() {
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            this,
            TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
                calendar.set(Calendar.HOUR_OF_DAY, hourOfDay)
                calendar.set(Calendar.MINUTE, minute)

                val timeFormat = SimpleDateFormat("HH:mm", Locale.US)
                binding.inputtime.setText(timeFormat.format(calendar.time))
            },
            hour,
            minute,
            true
        )
        timePickerDialog.show()
    }

    private val kelas = arrayOf(
        "Ekonomi",
        "Bisnis",
        "Eksekutif",
        "Luxury"
    )
}

