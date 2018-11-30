package com.example.user.finalsubmisi2.view.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.user.finalsubmisi2.R
import com.example.user.finalsubmisi2.view.LastFragment
import com.example.user.finalsubmisi2.view.NextFragment
import com.example.user.finalsubmisi2.R.string.last_match
import com.example.user.finalsubmisi2.R.string.next_match

class MyPagerAdapter(fm:FragmentManager, context: Context) : FragmentPagerAdapter(fm) {
    val con = context;

    override fun getItem(p0: Int): Fragment {
        return when (p0){
            0 ->{
                LastFragment()
            }
            1 -> NextFragment()
            else ->{
                LastFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 ->{
                con.resources.getString(last_match)
            }
            1 -> con.resources.getString(next_match)
            else ->{
                con.resources.getString(last_match)
            }
        }
    }
}