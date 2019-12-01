package com.shgbievi.androidtasks

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_item.*

class MainActivity : AppCompatActivity() {

    private var animateDown = true
    private var animateUp = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val list = arrayListOf(
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/6843-1.jpg", "Белый лев"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/zhiv1.jpg", "Тигар"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/6843-1.jpg", "Белый лев"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/zhiv1.jpg", "Тигар"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/6843-1.jpg", "Белый лев"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/zhiv1.jpg", "Тигар"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/6843-1.jpg", "Белый лев"),
            Animal("https://bipbap.ru/wp-content/uploads/2017/04/zhiv1.jpg", "Тигар")
        )
        rv_animals.adapter = AnimalAdapter(list)
        addOnScrollListener()
    }

    private fun addOnScrollListener() {
        rv_animals.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    animateDown = true
                    animateUp = true
                }
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0 && animateDown) {
                    tv_animal.apply {
                        alpha = 0f
                        visibility = View.VISIBLE
                        animate()
                            .alpha(1f)
                            .setListener(null)
                            .duration =
                            resources.getInteger(android.R.integer.config_shortAnimTime)
                                .toLong()

                    }
                    animateDown = false
                } else if (dy < 0 && animateUp) {
                    tv_animal.apply {
                        alpha = 1f
                        animate()
                            .alpha(0f)
                            .setListener(null)
                            .duration =
                            resources.getInteger(android.R.integer.config_shortAnimTime)
                                .toLong()
                    }
                    animateUp = false

                }
            }
        })
    }

}
