package com.example.tiketkereta

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class loginpage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loginpage)

        val btlogen = findViewById<Button>(R.id.btlogen)

        btlogen.setOnClickListener(View.OnClickListener {
            // Ketika tombol btlogin ditekan, buat intent untuk berpindah ke halaman pesan tiket
            val intent = Intent(this@loginpage, belitiket::class.java)
            startActivity(intent)
        })
    }
}