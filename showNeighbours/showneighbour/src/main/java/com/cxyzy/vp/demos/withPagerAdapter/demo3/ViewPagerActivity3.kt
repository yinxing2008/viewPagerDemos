package com.cxyzy.vp.demos.withPagerAdapter.demo3

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.PagerAdapter
import com.cxyzy.vp.demos.R
import kotlinx.android.synthetic.main.activity_vp4.*

class ViewPagerActivity3 : AppCompatActivity() {

    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp3)

        viewPager.adapter = object : PagerAdapter() {
            override fun instantiateItem(container: ViewGroup, position: Int): Any {
                val inflater = LayoutInflater.from(this@ViewPagerActivity3)
                val rootView = inflater.inflate(R.layout.view_page3, container, false) as ViewGroup
                val textView = rootView.findViewById<TextView>(R.id.textView)
                textView.text = getPageTitle(position)
                container.addView(rootView)
                return rootView
            }

            override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
                container.removeView(obj as View)
            }

            override fun getPageTitle(position: Int): CharSequence? {
                return pageTitles[position]
            }

            override fun getCount(): Int {
                return pageTitles.size
            }

            override fun isViewFromObject(view: View, obj: Any): Boolean {
                return view === obj
            }
        }
    }
}
