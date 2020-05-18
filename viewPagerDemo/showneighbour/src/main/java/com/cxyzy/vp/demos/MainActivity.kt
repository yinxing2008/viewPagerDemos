package com.cxyzy.vp.demos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cxyzy.utils.ext.startActivity
import com.cxyzy.vp.demos.withFragment.demo1.ViewPagerActivity1
import com.cxyzy.vp.demos.withPagerAdapter.demo4.ViewPagerActivity4
import com.cxyzy.vp.demos.withFragment.demo2.ViewPagerActivity2
import com.cxyzy.vp.demos.withPagerAdapter.demo3.ViewPagerActivity3
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { startActivity<ViewPagerActivity1>() }
        button2.setOnClickListener { startActivity<ViewPagerActivity2>() }
        button3.setOnClickListener { startActivity<ViewPagerActivity3>() }
        button4.setOnClickListener { startActivity<ViewPagerActivity4>() }
    }

}
