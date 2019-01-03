package com.example.dell.valenteercontroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import kotlinx.android.synthetic.main.activity_homepage.*
import java.util.*

class HomepageActivity : AppCompatActivity() {
    private lateinit var mAdapter: ImageSlideshowAdapter
    private lateinit var mHandler: Handler
    private lateinit var mRunnable: Runnable
    private lateinit var mTimer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(null)

        mAdapter = ImageSlideshowAdapter(this)
        viewPager.adapter = mAdapter
        circle_indicator.setViewPager(viewPager)

        mHandler = Handler()
        mRunnable = Runnable {
            var i = viewPager.currentItem

            if (i == mAdapter.imageList.size - 1) {

                i = 0
                viewPager.setCurrentItem(i, true)

            } else {

                i++
                viewPager.setCurrentItem(i, true)
            }
        }

        mTimer = Timer()
        mTimer.schedule(object : TimerTask() {
            override fun run() {

                mHandler.post(mRunnable)
            }
        }, 4000, 4000)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.homepage_menu, menu)
        return true
    }
}
