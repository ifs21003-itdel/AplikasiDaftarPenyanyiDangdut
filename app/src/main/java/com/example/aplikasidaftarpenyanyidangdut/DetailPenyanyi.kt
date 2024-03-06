package com.example.aplikasidaftarpenyanyidangdut

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class DetailPenyanyi : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_DESCRIPTION = "extra_desc"
        const val EXTRA_PHOTO = "extra_photo"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_penyanyi)

        val buttonShare : Button = findViewById(R.id.action_share)
        buttonShare.setOnClickListener(this)

        val title: TextView = findViewById(R.id.title)
        val deskripsi: TextView = findViewById(R.id.description)
        val photo: ImageView = findViewById(R.id.imageView)
        val namaPenyanyi = intent.getStringExtra(EXTRA_NAME)
        val photoPenyanyi = intent.getIntExtra(EXTRA_PHOTO, 0)
        val deskripsiPenyanyi = intent.getStringExtra(EXTRA_DESCRIPTION)
        title.text = namaPenyanyi
        deskripsi.text = deskripsiPenyanyi
        photo.setImageResource(photoPenyanyi)
    }

    override fun onClick(v: View?) {
        val titleTextView: TextView = findViewById(R.id.title)
        val descriptionTextView: TextView = findViewById(R.id.description)
        val name : String = titleTextView.text.toString()
        println(name)
        val desc : String = name.plus("\n \n").plus(descriptionTextView.text.toString())
        val intent = Intent()
        intent.action = Intent.ACTION_SEND
        intent.putExtra(Intent.EXTRA_TEXT, desc)
        intent.type = "text/plain"

        startActivity(Intent.createChooser(intent, "Share to:"))
    }


}