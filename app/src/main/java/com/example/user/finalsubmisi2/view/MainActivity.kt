package com.example.user.finalsubmisi2.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.user.finalsubmisi2.R
import com.example.user.finalsubmisi2.R.layout.activity_main
import com.example.user.finalsubmisi2.view.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_main)

        val fragmentAdapter = MyPagerAdapter(supportFragmentManager,this)
        viewpager_main.adapter = fragmentAdapter

        tabs_main.setupWithViewPager(viewpager_main)
    }
}
