package com.bottomupdrawer.demo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bottomupdrawer.demo.databinding.ActivityMainBinding
import lib.bottomupdrawer.BasicBottomSheet

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnBasic.setOnClickListener {
            startActivity(Intent(this@MainActivity, BasicActivity::class.java))
        }
    }
}