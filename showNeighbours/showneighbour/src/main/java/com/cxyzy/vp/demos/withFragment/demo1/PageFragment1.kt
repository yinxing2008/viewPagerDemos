package com.cxyzy.vp.demos.withFragment.demo1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cxyzy.vp.demos.R

class PageFragment1 : Fragment() {
    private var title: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(EXTRA_TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.view_page1, null)
        view.findViewById<TextView>(R.id.textView).text = title
        return view
    }

    companion object {
        private const val EXTRA_TITLE = "title"
        fun buildIntent(title: String): PageFragment1 {
            val fragment = PageFragment1()
            var bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
