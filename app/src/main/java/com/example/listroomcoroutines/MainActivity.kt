package com.example.listroomcoroutines

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.listroomcoroutines.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = listOf(
            DataItem("Test 1", true)
        )

        setupRecyclerView(items)

        binding.textInputEditText.onFocusChangeListener = View.OnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val input = binding.textInputEditText.text.toString()
                val isBookmarked = true
                val newItem = DataItem(input, isBookmarked)
                val newItems = items + newItem
                setupRecyclerView(newItems)
            }
        }
    }

    private fun setupRecyclerView(items : List<DataItem>) {
        binding.ListNameRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.ListNameRecyclerView.adapter = DataItemAdapter(items)
    }
}