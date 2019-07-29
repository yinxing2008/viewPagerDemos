package bottomnav.hitherejoe.com.bottomnavigationsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class BaseFragment : Fragment() {
    private var title: String? = ""
    private var index: Int? = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(EXTRA_TITLE)
        index = arguments?.getInt(EXTRA_INDEX, 0)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.fragment_base, null)
        view.findViewById<TextView>(R.id.textView).text = title
        if (index == 0) {
            view.setBackgroundResource(R.color.aa)
        } else if (index == 1) {
            view.setBackgroundResource(R.color.bb)
        } else {
            view.setBackgroundResource(R.color.cc)
        }
        return view
    }

    companion object {
        private const val EXTRA_TITLE = "title"
        private const val EXTRA_INDEX = "index"
        fun buildIntent(title: String, index: Int): BaseFragment {
            val fragment = BaseFragment()
            var bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            bundle.putInt(EXTRA_INDEX, index)
            fragment.arguments = bundle
            return fragment
        }
    }
}
