package com.cxyzy.demo.viewpager

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import androidx.viewpager.widget.PagerAdapter



open class MainActivity : AppCompatActivity() {

    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewPager.setAdapter(object : PagerAdapter() {
            var titles = arrayOf("Eins", "Zwei", "Drei")
            var layouts = intArrayOf(R.layout.fragment_base, R.layout.fragment_base, R.layout.fragment_base)

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val inflater = LayoutInflater.from(this@MainActivity)
                val layout = inflater.inflate(layouts[position], container, false) as ViewGroup
                container.addView(layout)
                return layout
            }

            override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
                container.removeView(`object` as View)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return titles[position]
            }

            override fun getCount(): Int {
                return layouts.size
            }

            override fun isViewFromObject(view: View, `object`: Any): Boolean {
                return view === `object`
            }
        })
    }


}
