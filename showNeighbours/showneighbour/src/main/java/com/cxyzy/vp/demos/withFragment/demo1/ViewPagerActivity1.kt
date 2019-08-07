package com.cxyzy.vp.demos.withFragment.demo1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.cxyzy.vp.demos.R
import kotlinx.android.synthetic.main.activity_vp2.*
import java.util.*

open class ViewPagerActivity1 : AppCompatActivity() {

    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vp1)

        val fragments = getFragments()

        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
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
            val fragment = PageFragment1.buildIntent(pageTitles[index])
            fragments.add(fragment)
        }

        return fragments
    }
}
