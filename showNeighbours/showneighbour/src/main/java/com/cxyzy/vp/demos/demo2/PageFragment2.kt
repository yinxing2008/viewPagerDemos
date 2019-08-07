package com.cxyzy.vp.demos.demo2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.cxyzy.vp.demos.R
import kotlin.math.floor

class PageFragment2 : Fragment() {
    private var title: String? = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = arguments?.getString(EXTRA_TITLE)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = View.inflate(context, R.layout.fragment_page2, null)
        view.findViewById<TextView>(R.id.textView).text = title
        view.setBackgroundColor(getRandomBgColor())
        return view
    }

    private fun getRandomBgColor(): Int {
        return Color.rgb(floor(Math.random() * 128).toInt() + 64,
                floor(Math.random() * 128).toInt() + 64,
                floor(Math.random() * 128).toInt() + 64)
    }

    companion object {
        private const val EXTRA_TITLE = "title"
        fun buildIntent(title: String): PageFragment2 {
            val fragment = PageFragment2()
            var bundle = Bundle()
            bundle.putString(EXTRA_TITLE, title)
            fragment.arguments = bundle
            return fragment
        }
    }
}
