package com.example.tiketkereta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnext = findViewById<Button>(R.id.btnext)

        btnext.setOnClickListener(View.OnClickListener {
            // Ketika tombol btnext ditekan, buat intent untuk berpindah ke halaman login
            val intent = Intent(this@MainActivity, loginpage::class.java)
            startActivity(intent)
        })
    }
}