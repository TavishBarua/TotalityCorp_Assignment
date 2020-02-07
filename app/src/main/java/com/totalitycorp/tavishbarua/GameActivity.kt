package com.totalitycorp.tavishbarua

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_game.*

class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)


        val objAnimator = ObjectAnimator.ofInt(progress_bar,"progress",progress_bar.progress,100).setDuration(2000)
        objAnimator.addUpdateListener {
            val progress = it.animatedValue as Int
            progress_bar.progress=progress
        }

        fl_btm_download.setOnClickListener {
            objAnimator.start()
        }






    }
}
