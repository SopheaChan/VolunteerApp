package com.example.dell.valenteercontroller

import android.view.View
import android.widget.ProgressBar
import android.widget.TextView
import android.os.Handler
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import me.relex.circleindicator.CircleIndicator
import java.util.*

fun progressBarEnable(progressBar: ProgressBar, loadingText: TextView) {
    progressBar.visibility = View.VISIBLE
    loadingText.visibility = View.VISIBLE
}

fun progressBarDisable(progressBar: ProgressBar, loadingText: TextView) {
    progressBar.visibility = View.INVISIBLE
    loadingText.visibility = View.INVISIBLE
}

fun slideShowImage(mAdapter: PagerAdapter, viewPager: ViewPager, circle_indicator: CircleIndicator, imageListSize: Int) {
    val mHandler = Handler()
    lateinit var mRunnable: Runnable
    val mTimer = Timer()

    viewPager.adapter = mAdapter
    circle_indicator.setViewPager(viewPager)

    mRunnable = Runnable {
        var i = viewPager.currentItem

        if (i == imageListSize) {

            i = 0
            viewPager.setCurrentItem(i, true)

        } else {

            i++
            viewPager.setCurrentItem(i, true)
        }
    }

    mTimer.schedule(object : TimerTask() {
        override fun run() {

            mHandler.post(mRunnable)
        }
    }, 4000, 4000)
}