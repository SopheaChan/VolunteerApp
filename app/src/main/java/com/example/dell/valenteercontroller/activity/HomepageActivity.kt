package com.example.dell.valenteercontroller.activity

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import com.example.dell.valenteercontroller.adapter.ImageSlideshowAdapter
import com.example.dell.valenteercontroller.R
import com.example.dell.valenteercontroller.helper.slideShowImage
import kotlinx.android.synthetic.main.activity_homepage.*

class HomepageActivity : AppCompatActivity() {
    private lateinit var mAdapter: ImageSlideshowAdapter
    private var imageListSize: Int = 0
    private val imageList: IntArray =  intArrayOf(
        R.drawable.volunteer_image1,
        R.drawable.volunteer_image2,
        R.drawable.volunteer_image3
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homepage)


        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        mAdapter = ImageSlideshowAdapter(this, imageList)
        imageListSize = imageList.size - 1
        slideShowImage(mAdapter, viewPager, circle_indicator, imageListSize)
        imgMemberFunctionButton.setOnClickListener{
            startActivity(Intent(this, MemberManagementActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.homepage_menu, menu)
        return true
    }

    override fun onStart() {
        super.onStart()
        Log.d("onStart: ", "Executed")
    }
}
