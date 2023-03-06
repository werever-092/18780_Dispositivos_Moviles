package edu.iest.aip_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import edu.iest.aip_test.fragments.CollectionAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val collectionAdapter = CollectionAdapter(this)
        val viewPager: ViewPager2 = findViewById(R.id.vp2Begin)
        viewPager.adapter = collectionAdapter

    }
}