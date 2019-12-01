package com.shgbievi.androidtasks

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val imgUrl = intent.getStringExtra("ivAnimal")
        val tv = intent.getStringExtra("tvAnimal")
        Glide.with(this)
            .load(imgUrl)
            .into(iv_animal)
        tv_animal.text = tv
    }

}
