package bottomnav.hitherejoe.com.bottomnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

open class MainActivity : AppCompatActivity() {

    private val pageTitles = arrayOf("Page 1", "Page 2", "Page 3", "Page 4", "Page 5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = getFragments()

        viewPager.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
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
            val fragment = BaseFragment.buildIntent(pageTitles[index])
            fragments.add(fragment)
        }

        return fragments
    }
}
