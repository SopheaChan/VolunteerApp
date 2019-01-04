package com.example.dell.valenteercontroller.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import com.example.dell.valenteercontroller.R
import com.example.dell.valenteercontroller.adapter.MemberActivityPagerAdapter
import com.example.dell.valenteercontroller.fragment.AttendanceRecordFragment
import com.example.dell.valenteercontroller.fragment.MemberListFragment
import kotlinx.android.synthetic.main.activity_memeber_management.*

class MemberManagementActivity : AppCompatActivity() {
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.homepage_menu, menu)
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_memeber_management)
        setSupportActionBar(memberManagementActivityToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = null

        val mActivityPagerAdapter =
            MemberActivityPagerAdapter(supportFragmentManager)
        addFragmentToActivity(mActivityPagerAdapter)
    }

    private fun addFragmentToActivity(m: MemberActivityPagerAdapter) {
        m.addFragment(MemberListFragment(),"Member List")
        m.addFragment(AttendanceRecordFragment(), "Attendance")
        memberActivityViewPager.adapter = m
        tabLayout.setupWithViewPager(memberActivityViewPager)
    }
}
