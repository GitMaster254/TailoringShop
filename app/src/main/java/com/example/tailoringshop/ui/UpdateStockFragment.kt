package com.example.tailoringshop.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.tailoringshop.R

class UpdateStockFragment : Fragment() {

    private lateinit var categorySpinner: Spinner
    private lateinit var itemNameInput: EditText
    private lateinit var itemSizeInput: EditText
    private lateinit var itemQuantityInput: EditText
    private lateinit var updateButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_update, container, false)

        // Initialize views
        categorySpinner = view.findViewById(R.id.categorySpinner)
        itemNameInput = view.findViewById(R.id.itemNameInput)
        itemSizeInput = view.findViewById(R.id.itemSizeInput)
        itemQuantityInput = view.findViewById(R.id.itemQuantityInput)
        updateButton = view.findViewById(R.id.updateStockButton)

        // Sample category data for Spinner
        val categories = listOf("Thread", "Zip", "Elastic", "Cotton", "Other")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, categories)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        categorySpinner.adapter = adapter

        // Handle update button click
        updateButton.setOnClickListener {
            val category = categorySpinner.selectedItem.toString()
            val name = itemNameInput.text.toString()
            val size = itemSizeInput.text.toString()
            val quantity = itemQuantityInput.text.toString().toIntOrNull()

            if (name.isBlank() || size.isBlank() || quantity == null) {
                Toast.makeText(requireContext(), "Please fill in all fields correctly", Toast.LENGTH_SHORT).show()
            } else {
                // TODO: Update the item in the database
                Toast.makeText(requireContext(), "$category stock updated", Toast.LENGTH_SHORT).show()
                itemNameInput.text.clear()
                itemSizeInput.text.clear()
                itemQuantityInput.text.clear()
            }
        }

        return view
    }
}
