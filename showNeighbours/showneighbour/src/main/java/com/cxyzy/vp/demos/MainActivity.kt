package com.cxyzy.vp.demos

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cxyzy.utils.ext.startActivity
import com.cxyzy.vp.demos.demo1.ViewPagerActivity1
import com.cxyzy.vp.demos.demo2.ViewPagerActivity2
import kotlinx.android.synthetic.main.activity_main.*

open class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener { startActivity<ViewPagerActivity1>() }
        button2.setOnClickListener { startActivity<ViewPagerActivity2>() }
    }


}
