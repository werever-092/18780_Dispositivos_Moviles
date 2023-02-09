package edu.iest.android_wear

import android.app.Activity
import android.os.Bundle
import edu.iest.android_wear.databinding.ActivityWatchBinding

class MainActivity : Activity() {

    private lateinit var binding: ActivityWatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        binding = ActivityWatchBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}