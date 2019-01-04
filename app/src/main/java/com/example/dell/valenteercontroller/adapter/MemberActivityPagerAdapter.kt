package com.example.dell.valenteercontroller.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class MemberActivityPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val fragmentList: ArrayList<Fragment> = arrayListOf()
    private val fragmentTitleList: ArrayList<String> = arrayListOf()
    override fun getItem(p0: Int): Fragment {
        return fragmentList[p0]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitleList[position]
    }

    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        fragmentTitleList.add(title)
    }
}