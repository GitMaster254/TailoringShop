package com.example.tailoringshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tailoringshop.R

class ViewStockFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_view_stock, container, false)

        val stockContainer: LinearLayout = view.findViewById(R.id.stockContainer)

        // Sample dummy stock data – Replace this with actual Room DB query later
        val stockData = listOf(
            "Thread - Red (Small): 10 units",
            "Thread - Blue (Large): 5 units",
            "Zip - Metal (10cm): 8 units",
            "Elastic - 1 inch: 15 meters",
            "Cotton - White: 20 rolls"
        )

        for (item in stockData) {
            val textView = TextView(requireContext()).apply {
                text = item
                textSize = 16f
                setPadding(8, 8, 8, 8)
            }
            stockContainer.addView(textView)
        }

        return view
    }
}
