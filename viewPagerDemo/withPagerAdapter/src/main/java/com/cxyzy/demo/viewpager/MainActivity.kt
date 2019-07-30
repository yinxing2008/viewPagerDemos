package com.cxyzy.demo.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewPager.adapter = object : PagerAdapter() {
            var layouts = intArrayOf(R.layout.fragment_base, R.layout.fragment_base, R.layout.fragment_base)

            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val inflater = LayoutInflater.from(this@MainActivity)
                val layout = inflater.inflate(layouts[position], container, false) as ViewGroup
                val textView = layout.findViewById<TextView>(R.id.textView)
                textView.text = getPageTitle(position)
                container.addView(layout)
                return layout
            }

            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                container.removeView(obj as View)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return pageTitles[position]
            }

            override fun getCount(): Int {
                return layouts.size
            }

            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view === obj
            }
        }
    }


}
