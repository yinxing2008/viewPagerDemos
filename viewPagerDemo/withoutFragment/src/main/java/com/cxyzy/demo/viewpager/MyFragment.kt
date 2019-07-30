package com.cxyzy.demo.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class MyFragment : Fragment() {
    private var title: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(EXTRA_TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.fragment_base, null)
        view.findViewById<TextView>(R.id.textView).text = title
        return view
    }

    companion object {
        private const val EXTRA_TITLE = "title"
        fun buildIntent(title: String): MyFragment {
            val fragment = MyFragment()
            var bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
