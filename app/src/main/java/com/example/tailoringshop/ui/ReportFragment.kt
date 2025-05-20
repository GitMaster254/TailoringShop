package com.example.tailoringshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.tailoringshop.R
import com.example.tailoringshop.data.models.Sale // Replace with your actual sale model package
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.example.tailoringshop.data.AppDatabase
import kotlinx.coroutines.launch


class DailyReportFragment : Fragment() {

    private lateinit var reportContainer: LinearLayout
    private lateinit var totalSalesText: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_report, container, false)

        reportContainer = view.findViewById(R.id.reportContainer)
        totalSalesText = view.findViewById(R.id.totalSalesText)

        val db = Room.databaseBuilder(
            requireContext(),
            AppDatabase::class.java, "tailoring_shop"
        ).build()

        lifecycleScope.launch {
            val sales = db.saleDao().getAllSales() // Replace with your actual DAO method
            generateReport(sales)
        }
        return view
    }

    private fun generateReport(sales: List<Sale>) {
        reportContainer.removeAllViews()

        var total = 0.0
        for (sale in sales) {
            val itemView = TextView(requireContext())
            val itemTotal = sale.quantity * sale.price

            itemView.text =getString(R.string.sale_item_format,
                sale.category,sale.size,
                sale.quantity,sale.price,
                itemTotal
            )
            reportContainer.addView(itemView)

            total += itemTotal
        }

        totalSalesText.text = getString(R.string.total_sales_format, total)
    }
}
