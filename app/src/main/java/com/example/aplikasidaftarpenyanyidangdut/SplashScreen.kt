package com.example.aplikasidaftarpenyanyidangdut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val background : ImageView = findViewById(R.id.imageView3)
        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.splash)
        background.startAnimation(sideAnimation)

        Handler().postDelayed(
            {
                startActivity(Intent(this@SplashScreen, MainActivity::class.java))
                finish()
            }, 2000
        )
    }
}