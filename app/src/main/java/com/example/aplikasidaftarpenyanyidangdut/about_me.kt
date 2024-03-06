package com.example.aplikasidaftarpenyanyidangdut

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class about_me : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_me)

        supportActionBar?.setTitle("About Me")
    }
}