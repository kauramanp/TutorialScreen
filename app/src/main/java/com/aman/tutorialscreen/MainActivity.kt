package com.aman.tutorialscreen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.aman.tutorialscreen.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewPagerAdapter: ViewPagerAdapter
    lateinit var dotsAdapter: DotsAdapter
    var layoutsArray = mutableListOf(R.layout.layout_one, R.layout.layout_two, R.layout.layout_three, R.layout.layout_four)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewPagerAdapter = ViewPagerAdapter(layoutsArray)
        dotsAdapter = DotsAdapter(this, layoutsArray.size)
        binding.viewPager.apply {
            adapter = viewPagerAdapter
        }
        binding.recyclerView.apply {
            adapter = dotsAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.HORIZONTAL, false)
        }

        binding.viewPager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                    dotsAdapter.updatePosition(position)
                }
            })
    }
}