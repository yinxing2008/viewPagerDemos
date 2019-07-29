package bottomnav.hitherejoe.com.bottomnavigationsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val favoritesTabIndex = 0
    private val schedulesTabIndex = 1
    private val mineTabIndex = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = getFragments()


        vp.adapter = object : FragmentStatePagerAdapter(supportFragmentManager) {
            override fun getCount(): Int {
               return fragments.size
            }

            override fun getItem(position: Int): Fragment {
                return fragments[position]
            }
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.action_favorites -> {
                    vp.setCurrentItem(favoritesTabIndex, false)
                }
                R.id.action_schedules -> {
                    vp.setCurrentItem(schedulesTabIndex, false)
                }
                R.id.action_music -> {
                    vp.setCurrentItem(mineTabIndex, false)
                }
            }
            true
        }
    }

    private fun getFragments(): ArrayList<Fragment> {
        val fragments = ArrayList<Fragment>(3)

        val favoritesFragment = BaseFragment()
        var bundle = Bundle()
        bundle.putString("title", getString(R.string.favorites))
        favoritesFragment.arguments = bundle

        val schedulesFragment = BaseFragment()
        bundle = Bundle()
        bundle.putString("title", getString(R.string.schedules))
        bundle.putInt("index", 1)
        schedulesFragment.arguments = bundle

        val mineFragment = BaseFragment()
        bundle = Bundle()
        bundle.putString("title", getString(R.string.mine))
        bundle.putInt("index", 2)
        mineFragment.arguments = bundle

        fragments.add(favoritesFragment)
        fragments.add(schedulesFragment)
        fragments.add(mineFragment)
        return fragments
    }
}
