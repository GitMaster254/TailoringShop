package com.example.tailoringshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.tailoringshop.R
import com.example.tailoringshop.data.models.Sale
import com.example.tailoringshop.data.AppDatabase
import kotlinx.coroutines.launch
import androidx.lifecycle.lifecycleScope


class SellItemFragment : Fragment() {

    private lateinit var categorySpinner: Spinner
    private lateinit var itemNameInput: EditText
    private lateinit var itemSizeInput: EditText
    private lateinit var itemColorInput: EditText
    private lateinit var itemQuantityInput: EditText
    private lateinit var itemPriceInput: EditText
    private lateinit var saveSellButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_sell_item, container, false)

        // Initialize views
        categorySpinner = view.findViewById(R.id.categorySpinner)
        itemNameInput = view.findViewById(R.id.itemNameInput)
        itemSizeInput = view.findViewById(R.id.itemSizeInput)
        itemColorInput = view.findViewById(R.id.itemColorInput)
        itemQuantityInput = view.findViewById(R.id.itemQuantityInput)
        itemPriceInput = view.findViewById(R.id.itemPriceInput)
        saveSellButton = view.findViewById(R.id.saveSellButton)

        // Setup spinner options
        val categories = listOf("Thread", "Zip", "Cotton", "Elastic", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        // Handle save button click
        saveSellButton.setOnClickListener {
            val category = categorySpinner.selectedItem.toString()
            val name = itemNameInput.text.toString()
            val size = itemSizeInput.text.toString()
            //color is optional is the ui form
            val color = itemColorInput.text.toString()
            val quantity = itemQuantityInput.text.toString()
            val price = itemPriceInput.text.toString()

            if (name.isBlank() || price.isBlank()) {
                Toast.makeText(requireContext(), "Please fill the required fields.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // You can now use this data to insert into Room or perform other actions
            Toast.makeText(requireContext(), "Sale saved for $category - $name", Toast.LENGTH_SHORT).show()

            // Optional: Clear inputs after save
            itemNameInput.text.clear()
            itemSizeInput.text.clear()
            itemColorInput.text.clear()
            itemQuantityInput.text.clear()
            itemPriceInput.text.clear()
        }

        return view
    }
    private fun saveSaleToDatabase(
        category: String,
        name: String,
        size: String,
        color: String,
        quantity: Int,
        price: Double,
        timestamp: Long
    ) {
        // Implement your database save logic here

        val sale = Sale(
            category = category,
            name = name,
            size = size,
            color = color,
            quantity = quantity,
            price = price,
            timestamp = timestamp)
        val db = AppDatabase.getDatabase(requireContext().applicationContext)

        lifecycleScope.launch{
            db.saleDao().insertSale(sale)
            Toast.makeText(requireContext(), "Sale saved to database", Toast.LENGTH_SHORT).show()
        }
    }
}
