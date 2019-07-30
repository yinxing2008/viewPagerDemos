package com.cxyzy.demo.viewpager

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.view_pager_view.view.*
import java.util.*

class ViewPagerView(context: Context?, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    init {
        LayoutInflater.from(context).inflate(R.layout.view_pager_view, this, true)
    }

    fun initViews(context: FragmentActivity) {
        val fragments = getFragments()
        viewPager.adapter = object : FragmentStatePagerAdapter(context.supportFragmentManager) {
            override fun getCount(): Int {
                return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }
        }
    }

    private fun getFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>()

        for (index in 0 until pageTitles.size) {
            val fragment = ViewPagerFragment.buildIntent(pageTitles[index])
            fragments.add(fragment)
        }

        return fragments
    }
}