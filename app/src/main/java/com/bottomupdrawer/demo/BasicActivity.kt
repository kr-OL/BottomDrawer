package com.bottomupdrawer.demo

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bottomupdrawer.demo.databinding.ActivityBasicBinding
import com.bottomupdrawer.demo.databinding.ActivityMainBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import lib.bottomupdrawer.BasicBottomSheet

class BasicActivity : AppCompatActivity() {
    lateinit var binding: ActivityBasicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding = ActivityBasicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val titleFragment = TitleFragment()
        val bodyFragment = BodyFragment()

//        val callback = (object : BottomSheetBehavior.BottomSheetCallback() {
//            override fun onSlide(bottomSheet: View, slideOffset: Float) {
//            }
//
//            override fun onStateChanged(bottomSheet: View, newState: Int) {
//                when (newState) {
//                    BottomSheetBehavior.STATE_COLLAPSED -> Toast.makeText(this@BasicActivity, "STATE_COLLAPSED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_EXPANDED -> Toast.makeText(this@BasicActivity, "STATE_EXPANDED", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_DRAGGING -> Toast.makeText(this@BasicActivity, "STATE_DRAGGING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_SETTLING -> Toast.makeText(this@BasicActivity, "STATE_SETTLING", Toast.LENGTH_SHORT).show()
//                    BottomSheetBehavior.STATE_HIDDEN -> Toast.makeText(this@BasicActivity, "STATE_HIDDEN", Toast.LENGTH_SHORT).show()
//                    else -> Toast.makeText(this@BasicActivity, "OTHER_STATE", Toast.LENGTH_SHORT).show()
//                }
//            }
//        })

        BasicBottomSheet
            .Begin(activity = this@BasicActivity)
            .hide(false)
            .peekHeight(60)
            .addTitle(titleFragment)
            .addContents(bodyFragment)
//            .addCallBack(callback)
            .commit()
    }
}